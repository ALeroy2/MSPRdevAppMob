package fr.epsi.backend.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "drugstore_to_product_buy")
public class DrugstoreProductBuy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    private Drugstore drugstore;

    @Column(name = "drugstore_to_product_buy_date", nullable = false)
    private Date dateBuy;

    @Column(name = "drugstore_to_product_buy_price", nullable = false)
    private float price;

    public DrugstoreProductBuy() {
    }

    public DrugstoreProductBuy(Product product, Drugstore drugstore, Date dateSell, float price) {
        this.product = product;
        this.drugstore = drugstore;
        this.dateBuy = dateSell;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if (this.product != null) {
            this.product.getDrugstoresBuy().remove(this);
        }
        this.product = product;
        if (this.product != null) {
            this.product.getDrugstoresBuy().add(this);
        }
    }

    public Drugstore getDrugstore() {
        return drugstore;
    }

    public void setDrugstore(Drugstore drugstore) {
        if (this.drugstore != null) {
            this.drugstore.getProductsBuy().remove(this);
        }
        this.drugstore = drugstore;
        if (this.drugstore != null) {
            this.drugstore.getProductsBuy().add(this);
        }
    }

    public Date getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
