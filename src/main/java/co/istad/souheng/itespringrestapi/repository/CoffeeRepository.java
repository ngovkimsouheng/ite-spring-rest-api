package co.istad.souheng.itespringrestapi.repository;

import co.istad.souheng.itespringrestapi.domain.Coffee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository //this class will be created as bean repo store in IOC container
public class CoffeeRepository {

    @Bean
    public List<Coffee> beanCoffee() {
        List<Coffee> coffees = new ArrayList<>();

        Coffee coffee = new Coffee(1, "ice latte", "50% sugar", 1.3);
        Coffee coffee2 = new Coffee(2, "ice Americano", "50% sugar", 1.5);
        Coffee coffee3 = new Coffee(3, "expresso", "100% sugar", 2.5);

        coffees.add(coffee);
        coffees.add(coffee2);
        coffees.add(coffee3);
        return new ArrayList<>(Arrays.asList(coffee, coffee2, coffee3));
//      return Arrays.asList(coffee, coffee2, coffee3);
    }

}
