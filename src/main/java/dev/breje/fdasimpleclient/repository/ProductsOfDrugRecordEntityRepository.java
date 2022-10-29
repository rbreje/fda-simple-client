package dev.breje.fdasimpleclient.repository;

import dev.breje.fdasimpleclient.model.entity.ProductsOfDrugRecordEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsOfDrugRecordEntityRepository extends CrudRepository<ProductsOfDrugRecordEntity, Long> {
}
