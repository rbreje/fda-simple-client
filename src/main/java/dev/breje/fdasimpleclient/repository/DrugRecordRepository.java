package dev.breje.fdasimpleclient.repository;

import dev.breje.fdasimpleclient.model.entity.DrugRecordEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrugRecordRepository extends CrudRepository<DrugRecordEntity, String> {
}
