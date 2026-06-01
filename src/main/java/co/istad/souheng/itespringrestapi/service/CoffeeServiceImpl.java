package co.istad.souheng.itespringrestapi.service;

import co.istad.souheng.itespringrestapi.domain.Coffee;
import co.istad.souheng.itespringrestapi.dto.CoffeeResponse;
import co.istad.souheng.itespringrestapi.dto.CreateCoffeeRequest;
import co.istad.souheng.itespringrestapi.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

@Service
public class CoffeeServiceImpl implements CoffeeService {

//    public final CoffeeRepository coffeeRepository;
    public final List<Coffee> coffeeBean;

    public CoffeeServiceImpl(CoffeeRepository coffeeRepository, List<Coffee> coffeeBean) {
//        this.coffeeRepository = coffeeRepository;
        this.coffeeBean = coffeeBean;
    }


    @Override
    public CoffeeResponse addCoffee(CreateCoffeeRequest createCoffeeRequest) {

        Coffee coffee = new Coffee();
        coffee.setId(new Random().nextInt(999999)); //system data : system generated data
        coffee.setName(createCoffeeRequest.name());
        coffee.setDescription(createCoffeeRequest.description());
        coffee.setPrice(createCoffeeRequest.price());

//
//        boolean isExist = coffeeBean.stream().

        return new CoffeeResponse(coffee.getId() ,coffee.getName(), coffee.getDescription(), coffee.getPrice());
    }


//    @Override
//    public List<CoffeeResponse> getAllCoffees() {
//        List<Coffee> coffees = coffeeRepository.beanCoffee();
//
//        coffeeBean.addAll(coffees);
//        return coffees.stream()

    /// /                .filter(coffee -> coffee.getCode()> 2)
//                .map(coffee -> new CoffeeResponse(coffee.getName(), coffee.getDescription(), coffee.getPrice()))
//                .toList();
//    }
    @Override
    public List<CoffeeResponse> getAllCoffees() {

        return coffeeBean.stream()
                .map(coffee -> new CoffeeResponse(
                        coffee.getId(),
                        coffee.getName(),
                        coffee.getDescription(),
                        coffee.getPrice()
                ))
                .toList();
    }


    @Override
    public CoffeeResponse getCoffeeById(int id) {
//
//        List<Coffee> coffees = coffeeRepository.beanCoffee();

/*        coffeeRepository.beanCoffee().stream().filter(coffee -> coffee.getId() == id).
                forEach(s-> System.out.println(s));*/

        return coffeeBean.stream()
                .filter(coffee -> coffee.getId() == id)
                .map(coffee -> new CoffeeResponse(
                        coffee.getId(),
                        coffee.getName(),
                        coffee.getDescription(),
                        coffee.getPrice()
                ))
                .findFirst()
                .orElse(null);
    }


    @Override
    public CoffeeResponse searchCoffeeByName(String name) {
//        List<Coffee> coffees = coffeeRepository.beanCoffee();
        return coffeeBean.stream()
                .filter(coffee -> coffee.getName().toLowerCase().contains(name.toLowerCase()))
                .map(coffee -> new CoffeeResponse(
                        coffee.getId(),
                        coffee.getName(),
                        coffee.getDescription(),
                        coffee.getPrice()
                ))
                .findFirst()
                .orElse(null);
    }


    @Override
    public CoffeeResponse getCoffeeByPrice(double price) {
//        List<Coffee> coffees = coffeeRepository.beanCoffee();
        return coffeeBean.stream()
                .filter(coffee -> coffee.getPrice().equals(price))
                .map(coffee -> new CoffeeResponse(
                        coffee.getId(),
                        coffee.getName(),
                        coffee.getDescription(),
                        coffee.getPrice()
                ))
                .findFirst().orElseThrow(() -> new RuntimeException("Coffee not found with price: " + price));
    }


}