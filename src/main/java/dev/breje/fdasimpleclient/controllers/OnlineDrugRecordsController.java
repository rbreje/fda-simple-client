package dev.breje.fdasimpleclient.controllers;

import dev.breje.fdasimpleclient.models.requests.SearchCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class OnlineDrugRecordsController {

    @Autowired
    private WebClient webClient;

    @RequestMapping(value = "/records", method = RequestMethod.GET)
    public ResponseEntity<?> getDrugRecord(@RequestBody SearchCriteria searchCriteria) {
        System.out.println(searchCriteria.getManufacturerName());

        Mono<String> test = webClient.get()
                                     .uri("?search=openfda.manufacturer_name:\"" + searchCriteria.getManufacturerName() + "\"&limit=5")
                                     .retrieve()
                                     .bodyToMono(String.class);

        System.out.println(test.block());

        return ResponseEntity.ok(HttpStatus.OK);
    }

}
