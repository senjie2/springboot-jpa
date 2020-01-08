package com.senjie.controller;

import com.senjie.po.Person;
import com.senjie.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping("/")
    public String add(@RequestBody Person person) {
        personService.add(person);
        return "add-ok";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") Long id, @RequestBody Person person) {
        person.setId(id);
        personService.update(person);
        return "update-success";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        personService.delete(id);
        return "delete-success";
    }

    @GetMapping("/{id}")
    public Person findOne(@PathVariable("id") Long id) {
        return personService.findOne(id);
    }

    @GetMapping("/")
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/name/{name}")
    public Person findByNameEquals(@PathVariable("name") String name) {
        return personService.findByNameEquals(name);
    }

    @GetMapping("/namelike/{name}")
    public List<Person> findByNameLike(@PathVariable("name") String name) {
        return personService.findByNameLike(name);
    }

    @GetMapping("/login/{name}/{password}")
    public Person login(@PathVariable("name") String name, @PathVariable("password") String password) {
        return personService.login(name, password);
    }

    @GetMapping("/password/")
    public Person password() {
        return personService.getpasswordlength();
    }
}
