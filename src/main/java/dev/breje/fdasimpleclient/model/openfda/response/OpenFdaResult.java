package dev.breje.fdasimpleclient.model.openfda.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpenFdaResult {

    @SerializedName("application_number")
    private String applicationNumber;

    private List<OpenFdaProduct> products;

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public List<OpenFdaProduct> getProducts() {
        return products;
    }
}
