package springWeb.person.Demo;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import springWeb.person.models.Person;

import java.net.URI;

public class UpdatePersonSimple {
    public static void main(String[] args) {

        RestTemplate rt = new RestTemplate();
        URI uri = URI.create("http://localhost:8080/api");
        Person updatedPerson  = new Person(2,"updatedPerson",300);

        try {
            rt.put(uri,updatedPerson);
            System.out.println("updated");
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
        }
    }

}
