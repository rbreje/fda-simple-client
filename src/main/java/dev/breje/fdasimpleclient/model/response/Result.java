package dev.breje.fdasimpleclient.model.response;

import java.util.ArrayList;
import java.util.List;

public class Result {

    private String applicationNumber;

    private List<Product> products = new ArrayList<>();

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
