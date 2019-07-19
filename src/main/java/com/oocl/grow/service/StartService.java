package com.oocl.grow.service;

import com.oocl.grow.model.User;
import com.oocl.grow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class StartService implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(User.builder().userId(0).avator("").nickname("testUser")
                .introduction("I like singing, dancing, rap and basketball. Music~").build());
    }
}