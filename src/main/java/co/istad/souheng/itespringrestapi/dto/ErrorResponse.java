package co.istad.souheng.itespringrestapi.dto;

import java.util.List;

public record ErrorResponse(
        Boolean status,
        Integer code,
        String message,
        List<ValidationError> error
) {
}