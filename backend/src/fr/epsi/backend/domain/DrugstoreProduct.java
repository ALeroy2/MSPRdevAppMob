package fr.epsi.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "drugstore_to_product")
public class DrugstoreProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="is_sold", nullable = false)
    private boolean isSold;

    @Column(name = "drugstore_product_date", nullable = false)
    private Date dateDrugstoreProduct;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "drugstore_id")
    private Drugstore drugstore;

    public DrugstoreProduct() {
    }

    public DrugstoreProduct(boolean isSold, Date dateDrugstoreProduct, Product product, Drugstore drugstore) {
        this.isSold = isSold;
        this.dateDrugstoreProduct = dateDrugstoreProduct;
        this.product = product;
        this.drugstore = drugstore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public Date getDateDrugstoreProduct() {
        return dateDrugstoreProduct;
    }

    public void setDateDrugstoreProduct(Date dateDrugstoreProduct) {
        this.dateDrugstoreProduct = dateDrugstoreProduct;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if (this.product != null) {
            this.product.getDrugstores().remove(this);
        }
        this.product = product;
        if (this.product != null) {
            this.product.getDrugstores().add(this);
        }
    }

    public Drugstore getDrugstore() {
        return drugstore;
    }

    public void setDrugstore(Drugstore drugstore) {
        if (this.drugstore != null) {
            this.drugstore.getProducts().remove(this);
        }
        this.drugstore = drugstore;
        if (this.drugstore != null) {
            this.drugstore.getProducts().add(this);
        }
    }
}
