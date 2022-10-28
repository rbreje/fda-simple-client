package dev.breje.fdasimpleclient.model.request;

import dev.breje.fdasimpleclient.model.helper.SimpleProduct;

import java.util.List;

public class DrugRecordRequestBody {

    private String applicationNumber;

    private String manufacturerName;

    private String substanceName;

    private List<SimpleProduct> products;

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public String getSubstanceName() {
        return substanceName;
    }

    public List<SimpleProduct> getProducts() {
        return products;
    }
}
