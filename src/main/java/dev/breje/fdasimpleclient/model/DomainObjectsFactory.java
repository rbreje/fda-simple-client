package dev.breje.fdasimpleclient.model;

import dev.breje.fdasimpleclient.model.response.ApiResponse;
import dev.breje.fdasimpleclient.model.response.DrugRecordDto;
import dev.breje.fdasimpleclient.model.response.DrugRecordsApiResponse;

import java.util.Arrays;
import java.util.List;

public class DomainObjectsFactory {

    public DrugRecordsApiResponse createDrugRecordsApiResponse(List<DrugRecordDto> drugRecords) {
        return new DrugRecordsApiResponse(drugRecords);
    }

    public DrugRecordsApiResponse createDrugRecordsApiResponse(DrugRecordDto drugRecord) {
        return new DrugRecordsApiResponse(Arrays.asList(drugRecord));
    }

    public ApiResponse createApiResponseFromError(String errorMessage) {
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setErrorMessage(errorMessage);
        return apiResponse;
    }

}
