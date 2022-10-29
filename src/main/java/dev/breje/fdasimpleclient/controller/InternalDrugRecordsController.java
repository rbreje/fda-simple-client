package dev.breje.fdasimpleclient.controller;

import dev.breje.fdasimpleclient.exceptions.DuplicateDatabaseRecordException;
import dev.breje.fdasimpleclient.model.DomainObjectsFactory;
import dev.breje.fdasimpleclient.model.entity.DrugRecordEntity;
import dev.breje.fdasimpleclient.model.request.DrugRecordRequestBody;
import dev.breje.fdasimpleclient.model.response.ApiResponse;
import dev.breje.fdasimpleclient.model.response.DomainObjectsConverter;
import dev.breje.fdasimpleclient.model.response.DrugRecordDto;
import dev.breje.fdasimpleclient.model.response.DrugRecordsApiResponse;
import dev.breje.fdasimpleclient.repository.AppRepository;
import dev.breje.fdasimpleclient.repository.DrugRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/local")
public class InternalDrugRecordsController {

    @Autowired
    private DomainObjectsFactory domainObjectsFactory;

    @Autowired
    private DrugRecordRepository drugRecordsRepository;

    @Autowired
    private AppRepository defaultAppRepository;

    @GetMapping(value = "/records/{id}")
    public ResponseEntity<DrugRecordsApiResponse> getDrugRecordById(@PathVariable(value = "id") String id) {
        Optional<DrugRecordEntity> optional = defaultAppRepository.findDrugRecordById(id);
        if (optional.isPresent()) {
            DrugRecordDto drugRecord = DomainObjectsConverter.fromDrugRecordEntity(optional.get());
            DrugRecordsApiResponse apiResponse = domainObjectsFactory.createDrugRecordsApiResponse(drugRecord);
            return new ResponseEntity<>(apiResponse, new HttpHeaders(), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/records")
    public ResponseEntity<DrugRecordsApiResponse> findAllDrugRecords() {
        List<DrugRecordEntity> drugRecordEntities = defaultAppRepository.findAllDrugRecords();

        List<DrugRecordDto> drugRecords = DomainObjectsConverter.fromDrugRecordEntities(drugRecordEntities);
        DrugRecordsApiResponse apiResponse = domainObjectsFactory.createDrugRecordsApiResponse(drugRecords);

        return new ResponseEntity<>(apiResponse, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/records")
    public ResponseEntity<?> saveDrugRecord(@RequestBody DrugRecordRequestBody drugRecordRequestBody) {
        DrugRecordDto drugRecord = DomainObjectsConverter.fromDrugRecordRequestBody(drugRecordRequestBody);
        DrugRecordEntity drugRecordEntity = DomainObjectsConverter.fromDrugRecordDto(drugRecord);

        try {
            defaultAppRepository.saveDrugRecord(drugRecordEntity);
        } catch (DuplicateDatabaseRecordException e) {
            ApiResponse apiResponse = new ApiResponse();
            apiResponse.setErrorMessage(e.getMessage());

            return new ResponseEntity<>(apiResponse, HttpStatus.CONFLICT);
        }

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

}
