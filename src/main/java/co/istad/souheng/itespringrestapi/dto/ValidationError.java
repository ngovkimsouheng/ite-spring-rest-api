package co.istad.souheng.itespringrestapi.dto;

public record ValidationError(
        String field,
        String message
) {
}