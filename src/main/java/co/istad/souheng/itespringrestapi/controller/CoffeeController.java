package co.istad.souheng.itespringrestapi.controller;

import co.istad.souheng.itespringrestapi.dto.CoffeeResponse;
import co.istad.souheng.itespringrestapi.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/coffees")
public class CoffeeController {
    private final CoffeeService coffeeService;

    public CoffeeController(CoffeeService coffeeService) {
        this.coffeeService = coffeeService;
    }

    @GetMapping()
    public List<CoffeeResponse> getCoffees() {
        return coffeeService.getAllCoffees();
    }

    @GetMapping("/id/{id}")
    public CoffeeResponse getCoffeeById(
            @PathVariable Integer id
    ) {

        log.info("get id: {}", id);

        return coffeeService.getCoffeeById(id);
    }

    @GetMapping("/price/{price}")
    public CoffeeResponse getCoffeeByPrice(

            @PathVariable Double price
    ) {
        log.info("get price: {}", price);
        return coffeeService.getCoffeeByPrice(price);
    }

    @GetMapping("/search")
    public CoffeeResponse searchCoffeeByName(
            @RequestParam(required = false,
                    defaultValue = "") String name
    ) {

        log.info("get name: {}", name);

        return coffeeService.searchCoffeeByName(name);
    }

    @GetMapping("/price")
    public CoffeeResponse searchCoffeeByPrice(
            @RequestParam (required = false, defaultValue = "")  Double price
    ){
        log.info("get price: {}", price);
        return coffeeService.getCoffeeByPrice(price);
    }

    @GetMapping("/id")
    public CoffeeResponse searchCoffeeById(
            @RequestParam (required = false, defaultValue = "")  Integer id
    ){
        log.info("get coffeeById");
        return coffeeService.getCoffeeById(id);
    }

}