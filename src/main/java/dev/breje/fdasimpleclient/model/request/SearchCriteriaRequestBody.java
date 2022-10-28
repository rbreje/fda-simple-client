package dev.breje.fdasimpleclient.model.request;

public class SearchCriteriaRequestBody {

    // TODO add validation for nullity
    private String manufacturerName;

    private String brandName;

    // TODO add validation for two values: AP & TA
    private String submissionStatus;

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

    public String getSubmissionStatus() {
        return submissionStatus;
    }

    public void setSubmissionStatus(String submissionStatus) {
        this.submissionStatus = submissionStatus;
    }
}
