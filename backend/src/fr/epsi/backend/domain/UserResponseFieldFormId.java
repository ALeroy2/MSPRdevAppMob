package fr.epsi.backend.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class UserResponseFieldFormId implements Serializable {

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "response_id")
    private Long responseId;
    @Column(name = "field_id")
    private Long fieldId;
    @Column(name = "form_id")
    private Long formId;

    public UserResponseFieldFormId() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getResponseId() {
        return responseId;
    }

    public void setResponseId(Long responseId) {
        this.responseId = responseId;
    }

    public Long getFieldId() {
        return fieldId;
    }

    public void setFieldId(Long fieldId) {
        this.fieldId = fieldId;
    }

    public Long getFormId() {
        return formId;
    }

    public void setFormId(Long formId) {
        this.formId = formId;
    }
}
