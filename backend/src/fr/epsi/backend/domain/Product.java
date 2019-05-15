package fr.epsi.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "product")
    private Set<ProductPrice> drugstorePrices = new HashSet<ProductPrice>();

    @OneToMany(mappedBy = "product")
    private Set<DrugstoreProduct> drugstores = new HashSet<DrugstoreProduct>();

    public Product() {
    }

    public Product(String name, Set<ProductPrice> drugstorePrices, Set<DrugstoreProduct> drugstores) {
        this.name = name;
        this.drugstorePrices = drugstorePrices;
        this.drugstores = drugstores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ProductPrice> getDrugstorePrices() {
        return drugstorePrices;
    }

    public void setDrugstorePrices(Set<ProductPrice> drugstorePrices) {
        this.drugstorePrices = drugstorePrices;
    }

    public Set<DrugstoreProduct> getDrugstores() {
        return drugstores;
    }

    public void setDrugstores(Set<DrugstoreProduct> drugstores) {
        this.drugstores = drugstores;
    }
}
