package dev.breje.fdasimpleclient.controller;

import com.google.gson.Gson;
import dev.breje.fdasimpleclient.exceptions.RequestValidationException;
import dev.breje.fdasimpleclient.model.DomainObjectsFactory;
import dev.breje.fdasimpleclient.model.request.SearchCriteriaRequestBody;
import dev.breje.fdasimpleclient.model.response.ApiResponse;
import dev.breje.fdasimpleclient.model.response.DomainObjectsConverter;
import dev.breje.fdasimpleclient.model.response.openfda.OpenFdaApiResponse;
import dev.breje.fdasimpleclient.service.PaginationService;
import dev.breje.fdasimpleclient.service.SearchCriteriaRequestBodyValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/openfda")
public class OpenFdaDrugRecordsController {

    @Autowired
    private WebClient webClient;

    @Autowired
    private Gson gson;

    @Autowired
    private PaginationService paginationService;

    @Autowired
    private SearchCriteriaRequestBodyValidator searchCriteriaRequestBodyValidator;

    @Autowired
    private DomainObjectsFactory domainObjectsFactory;

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public ResponseEntity<ApiResponse> getDrugRecord(@RequestBody SearchCriteriaRequestBody searchCriteria, @RequestParam(required = false, defaultValue = "0") String skip) {
        try {
            searchCriteriaRequestBodyValidator.validate(searchCriteria);
        } catch (RequestValidationException e) {
            return new ResponseEntity<>(domainObjectsFactory.createApiResponseFromError(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

        String searchCondition = getSanitizedSearchCondition(searchCriteria);
        String unparsedResponse = webClient.get()
                                           .uri(uriBuilder -> uriBuilder.queryParam("search", searchCondition)
                                                                        .queryParam("limit", "10")
                                                                        .queryParam("skip", skip)
                                                                        .build())
                                           .retrieve()
                                           .bodyToMono(String.class)
                                           .onErrorResume(WebClientResponseException.class, ex -> Mono.just(ex.getResponseBodyAsString()))
                                           .block();

        OpenFdaApiResponse response = gson.fromJson(unparsedResponse, OpenFdaApiResponse.class);

        ApiResponse result = parseResponse(response, skip);

        return new ResponseEntity<>(result, new HttpHeaders(), HttpStatus.OK);
    }

    private String getSanitizedSearchCondition(SearchCriteriaRequestBody searchCriteria) {
        StringBuilder sb = new StringBuilder();
        sb.append("submissions.submission_status:\"")
          .append(searchCriteria.getSubmissionStatus())
          .append("\"");
        sb.append("+AND+openfda.manufacturer_name:\"")
          .append(searchCriteria.getManufacturerName())
          .append("\"");
        if (StringUtils.isNotBlank(searchCriteria.getBrandName())) {
            sb.append("+AND+openfda.brand_name:\"")
              .append(searchCriteria.getBrandName())
              .append("\"");
        }
        return sb.toString();
    }

    private ApiResponse parseResponse(OpenFdaApiResponse unparsedResponse, String skip) {
        ApiResponse response = DomainObjectsConverter.fromOpenFdaApiResponse(unparsedResponse);
        if (response.isSuccess()) {
            response.setNextPage(paginationService.getNextPage("/api/openfda/records", skip, unparsedResponse.getTotalOccurrences()));
        }
        return response;
    }

}
