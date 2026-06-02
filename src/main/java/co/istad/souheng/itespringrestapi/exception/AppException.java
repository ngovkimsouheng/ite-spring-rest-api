package co.istad.souheng.itespringrestapi.exception;

import co.istad.souheng.itespringrestapi.dto.ErrorResponse;
import co.istad.souheng.itespringrestapi.dto.ValidationError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice

public class AppException {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse<?> handleValidationException(
            MethodArgumentNotValidException e
    ) {
        log.error("Validation Exception happened");

        List<ValidationError> fields = new ArrayList<>();

        e.getFieldErrors()
                .forEach(fieldError -> {
                    ValidationError field = ValidationError.builder()
                            .field(fieldError.getField())
                            .message(fieldError.getDefaultMessage())
                            .build();
                    fields.add(field);
                });

        return ErrorResponse.builder()
                .status(false)
                .code(HttpStatus.BAD_REQUEST.value())
                .message("Validation is errored")
                .error(fields)
                .build();
    }



    // we want to custom response status dynamic
   @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleServiceException(ResponseStatusException e) {

        ErrorResponse<?> errorResponse = ErrorResponse.builder()
                .status(false)
                .code(e.getStatusCode().value())
                .message("service exception error")
                .error(e.getReason())
                .build();

        return ResponseEntity.status(e.getStatusCode()).body(errorResponse);
    }

}
