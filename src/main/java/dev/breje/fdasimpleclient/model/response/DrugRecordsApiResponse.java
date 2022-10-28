package dev.breje.fdasimpleclient.model.response;

import java.util.List;

public class DrugRecordsApiResponse {

    private List<DrugRecordDto> drugRecords;

    public DrugRecordsApiResponse(List<DrugRecordDto> drugRecords) {
        this.drugRecords = drugRecords;
    }

    public List<DrugRecordDto> getDrugRecords() {
        return drugRecords;
    }

    public void setDrugRecords(List<DrugRecordDto> drugRecords) {
        this.drugRecords = drugRecords;
    }
}
