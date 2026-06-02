package co.istad.souheng.itespringrestapi.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record ErrorResponse<T>(
        Boolean status,
        Integer code,
        String message,
       T error
) {
}