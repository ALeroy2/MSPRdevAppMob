package fr.epsi.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "drugstore_to_product_sell")
public class DrugstoreProductSell implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product;

    @ManyToOne(cascade = CascadeType.ALL)
    private Drugstore drugstore;

    @Column(name = "drugstore_to_product_sell_date")
    private Date dateSell;

    @Column(name = "drugstore_to_product_sell_price", nullable = false)
    private float price;

    public DrugstoreProductSell() {
    }

    public DrugstoreProductSell(Product product, Drugstore drugstore, Date dateSell, float price) {
        this.product = product;
        this.drugstore = drugstore;
        this.price = price;
        this.dateSell = dateSell;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if (this.product != null) {
            this.product.getDrugstoresSell().remove(this);
        }
        this.product = product;
        if (this.product != null) {
            this.product.getDrugstoresSell().add(this);
        }
    }

    public Drugstore getDrugstore() {
        return drugstore;
    }

    public void setDrugstore(Drugstore drugstore) {
        if (this.drugstore != null) {
            this.drugstore.getProductsSell().remove(this);
        }
        this.drugstore = drugstore;
        if (this.drugstore != null) {
            this.drugstore.getProductsSell().add(this);
        }
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getDateSell() {
        return dateSell;
    }

    public void setDateSell(Date dateSell) {
        this.dateSell = dateSell;
    }
}
