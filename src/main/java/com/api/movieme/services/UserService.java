package com.api.movieme.services;

import com.api.movieme.models.User;
import com.api.movieme.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public User save(User user) {
        return userRepository.save(user);
    }

}
