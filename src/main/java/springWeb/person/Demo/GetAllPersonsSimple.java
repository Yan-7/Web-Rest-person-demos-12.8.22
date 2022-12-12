package springWeb.person.Demo;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import springWeb.person.models.Person;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

public class GetAllPersonsSimple {
    public static void main(String[] args) {

        RestTemplate rt = new RestTemplate();
        URI uri = URI.create("http://localhost:8080/api");
        try {
            Person[] list = rt.getForObject(uri, Person[].class);
            System.out.println("--------");
            List<Person> list2 = Arrays.asList(list);
            System.out.println(list2);
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
        }
    }
}
