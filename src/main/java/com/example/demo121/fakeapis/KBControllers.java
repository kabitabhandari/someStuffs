package com.example.demo121.fakeapis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.*;

@RestController
public class KBControllers {
    private final DataSourcee dataSourcee;

    public KBControllers(DataSourcee dataSourcee) {
        this.dataSourcee = dataSourcee;
    }


    @GetMapping("/get")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> p1 = new ArrayList<>();
        Map<Integer,Person> m1 = dataSourcee.getPersonDetails();
        // iterate over and get values
        for(Map.Entry<Integer, Person> entry : m1.entrySet()){
            p1.add(entry.getValue());
        }
        return new ResponseEntity<>(p1, HttpStatus.OK);
    }

    @PostMapping("/post")
    public @ResponseBody ResponseEntity<Person> newPersons(@Valid @RequestBody Person person,
                                                           @RequestHeader (value = "channel") String fakeChannel) {
        Person p1 = dataSourcee.createPerson(person);
        System.out.println(">>>" + p1);
        return new ResponseEntity<>(p1, HttpStatus.OK);
    }
    @PatchMapping("/patch/{id}")
    public @ResponseBody ResponseEntity<String> updatePersons(@RequestBody Person person,
                                                              @RequestHeader (value = "channel") String fakeChannel,
                                                              @PathVariable Integer id) {
        Set<Integer> listOfIds = (dataSourcee.getPersonDetails().keySet());
            if (listOfIds.contains(id) && id.equals(person.getId())) {
                Person p1 = dataSourcee.createPerson(person);
                System.out.println(">>>" + p1);
                return new ResponseEntity<String>("Record Updated", HttpStatus.OK);
            }
            if(!listOfIds.contains(id) ){
                throw new IdNotFoundException("Id does not exists!");
            }
            if(!id.equals(person.getId())){
                throw new UnmatchedIdException("Id does not match!");
            }
        return null;
    }
    @GetMapping("/get/mocked")
    public ResponseEntity getAllPersonsFromWireMock(){
        List<Person> p1 = new ArrayList<>();

        // make a http get call using rest template
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity("http://localhost:8089/get/mocked", String.class, HttpStatus.OK);

        System.out.println(">>> responese" + response);

        return response;

       // return new ResponseEntity<>(p1, HttpStatus.OK);
    }


    @PostMapping("/post/mocked")
    public @ResponseBody ResponseEntity<Person> newPersonsFromWiremock(@RequestBody Person person,
                                                           @RequestHeader (value = "channel") String fakeChannel) {
        Person p1 = dataSourcee.createPerson(person);
        System.out.println(">>>" + p1);
        return new ResponseEntity<>(p1, HttpStatus.OK);
    }


}
