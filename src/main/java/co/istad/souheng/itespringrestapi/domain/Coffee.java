package co.istad.souheng.itespringrestapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


//create a POJO
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Coffee {
    private Integer id;
    private String name;
    private String description;
}
