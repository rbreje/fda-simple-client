package dev.breje.fdasimpleclient.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "records_products")
public class ProductsOfDrugRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "application_number_id")
    DrugRecordEntity record;

    @ManyToOne
    @JoinColumn(name = "product_id")
    ProductEntity product;

    public ProductsOfDrugRecordEntity() {
    }

    public ProductsOfDrugRecordEntity(Long id, DrugRecordEntity record, ProductEntity product) {
        this.id = id;
        this.record = record;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DrugRecordEntity getRecord() {
        return record;
    }

    public void setRecord(DrugRecordEntity record) {
        this.record = record;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
