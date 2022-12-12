package springWeb.person.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of =  "id")
public class Person {

    private int id;
    private String name;
    private int age;
}
