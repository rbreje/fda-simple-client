package dev.breje.fdasimpleclient.model.response.openfda;

import java.util.List;
import java.util.Objects;

public class OpenFdaApiResponse {

    private ErrorDetails error;

    private MetaInfo meta;

    private List<OpenFdaResult> results;

    public ErrorDetails getError() {
        return error;
    }

    public MetaInfo getMeta() {
        return meta;
    }

    public List<OpenFdaResult> getResults() {
        return results;
    }

    public String getTotalOccurrences() {
        return String.valueOf(getMeta().getResults().getTotal());
    }

    public boolean isSuccess() {
        return Objects.isNull(error);
    }
}
