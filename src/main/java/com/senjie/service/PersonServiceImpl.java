package com.senjie.service;

import com.senjie.dao.PersonDao;
import com.senjie.po.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao pd;

    @Override
    public void add(Person person) {
        pd.save(person);
    }

    @Override
    public void update(Person person) {
        pd.saveAndFlush(person);
    }

    @Override
    public void delete(Long id) {
        pd.deleteById(id);
    }

    @Override
    public Person findOne(Long id) {
        return pd.findById(id).get();
    }

    @Override
    public List<Person> findAll() {
        return pd.findAll();
    }

    @Override
    public Person findByNameEquals(String name) {
        return pd.findByNameEquals(name);
    }

    @Override
    public Person findByNameEqualsAndPasswordEquals(String name, String password) {
        return pd.findByNameEqualsAndPasswordEquals(name, password);
    }

    @Override
    public List<Person> findByNameLike(String name) {
        return pd.findByNameLike("%" + name + "%");
    }

    @Override
    public Person login(String name, String password) {
        return pd.login(name, password);
    }

    @Override
    public Person getpasswordlength() {
        return pd.getpasswordlength();
    }
}
