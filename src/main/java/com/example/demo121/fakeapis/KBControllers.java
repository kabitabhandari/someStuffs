package com.example.demo121.fakeapis;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class KBControllers {
    private final DataSource dataSource;

    public KBControllers(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @GetMapping("/get")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> p1 = new ArrayList<>();
        Map<Integer,Person> m1 = dataSource.getPersonDetails();
        // iterate over and get values
        for(Map.Entry<Integer, Person> entry : m1.entrySet()){
            p1.add(entry.getValue());
        }
        return new ResponseEntity<>(p1, HttpStatus.OK);
    }

    @PostMapping("/post")
    public @ResponseBody ResponseEntity<Person> newPersons(@RequestBody Person person,
                                                           @RequestHeader (value = "channel") String fakeChannel) {
        Person p1 = dataSource.createPerson(person);
        System.out.println(">>>" + p1);
        return new ResponseEntity<>(p1, HttpStatus.OK);
    }
    @PatchMapping("/patch/{id}")
    public @ResponseBody ResponseEntity<String> updatePersons(@RequestBody Person person,
                                                              @RequestHeader (value = "channel") String fakeChannel,
                                                              @PathVariable Integer id) {
        Set<Integer> listOfIds = (dataSource.getPersonDetails().keySet());
            if (listOfIds.contains(id) && id.equals(person.getId())) {
                Person p1 = dataSource.createPerson(person);
                System.out.println(">>>" + p1);
                return new ResponseEntity<String>("Record Updated", HttpStatus.OK);
            }
            if(!listOfIds.contains(id) ){
                throw new IdNotFoundException("Id does not exists!");
            }
            if(!id.equals(person.getId())){
                throw new UnmatchedIdException("Id does not matching!");
            }
        return null;
    }
}
