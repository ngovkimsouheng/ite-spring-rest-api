package co.istad.souheng.itespringrestapi.dto;

public record UpdateCoffeeRequest(
        String name,
        String description,
        Double price
) {
}
