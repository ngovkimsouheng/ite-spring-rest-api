package co.istad.souheng.itespringrestapi.service;

import co.istad.souheng.itespringrestapi.domain.Coffee;
import co.istad.souheng.itespringrestapi.dto.CoffeeResponse;
import co.istad.souheng.itespringrestapi.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    public final CoffeeRepository coffeeRepository;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }


    @Override
    public List<CoffeeResponse> getAllCoffees() {
        List<Coffee> coffees = coffeeRepository.beanCoffee();

        return coffees.stream()
//                .filter(coffee -> coffee.getCode()> 2)
                .map(coffee -> new CoffeeResponse(coffee.getName(), coffee.getDescription(), coffee.getPrice()))
                .toList();
    }


    @Override
    public CoffeeResponse getCoffeeById(int id) {

        List<Coffee> coffees = coffeeRepository.beanCoffee();

        return coffees.stream()
                .filter(coffee -> coffee.getId() == id)
                .map(coffee -> new CoffeeResponse(
                                coffee.getName(),
                                coffee.getDescription(),
                                coffee.getPrice()
                ))
                .findFirst()
                .orElse(null);
    }



    @Override
    public CoffeeResponse searchCoffeeByName(String name) {
        List<Coffee> coffees = coffeeRepository.beanCoffee();
        return coffees.stream()
                .filter(coffee -> coffee.getName().toLowerCase().contains(name.toLowerCase()))
                .map(coffee -> new CoffeeResponse(
                        coffee.getName(),
                        coffee.getDescription(),
                        coffee.getPrice()
                ))
                .findFirst()
                .orElse(null);
    }

    @Override
    public CoffeeResponse getCoffeeByPrice(double price) {
        List<Coffee> coffees = coffeeRepository.beanCoffee();
        return coffees.stream()
                .filter(coffee -> coffee.getPrice().equals(price))
                .map(coffee -> new CoffeeResponse(
                        coffee.getName(),
                        coffee.getDescription(),
                        coffee.getPrice()
                ))
                .findFirst()
                .orElse(null);
    }



}