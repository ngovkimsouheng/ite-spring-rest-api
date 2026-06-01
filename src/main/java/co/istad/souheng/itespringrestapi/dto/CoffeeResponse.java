package co.istad.souheng.itespringrestapi.dto;

public record CoffeeResponse(
        Integer id,
        String name,
        String description,
        Double price
) {
}