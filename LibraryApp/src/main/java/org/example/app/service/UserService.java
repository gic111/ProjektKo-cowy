package org.example.app.service;

import org.example.app.model.User;


import java.util.List;

public interface UserService {
    User getUserById(Long id);

    void addUser(User userToAdd);

    void editUser(User userToEdit);

    void deleteUser(Long id);

    List<User> findAllUsers();
}
