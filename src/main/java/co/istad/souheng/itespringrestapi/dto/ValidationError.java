package co.istad.souheng.itespringrestapi.dto;

import lombok.Builder;

@Builder
public record ValidationError(
        String field,
        String message
) {
}