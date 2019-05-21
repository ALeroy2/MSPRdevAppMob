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
    @Column(nullable = false)
    private float price;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<DrugstoreProductSell> drugstoresSell = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<DrugstoreProductBuy> drugstoresBuy = new HashSet<>();

    public Product() {
    }

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, float price, Set<DrugstoreProductSell> drugstoresSell, Set<DrugstoreProductBuy> drugstoresBuy) {
        this.name = name;
        this.price = price;
        this.drugstoresSell = drugstoresSell;
        this.drugstoresBuy = drugstoresBuy;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Set<DrugstoreProductSell> getDrugstoresSell() {
        return drugstoresSell;
    }

    public void setDrugstoresSell(Set<DrugstoreProductSell> drugstoresSell) {
        this.drugstoresSell = drugstoresSell;
    }

    public Set<DrugstoreProductBuy> getDrugstoresBuy() {
        return drugstoresBuy;
    }

    public void setDrugstoresBuy(Set<DrugstoreProductBuy> drugstoresBuy) {
        this.drugstoresBuy = drugstoresBuy;
    }

    public void addDrugstoreBuy(DrugstoreProductBuy drugstoreProductBuy) {
        drugstoreProductBuy.setProduct(this);
    }

    public void addDrugstoreSell(DrugstoreProductSell drugstoreProductSell) {
        drugstoreProductSell.setProduct(this);
    }
}
