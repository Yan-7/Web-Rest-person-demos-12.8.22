package springWeb.person.Demo;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import springWeb.person.models.Person;

import java.net.URI;

public class GetAllPersons {
    public static void main(String[] args) {

        RestTemplate rt = new RestTemplate();
        URI uri = URI.create("http://localhost:8080/api");

        RequestEntity<Void> req = RequestEntity.get(uri).build();

        try {
            ResponseEntity<Person[]> resp = rt.exchange(req, Person[].class);
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
        }


    }
}
