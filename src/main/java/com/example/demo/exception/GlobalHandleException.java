package com.example.demo.exception;

import com.example.demo.common.dto.ResponseAPI;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
@FieldDefaults(level = AccessLevel.PUBLIC)
public class GlobalHandleException extends RuntimeException {

    @ExceptionHandler(value = HandleRuntimeException.class)
    ResponseEntity<ResponseAPI> handleRuntimeException(HandleRuntimeException e){
        ErrorCode errorCode = e.getErrorCode();
        ResponseAPI response = new ResponseAPI();
        response.setCode(errorCode.getCode());
        response.setMessage(errorCode.getMessage());
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("timestamp", System.currentTimeMillis());
        errors.put("code", HttpStatus.BAD_REQUEST.value());
        errors.put("error", "Bad Request");
        errors.put("message", "Validation failed");
        errors.put("path", request.getRequestURI());

        Map<String, String> validationErrors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            validationErrors.put(error.getField(), error.getDefaultMessage());
        }
        errors.put("errors", validationErrors);

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Map<String, Object>> handleMissingParams(MissingServletRequestParameterException ex, HttpServletRequest request) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("timestamp", System.currentTimeMillis());
        errors.put("code", HttpStatus.BAD_REQUEST.value());
        errors.put("error", "Bad Request");
        errors.put("message", "Missing parameter: " + ex.getParameterName());
        errors.put("path", request.getRequestURI());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
        Map<String, Object> errors = new HashMap<>();
        errors.put("timestamp", System.currentTimeMillis());
        errors.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        errors.put("error", "Internal Server Error");
        errors.put("message", ex.getMessage());
        errors.put("path", "/api/v1");

        return new ResponseEntity<>(errors, HttpStatus.INTERNAL_SERVER_ERROR);
    }




}
