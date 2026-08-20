package io.github.mateussilva.dscatalog.controllers.handlers;

import io.github.mateussilva.dscatalog.dto.CustomError;
import io.github.mateussilva.dscatalog.services.exceptions.DatabaseException;
import io.github.mateussilva.dscatalog.services.exceptions.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.HtmlUtils;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(EntityNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        String path = HtmlUtils.htmlEscape(request.getRequestURI());
        return ResponseEntity
                .status(status)
                .body(CustomError.of(status.value(), e.getMessage(), path));
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<CustomError> database(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String path = HtmlUtils.htmlEscape(request.getRequestURI());
        return ResponseEntity
                .status(status)
                .body(CustomError.of(status.value(), e.getMessage(), path));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> argumentNotValidation(MethodArgumentNotValidException e, HttpServletRequest request) {
        String path = HtmlUtils.htmlEscape(request.getRequestURI());
        return ResponseEntity
                .unprocessableEntity()
                .body(CustomError.validation("Dados inválidos", path, e.getBindingResult()));
    }

}
