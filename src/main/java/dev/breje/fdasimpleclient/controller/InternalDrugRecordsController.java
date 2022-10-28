package dev.breje.fdasimpleclient.controller;

import dev.breje.fdasimpleclient.model.DomainObjectsFactory;
import dev.breje.fdasimpleclient.model.entity.DrugRecordEntity;
import dev.breje.fdasimpleclient.model.response.DomainObjectsConverter;
import dev.breje.fdasimpleclient.model.response.DrugRecordDto;
import dev.breje.fdasimpleclient.model.response.DrugRecordsApiResponse;
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

    @GetMapping(value = "/records/{id}")
    public ResponseEntity<DrugRecordsApiResponse> getDrugRecordById(@PathVariable(value = "id") String id) {
        Optional<DrugRecordEntity> optional = drugRecordsRepository.findById(id);
        if (optional.isPresent()) {
            DrugRecordDto drugRecord = DomainObjectsConverter.fromDrugRecordEntity(optional.get());
            DrugRecordsApiResponse apiResponse = domainObjectsFactory.createDrugRecordsApiResponse(drugRecord);
            return new ResponseEntity<>(apiResponse, new HttpHeaders(), HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/records")
    public ResponseEntity<DrugRecordsApiResponse> getAllDrugRecords() {
        List<DrugRecordEntity> drugRecordEntities = (List<DrugRecordEntity>) drugRecordsRepository.findAll();

        List<DrugRecordDto> drugRecords = DomainObjectsConverter.fromDrugRecordEntities(drugRecordEntities);
        DrugRecordsApiResponse apiResponse = domainObjectsFactory.createDrugRecordsApiResponse(drugRecords);

        return new ResponseEntity<>(apiResponse, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping(value = "/records")
    public void saveDrugRecord() {
//        drugRecordsRepository.save();
    }

}
