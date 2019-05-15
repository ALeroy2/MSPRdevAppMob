package fr.epsi.backend.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductPriceId implements Serializable {

    @Column(name = "product_id")
    private long productId;

    @Column(name = "drugstore_id")
    private long drugstoreId;

    public ProductPriceId() {
    }

    public ProductPriceId(long productId, long drugstoreId) {
        this.productId = productId;
        this.drugstoreId = drugstoreId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getDrugstore_id() {
        return drugstoreId;
    }

    public void setDrugstore_id(long drugstoreId) {
        this.drugstoreId = drugstoreId;
    }
}
