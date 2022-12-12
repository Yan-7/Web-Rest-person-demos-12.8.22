package springWeb.person.Demo;

import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import springWeb.person.models.Person;

import java.net.URI;

// TODO: 12/12/2022 adding null person 
public class AddPersonSimple {
    public static void main(String[] args) {

        RestTemplate rt = new RestTemplate();
        URI uri = URI.create("http://localhost:8080/api");

        Person person = new Person(11,"new person",44);
        try {
            Person addedPerson = rt.postForObject(uri,person, Person.class);
            System.out.println("added person:" + addedPerson);

        } catch (RestClientException e) {
            System.out.println(e.getMessage());
        }
    }
}
