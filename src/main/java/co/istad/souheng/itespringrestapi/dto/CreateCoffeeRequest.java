package co.istad.souheng.itespringrestapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateCoffeeRequest(
        @NotNull(message = "Name is required")
        @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters")
        String name,

        @NotNull(message = "Description is required")
        @Size(min = 2, max = 10000)
        String description,
        @NotNull(message = "Price is required")
        @Positive(message = "Price must be a positive number")
        Double price
) {

}
