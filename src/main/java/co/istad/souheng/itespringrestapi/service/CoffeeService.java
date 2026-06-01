package co.istad.souheng.itespringrestapi.service;

import co.istad.souheng.itespringrestapi.domain.Coffee;
import co.istad.souheng.itespringrestapi.dto.CoffeeResponse;
import co.istad.souheng.itespringrestapi.dto.CreateCoffeeRequest;
import co.istad.souheng.itespringrestapi.repository.CoffeeRepository;

import java.util.List;

public interface CoffeeService {

    //response     methodName  thing we need to pass
    CoffeeResponse addCoffee(CreateCoffeeRequest createCoffeeRequest);

    List<CoffeeResponse> getAllCoffees();

    //get coffee by id
    CoffeeResponse getCoffeeById(int id);

    //get coffee by price
    CoffeeResponse getCoffeeByPrice(double price);

    //search by name
    CoffeeResponse searchCoffeeByName(String name);


}
