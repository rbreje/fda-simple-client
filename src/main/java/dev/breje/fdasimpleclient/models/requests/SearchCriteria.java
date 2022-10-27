package dev.breje.fdasimpleclient.models.requests;

public class SearchCriteria {

    private String manufacturerName;

    private String brandName;

    public SearchCriteria(String manufacturerName, String brandName) {
        this.manufacturerName = manufacturerName;
        this.brandName = brandName;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
