package com.alexandertutoriales.service.ecommerce.exception;

import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import com.alexandertutoriales.service.ecommerce.utils.Global;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionHandler {
    @ExceptionHandler(Exception.class)
    public GenericResponse genericException(Exception ex) {
        return new GenericResponse("exception", -1, Global.OPERACION_ERRONEA, ex.getMessage());
    }
}
