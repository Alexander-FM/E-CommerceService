package com.alexandertutoriales.service.ecommerce.exception;

import static com.alexandertutoriales.service.ecommerce.utils.Global.OPERACION_ERRONEA;
import static com.alexandertutoriales.service.ecommerce.utils.Global.OPERACION_INCORRECTA;
import static com.alexandertutoriales.service.ecommerce.utils.Global.RPTA_ERROR;

import com.alexandertutoriales.service.ecommerce.utils.GenericResponse;
import com.alexandertutoriales.service.ecommerce.utils.Global;
import org.hibernate.JDBCException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SpecificExceptionHandler {

  @ExceptionHandler(JDBCException.class)
  public GenericResponse sqlException(JDBCException ex) {
    return new GenericResponse("sql-exception", -1, Global.OPERACION_ERRONEA, ex.getMessage());
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public GenericResponse validException(MethodArgumentNotValidException ex) {
    return new GenericResponse("valid-exception", RPTA_ERROR, OPERACION_ERRONEA, ex.getMessage());
  }

  @ExceptionHandler(FileStorageException.class)
  public GenericResponse fileStorageException(FileStorageException ex) {
    return new GenericResponse("file-storage-exception", RPTA_ERROR, OPERACION_ERRONEA, ex.getMessage());
  }

  @ExceptionHandler(MyFileNotFoundException.class)
  public GenericResponse myFileNotFoundException(MyFileNotFoundException exception) {
    return new GenericResponse("my-file-not-found-exception", RPTA_ERROR, OPERACION_INCORRECTA, exception.getMessage());
  }
}
