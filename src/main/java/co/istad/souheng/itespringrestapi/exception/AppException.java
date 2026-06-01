package co.istad.souheng.itespringrestapi.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice

public class AppException {
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        log.error("Validation exception happened");
//
//
//        //price cannot less than 0
//        //name cannot be empty
//        //throw message , make it as detail as possible
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("message", "Validation Failed");
//        return ResponseEntity.badRequest().body(response);
////        return ResponseEntity.internalServerError().body(ex.getMessage());
//
//
//        //dependeny -> constraint ->
//    }
}
