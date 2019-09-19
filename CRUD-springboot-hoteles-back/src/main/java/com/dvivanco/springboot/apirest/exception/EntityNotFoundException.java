package com.dvivanco.springboot.apirest.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2364715451767492464L;
	
	private String resourceName;
    private String fieldName;
    private Object fieldValue;
    
   public EntityNotFoundException( String resourceName, String fieldName, Object fieldValue) {
        super(String.format("La Entidad %s con el %s(código o identificador) : '%s' no existe", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
