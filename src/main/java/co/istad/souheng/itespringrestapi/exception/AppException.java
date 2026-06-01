package co.istad.souheng.itespringrestapi.exception;

import co.istad.souheng.itespringrestapi.dto.ValidationError;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestControllerAdvice

public class AppException {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<ValidationError> errors = new ArrayList<>();

        ex.getFieldErrors().forEach((error) -> {
            errors.add(new ValidationError(error.getField(), error.getDefaultMessage()));
        });


        //price cannot less than 0
        //name cannot be empty
        //throw message , make it as detail as possible

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Validation Failed");
        response.put("errors", errors);
        response.put("status ",false);
        response.put("statusCode",400);
        return ResponseEntity.badRequest().body(response);

//        return ResponseEntity.internalServerError().body(ex.getMessage());


        //dependeny -> constraint ->
    }
}
