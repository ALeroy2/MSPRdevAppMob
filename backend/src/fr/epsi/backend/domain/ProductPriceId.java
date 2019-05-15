package fr.epsi.backend.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductPriceId implements Serializable {

    @Column(name = "product_id")
    private long productId;

    @Column(name = "drugstore_id")
    private long drugstore_id;

    public ProductPriceId() {
    }

    public ProductPriceId(long productId, long drugstore_id) {
        this.productId = productId;
        this.drugstore_id = drugstore_id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getDrugstore_id() {
        return drugstore_id;
    }

    public void setDrugstore_id(long drugstore_id) {
        this.drugstore_id = drugstore_id;
    }
}
