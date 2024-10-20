package com.example.demo.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.Person;

@Service
public class PersonService {
private static final String DIRECTORY = "person_data/";
    
    public PersonService() {
        File dir = new File(DIRECTORY);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }

    public String savePerson(Person person) throws IOException {
        File file = new File(DIRECTORY + person.getFirstName() + "_" + person.getLastName() + ".txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write("First Name: " + person.getFirstName());
            writer.newLine();
            writer.write("Last Name: " + person.getLastName());
            writer.newLine();
            writer.write("Gender: " + person.getGender());
        }
        return "Person saved successfully!";
    }

    public Person getPerson(String firstName, String lastName) throws IOException {
        File file = new File(DIRECTORY + firstName + "_" + lastName + ".txt");
        if (!file.exists()) {
            throw new FileNotFoundException("Person not found!");
        }

        Person person = new Person();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            person.setFirstName(reader.readLine().split(": ")[1]);
            person.setLastName(reader.readLine().split(": ")[1]);
            person.setGender(reader.readLine().split(": ")[1]);
        }
        return person;
    }

    
    public String deletePerson(String firstName, String lastName) {
        File file = new File(DIRECTORY + firstName + "_" + lastName + ".txt");
        if (file.exists()) {
            file.delete();
            return "Person deleted successfully!";
        } else {
            return "Person not found!";
        }
    }

  
    public List<String> listPeople() {
        List<String> people = new ArrayList<>();
        File directory = new File(DIRECTORY);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                people.add(file.getName().replace(".txt", ""));
            }
        }
        return people;
    }
}
