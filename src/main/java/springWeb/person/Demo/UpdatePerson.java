package springWeb.person.Demo;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import springWeb.person.models.Person;

import java.net.URI;

public class UpdatePerson {
    public static void main(String[] args) {

        RestTemplate rt = new RestTemplate();

        URI baseUri = URI.create("http://localhost:8080/api");

        RequestEntity<Void> reqGet = RequestEntity.get(baseUri + "/1").build();

        try {
            ResponseEntity<Person> resp = rt.exchange(reqGet, Person.class);
            System.out.println("====");
            System.out.println(resp.getStatusCode());
            Person person = resp.getBody();
            System.out.println(person);

            //update
            person.setAge(150);
            RequestEntity<Person> reqUpdate = RequestEntity.put(baseUri).body(person);
            resp = rt.exchange(reqUpdate, Person.class);
            System.out.println("-------");
            System.out.println(resp.getStatusCode());
            person = resp.getBody();
            System.out.println("person updated: " + person );
        } catch (RestClientException e) {
            System.out.println(e.getMessage());
        }
    }
}
