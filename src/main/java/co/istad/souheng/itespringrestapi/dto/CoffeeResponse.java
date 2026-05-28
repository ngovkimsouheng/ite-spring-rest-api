package co.istad.souheng.itespringrestapi.dto;

public record CoffeeResponse(
        String name,
        String description,
        Double price
) {
}