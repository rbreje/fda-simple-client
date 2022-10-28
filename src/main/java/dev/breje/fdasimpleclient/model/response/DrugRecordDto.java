package dev.breje.fdasimpleclient.model.response;

import dev.breje.fdasimpleclient.model.helper.SimpleProduct;

import java.util.List;

public class DrugRecordDto {

    private String applicationNumber;

    private String manufacturerName;

    private String substanceName;

    private List<SimpleProduct> products;

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getSubstanceName() {
        return substanceName;
    }

    public void setSubstanceName(String substanceName) {
        this.substanceName = substanceName;
    }

    public List<SimpleProduct> getProducts() {
        return products;
    }

    public void setProducts(List<SimpleProduct> products) {
        this.products = products;
    }
}
