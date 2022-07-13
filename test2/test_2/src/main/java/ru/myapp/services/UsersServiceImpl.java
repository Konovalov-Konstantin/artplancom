package ru.myapp.services;

import org.springframework.stereotype.Component;
import ru.myapp.models.User;
import ru.myapp.repositories.UserRepository;

@Component
public class UsersServiceImpl implements UsersService {

    private final UserRepository userRepository;

    public UsersServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        User newUser = new User(user.getName(), user.getPassword());
        userRepository.save(newUser);
    }
}
