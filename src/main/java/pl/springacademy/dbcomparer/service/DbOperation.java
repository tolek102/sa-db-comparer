package pl.springacademy.dbcomparer.service;

import java.util.List;

import pl.springacademy.dbcomparer.aspect.Timed;
import pl.springacademy.dbcomparer.model.User;

public interface DbOperation {

    void save(final List<User> users);

    List<User> readAll();

    void deleteAll();

}
