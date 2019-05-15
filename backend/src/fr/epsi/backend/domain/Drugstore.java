package fr.epsi.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "drugstore")
public class Drugstore implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int latitude;
    @Column(nullable = false)
    private int longitude;

    @OneToMany(mappedBy = "drugstore")
    private Set<DrugstoreFormation> formations = new HashSet<DrugstoreFormation>();

    @OneToMany(mappedBy = "drugstore")
    private Set<ProductPrice> productPrices = new HashSet<ProductPrice>();

    @OneToMany(mappedBy = "drugstore")
    private Set<DrugstoreProduct> products = new HashSet<DrugstoreProduct>();

    public Drugstore() {
    }

    public Drugstore(int latitude, int longitude, Set<DrugstoreFormation> formations, Set<ProductPrice> productPrices, Set<DrugstoreProduct> products) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.formations = formations;
        this.productPrices = productPrices;
        this.products = products;
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public Set<DrugstoreFormation> getFormations() {
        return formations;
    }

    public void setFormations(Set<DrugstoreFormation> formations) {
        this.formations = formations;
    }

    public Set<ProductPrice> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(Set<ProductPrice> productPrices) {
        this.productPrices = productPrices;
    }

    public Set<DrugstoreProduct> getProducts() {
        return products;
    }

    public void setProducts(Set<DrugstoreProduct> products) {
        this.products = products;
    }
}
