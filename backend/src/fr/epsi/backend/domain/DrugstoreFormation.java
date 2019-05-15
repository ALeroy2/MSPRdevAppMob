package fr.epsi.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "drugstore_to_formation")
public class DrugstoreFormation implements Serializable {

    @EmbeddedId
    DrugstoreFormationId pk;

    @ManyToOne
    @MapsId("formationId")
    private Formation formation;

    @ManyToOne
    @MapsId("drugstoreId")
    private Drugstore drugstore;

    @Column(name = "drugstore_formation_date", nullable = false)
    private Date dateDrugstoreFormation;

    public DrugstoreFormation() {
    }

    public DrugstoreFormation(DrugstoreFormationId pk, Drugstore drugstore, Formation formation, Date dateDrugstoreFormation) {
        this.pk = pk;
        this.drugstore = drugstore;
        this.formation = formation;
        this.dateDrugstoreFormation = dateDrugstoreFormation;
    }

    public DrugstoreFormationId getPk() {
        return pk;
    }

    public void setPk(DrugstoreFormationId pk) {
        this.pk = pk;
    }

    public Date getDateDrugstoreFormation() {
        return dateDrugstoreFormation;
    }

    public void setDateDrugstoreFormation(Date dateDrugstoreFormation) {
        this.dateDrugstoreFormation = dateDrugstoreFormation;
    }

    public Drugstore getDrugstore() {
        return drugstore;
    }

    public void setDrugstore(Drugstore drugstore) {
        if (this.drugstore != null) {
            this.drugstore.getFormations().remove(this);
        }
        this.drugstore = drugstore;
        if (this.drugstore != null) {
            this.drugstore.getFormations().add(this);
        }
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        if (this.formation != null) {
            this.formation.getDrugstores().remove(this);
        }
        this.formation = formation;
        if (this.formation != null) {
            this.formation.getDrugstores().add(this);
        }
    }
}
