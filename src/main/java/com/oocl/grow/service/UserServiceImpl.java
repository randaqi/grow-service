package com.oocl.grow.service;
import com.oocl.grow.model.User;
import com.oocl.grow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User getTestUserInfo() {
        return userRepository.findByUserId(0);
    }
}
