package ru.myapp.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.myapp.models.User;
import ru.myapp.repositories.UserRepository;

@Component
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public SignUpServiceImpl(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void signUpUser(String name, String password) {
        User user = new User(name,passwordEncoder.encode(password));
        userRepository.save(user);
    }
}
