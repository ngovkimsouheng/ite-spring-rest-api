package co.istad.souheng.itespringrestapi.service;

import co.istad.souheng.itespringrestapi.domain.Coffee;
import co.istad.souheng.itespringrestapi.dto.CoffeeResponse;
import co.istad.souheng.itespringrestapi.repository.CoffeeRepository;

import java.util.List;

public interface CoffeeService {

    List<CoffeeResponse> getAllCoffees();

    //get coffee by id
    CoffeeResponse getCoffeeById(int id);
    //search by name
    CoffeeResponse searchCoffeeByName(String name);
}
