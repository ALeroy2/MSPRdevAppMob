package fr.epsi.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "formation")
public class Formation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "formation")
    private Set<DrugstoreFormation> drugstores = new HashSet<DrugstoreFormation>();

    public Formation() {
    }

    public Formation(String name, Set<DrugstoreFormation> drugstores) {
        this.name = name;
        this.drugstores = drugstores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DrugstoreFormation> getDrugstores() {
        return drugstores;
    }

    public void setDrugstores(Set<DrugstoreFormation> drugstores) {
        this.drugstores = drugstores;
    }
}
