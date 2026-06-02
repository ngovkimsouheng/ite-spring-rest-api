package co.istad.souheng.itespringrestapi.controller;

import co.istad.souheng.itespringrestapi.dto.CoffeeResponse;
import co.istad.souheng.itespringrestapi.dto.CreateCoffeeRequest;
import co.istad.souheng.itespringrestapi.dto.UpdateCoffeeRequest;
import co.istad.souheng.itespringrestapi.service.CoffeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public CoffeeResponse addCoffee(@Valid @RequestBody CreateCoffeeRequest createCoffeeRequest){
        log.info("add coffee");
        return coffeeService.addCoffee(createCoffeeRequest);
    }



    @PutMapping("/update/{id}")
    public CoffeeResponse updateCoffee(@PathVariable Integer id, UpdateCoffeeRequest updateCoffeeRequest){
        log.info("update coffee");
        return coffeeService.updateCoffeeById(id,updateCoffeeRequest);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public CoffeeResponse deleteCoffee(@PathVariable Integer id){
        log.info("delete coffee");
        return coffeeService.deleteCoffee(id);
    }
}   