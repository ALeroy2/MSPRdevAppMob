package fr.epsi.backend.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "drugstore_to_product_price")
public class ProductPrice implements Serializable {

    @EmbeddedId
    ProductPriceId pk;

    @ManyToOne
    @MapsId("drugstoreId")
    private Drugstore drugstore;

    @ManyToOne
    @MapsId("productId")
    private Product product;

    @Column(nullable = false)
    private float price;

    public ProductPrice() {
    }

    public ProductPrice(ProductPriceId pk, Drugstore drugstore, Product product, float price) {
        this.pk = pk;
        this.drugstore = drugstore;
        this.product = product;
        this.price = price;
    }

    public ProductPriceId getPk() {
        return pk;
    }

    public void setPk(ProductPriceId pk) {
        this.pk = pk;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Drugstore getDrugstore() {
        return drugstore;
    }

    public void setDrugstore(Drugstore drugstore) {
        this.drugstore = drugstore;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
