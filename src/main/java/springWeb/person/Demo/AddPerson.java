package springWeb.person.Demo;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;
import springWeb.person.models.Person;

import java.net.URI;

public class AddPerson {
    public static void main(String[] args) {

        RestTemplate rt = new RestTemplate();
        URI uri = URI.create("http://localhost:8080/api");

        Person person1 = new Person(10,"Bobi",505);
        System.out.println(person1);

        RequestEntity<Person> req = RequestEntity.post(uri).body(person1);

        // TODO: 12/12/2022 its adding null persons for some reason
        try {

            ResponseEntity<Person> resp = rt.exchange(req,Person.class);
            System.out.println("----");
            System.out.println(resp.getStatusCode());
            Person addedPerson  = resp.getBody();
            System.out.println(addedPerson);

        } catch (RestClientException e) {
            System.out.println(e.getMessage());
        }
    }
}
