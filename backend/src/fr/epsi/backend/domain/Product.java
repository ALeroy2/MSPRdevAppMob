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
    private float productionPrice;
    @Column(nullable = false)
    private float wishSellProduct;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<DrugstoreProductSell> drugstoresSell = new HashSet<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<DrugstoreProductBuy> drugstoresBuy = new HashSet<>();

    public Product() {
    }

    public Product(String name, float productionPrice, float wishSellProduct) {
        this.name = name;
        this.productionPrice = productionPrice;
        this.wishSellProduct = wishSellProduct;
    }

    public Product(String name, float productionPrice, float wishSellProduct, Set<DrugstoreProductSell> drugstoresSell, Set<DrugstoreProductBuy> drugstoresBuy) {
        this.name = name;
        this.productionPrice = productionPrice;
        this.wishSellProduct = wishSellProduct;
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

    public float getProductionPrice() {
        return productionPrice;
    }

    public void setProductionPrice(float productionPrice) {
        this.productionPrice = productionPrice;
    }

    public float getWishSellProduct() {
        return wishSellProduct;
    }

    public void setWishSellProduct(float wishSellProduct) {
        this.wishSellProduct = wishSellProduct;
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
