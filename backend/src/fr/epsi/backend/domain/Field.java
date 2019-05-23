package fr.epsi.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "field")
public class Field implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    @ManyToMany(mappedBy = "fields")
    private Set<Form> forms = new HashSet<>();

    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private Set<ResponseFieldForm> responseFieldForms = new HashSet<>();

    public Field() {
    }

    public Field(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<Form> getForms() {
        return forms;
    }

    public void setForms(Set<Form> forms) {
        this.forms = forms;
    }

    public Set<ResponseFieldForm> getResponseFieldForms() {
        return responseFieldForms;
    }

    public void setResponseFieldForms(Set<ResponseFieldForm> responseFieldForms) {
        this.responseFieldForms = responseFieldForms;
    }
}
