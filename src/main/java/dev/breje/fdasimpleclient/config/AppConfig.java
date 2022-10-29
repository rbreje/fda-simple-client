package dev.breje.fdasimpleclient.config;

import com.google.gson.Gson;
import dev.breje.fdasimpleclient.model.DomainObjectsFactory;
import dev.breje.fdasimpleclient.service.PaginationService;
import dev.breje.fdasimpleclient.service.SearchCriteriaRequestBodyValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Value("${open_fda.rootUrl}")
    private String openFdaUrl;

    @Bean
    public WebClient getWebClient() {
        return WebClient.builder()
                        .baseUrl(openFdaUrl)
                        .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                        .build();
    }

    @Bean
    public Gson getGson() {
        return new Gson();
    }

    @Bean
    public PaginationService getPaginationService() {
        return new PaginationService();
    }

    @Bean
    public DomainObjectsFactory getDomainObjectsFactory() {
        return new DomainObjectsFactory();
    }

    @Bean
    public SearchCriteriaRequestBodyValidator getSearchCriteriaRequestBodyValidator() {
        return new SearchCriteriaRequestBodyValidator();
    }
}
