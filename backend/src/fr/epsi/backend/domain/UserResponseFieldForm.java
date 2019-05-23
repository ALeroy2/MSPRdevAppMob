package fr.epsi.backend.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_to_response_to_field_to_form")
public class UserResponseFieldForm implements Serializable {

    @EmbeddedId
    UserResponseFieldFormId pk;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("userEmail")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("responseId")
    private Response response;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("fieldId")
    private Field field;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("formId")
    private Form form;

    public UserResponseFieldForm() {
    }

    public UserResponseFieldForm(User user, Response response, Field field, Form form) {
        this.user = user;
        this.response = response;
        this.field = field;
        this.form = form;
    }

    public UserResponseFieldFormId getPk() {
        return pk;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }
}
