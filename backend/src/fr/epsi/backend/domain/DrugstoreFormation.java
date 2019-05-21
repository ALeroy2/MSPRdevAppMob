package fr.epsi.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "drugstore_to_formation")
public class DrugstoreFormation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Formation formation;

    @ManyToOne
    private Drugstore drugstore;

    @Column(name = "drugstore_to_formation_date", nullable = false)
    private Date dateDrugstoreFormation;

    public DrugstoreFormation() {
    }

    public DrugstoreFormation(Formation formation, Drugstore drugstore, Date dateDrugstoreFormation) {
        this.formation = formation;
        this.drugstore = drugstore;
        this.dateDrugstoreFormation = dateDrugstoreFormation;
    }

    public Long getId() {
        return id;
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
