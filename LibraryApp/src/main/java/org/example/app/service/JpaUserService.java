package org.example.app.service;

import org.example.app.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class JpaUserService implements UserService{

    private final UserRepository userRepository;

    public JpaUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void addUser(User userToAdd) {
     userRepository.save(userToAdd);
    }

    @Override
    public void editUser(User userToEdit) {
        userRepository.save(userToEdit);

    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);

    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
