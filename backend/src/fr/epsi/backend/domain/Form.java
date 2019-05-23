package fr.epsi.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "form")
public class Form implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "field_to_form",
            joinColumns = { @JoinColumn(name = "form_id") },
            inverseJoinColumns = { @JoinColumn(name = "field_id") }
    )
    Set<Field> fields = new HashSet<>();

    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL)
    private Set<ResponseFieldForm> responseFieldForms = new HashSet<>();

    public Form() {
    }

    public Form(String name) {
        this.name = name;
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

    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }

    public void addField(Field field) {
        this.fields.add(field);
    }

    public Set<ResponseFieldForm> getResponseFieldForms() {
        return responseFieldForms;
    }

    public void setResponseFieldForms(Set<ResponseFieldForm> responseFieldForms) {
        this.responseFieldForms = responseFieldForms;
    }
}
