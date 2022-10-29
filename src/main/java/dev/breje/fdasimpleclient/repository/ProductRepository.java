package dev.breje.fdasimpleclient.repository;

import dev.breje.fdasimpleclient.model.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long> {
}
