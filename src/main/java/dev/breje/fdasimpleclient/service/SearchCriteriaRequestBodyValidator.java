package dev.breje.fdasimpleclient.service;

import dev.breje.fdasimpleclient.exceptions.RequestValidationException;
import dev.breje.fdasimpleclient.model.request.SearchCriteriaRequestBody;

import java.util.Objects;
import java.util.Set;

public class SearchCriteriaRequestBodyValidator {

    private static final Set<String> SUBMISSION_STATUS_VALID_VALUES = Set.of("AP", "TA");

    public void validate(SearchCriteriaRequestBody searchCriteria) throws RequestValidationException {
        if (Objects.isNull(searchCriteria.getManufacturerName())) {
            throw new RequestValidationException("The manufacturer name is missing. Please provide a value for [manufacturerName] field.");
        }
        if (Objects.isNull(searchCriteria.getSubmissionStatus())) {
            throw new RequestValidationException("The submission status is missing. Please provide a value for [submissionStatus] field.");
        }
        if (!SUBMISSION_STATUS_VALID_VALUES.contains(searchCriteria.getSubmissionStatus())) {
            throw new RequestValidationException("The submission status is not valid. Valid values are [AP, TA]. Please provide a valid value.");
        }

    }
}
