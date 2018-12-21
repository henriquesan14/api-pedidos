package br.com.henrique.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    private String entityNaame;
    private String fieldName;
    private Object fieldValue;

    public EntityNotFoundException(String entityNaame, String fieldName, Object fieldValue){
        super(entityNaame +"s not found with "+fieldName+"s : '"+fieldValue+"'");
        this.entityNaame = entityNaame;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public String getEntityNaame() {
        return entityNaame;
    }

    public String getFieldName() {
        return fieldName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
