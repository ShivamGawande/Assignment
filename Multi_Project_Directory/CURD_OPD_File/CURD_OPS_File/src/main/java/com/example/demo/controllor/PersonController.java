package com.example.demo.controllor;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Person;
import com.example.demo.service.PersonService;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
	@Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody Person person) {
        try {
            String message = personService.savePerson(person);
            return ResponseEntity.ok(message);
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }

    
    @GetMapping("/{firstName}/{lastName}")
    public ResponseEntity<Person> getPerson(@PathVariable String firstName, @PathVariable String lastName) {
        try {
            Person person = personService.getPerson(firstName, lastName);
            return ResponseEntity.ok(person);
        } catch (IOException e) {
            return ResponseEntity.status(404).body(null);
        }
    }

   
    @DeleteMapping("/{firstName}/{lastName}")
    public ResponseEntity<String> deletePerson(@PathVariable String firstName, @PathVariable String lastName) {
        String message = personService.deletePerson(firstName, lastName);
        return ResponseEntity.ok(message);
    }

    // List all persons
    @GetMapping
    public ResponseEntity<List<String>> listPeople() {
        List<String> people = personService.listPeople();
        return ResponseEntity.ok(people);
    }
}
