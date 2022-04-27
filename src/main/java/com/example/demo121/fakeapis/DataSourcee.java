package com.example.demo121.fakeapis;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Example DataStore class that provides access to user data.
 * creating a fake database
 */
@Component
public class DataSourcee {

    private Map<Integer, Person> personMap = new HashMap<>();


    private DataSourcee(){
        //dummy data
        personMap.put(1, new Person(1, "Ada", "Ada Lovelace was the first programmer.", 1815));
        personMap.put(2, new Person(2, "Kevin", "Kevin is the author of HappyCoding.io.", 1986));
        personMap.put(3, new Person(3, "Stanley", "Stanley is Kevin's cat.", 2007));
    }

    public Map<Integer,Person> getPersonDetails() {
        return personMap;
    }

    public Person createPerson(Person person) {
      personMap.put(person.getId(), person);
      return person;
    }
}

