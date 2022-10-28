package dev.breje.fdasimpleclient.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "records")
public class DrugRecordEntity {

    @Id
    @Column(name = "application_number")
    private String applicationNumber;

    @Column(name = "manufacturer_name")
    private String manufacturerName;

    @Column(name = "substance_name")
    private String substanceName;

    @OneToMany(mappedBy = "record")
    private Set<ProductsOfDrugRecordEntity> products;

    public DrugRecordEntity() {
    }

    public DrugRecordEntity(String applicationNumber, String manufacturerName, String substanceName, Set<ProductsOfDrugRecordEntity> products) {
        this.applicationNumber = applicationNumber;
        this.manufacturerName = manufacturerName;
        this.substanceName = substanceName;
        this.products = products;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getManufacturerName() {
        return manufacturerName;
    }

    public void setManufacturerName(String manufacturerName) {
        this.manufacturerName = manufacturerName;
    }

    public String getSubstanceName() {
        return substanceName;
    }

    public void setSubstanceName(String substanceName) {
        this.substanceName = substanceName;
    }

    public Set<ProductsOfDrugRecordEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductsOfDrugRecordEntity> products) {
        this.products = products;
    }
}
