package fr.epsi.backend.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DrugstoreFormationId implements Serializable {

    @Column(name = "drugstore_id")
    private Long drugstoreId;
    @Column(name = "formation_id")
    private Long formationId;

    public DrugstoreFormationId() {
    }

    public DrugstoreFormationId(Long drugstoreId, Long formationId) {
        this.drugstoreId = drugstoreId;
        this.formationId = formationId;
    }

    public Long getDrugstoreId() {
        return drugstoreId;
    }

    public void setDrugstoreId(Long drugstoreId) {
        this.drugstoreId = drugstoreId;
    }

    public Long getFormationId() {
        return formationId;
    }

    public void setFormationId(Long formationId) {
        this.formationId = formationId;
    }
}
