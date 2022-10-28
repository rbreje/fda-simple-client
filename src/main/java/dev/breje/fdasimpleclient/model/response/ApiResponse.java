package dev.breje.fdasimpleclient.model.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ApiResponse {

    @JsonInclude(value = Include.NON_EMPTY)
    private String errorMessage;

    @JsonInclude(value = Include.NON_EMPTY)
    private String total;

    @JsonInclude(value = Include.NON_EMPTY)
    private String nextPage;

    @JsonInclude(value = Include.NON_EMPTY)
    private List<Result> results = new ArrayList<>();

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return StringUtils.isBlank(errorMessage);
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
