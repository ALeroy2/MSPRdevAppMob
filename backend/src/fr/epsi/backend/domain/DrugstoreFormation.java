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
    @MapsId("drugstoreId")
    private Drugstore drugstore;

    @ManyToOne
    @MapsId("formationId")
    private Formation formation;

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
        this.drugstore = drugstore;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
}
