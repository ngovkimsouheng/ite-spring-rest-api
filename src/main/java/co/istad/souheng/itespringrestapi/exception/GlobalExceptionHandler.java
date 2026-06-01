package co.istad.souheng.itespringrestapi.exception;

import co.istad.souheng.itespringrestapi.dto.ErrorResponse;
import co.istad.souheng.itespringrestapi.dto.ValidationError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ErrorResponse handleValidationException(
//            MethodArgumentNotValidException ex
//    ) {
//
//        List<ValidationError> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(error -> new ValidationError(
//                        error.getField(),
//                        error.getDefaultMessage()
//                ))
//                .toList();
//
//        return new ErrorResponse(
//                false,
//                400,
//                "Validation error",
//                errors
//        );
//    }
}