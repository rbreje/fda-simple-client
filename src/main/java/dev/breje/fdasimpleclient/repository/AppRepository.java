package dev.breje.fdasimpleclient.repository;

import dev.breje.fdasimpleclient.exceptions.DuplicateDatabaseRecordException;
import dev.breje.fdasimpleclient.model.entity.DrugRecordEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AppRepository {

    @Autowired
    private DrugRecordRepository drugRecordRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductsOfDrugRecordEntityRepository productsOfDrugRecordEntityRepository;

    public void saveDrugRecord(DrugRecordEntity drugRecordEntity) throws DuplicateDatabaseRecordException {
        Optional<DrugRecordEntity> existingRecords = drugRecordRepository.findById(drugRecordEntity.getApplicationNumber());
        if (existingRecords.isPresent()) {
            throw new DuplicateDatabaseRecordException("The provided record already exists. [applicationNumber=" + drugRecordEntity.getApplicationNumber() + "]");
        }

        drugRecordRepository.save(drugRecordEntity);
        drugRecordEntity.getProducts()
                        .forEach(product -> {
                            productRepository.save(product.getProduct());
                            productsOfDrugRecordEntityRepository.save(product);
                        });
    }

    public Optional<DrugRecordEntity> findDrugRecordById(String id) {
        return drugRecordRepository.findById(id);
    }

    public List<DrugRecordEntity> findAllDrugRecords() {
        return (List<DrugRecordEntity>) drugRecordRepository.findAll();
    }
}
