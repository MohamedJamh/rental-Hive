package com.rentalhive.service.impl;

import com.rentalhive.domain.User;
import com.rentalhive.repository.UserRepository;
import com.rentalhive.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User save(User user) {
        String organizationName = user.getOrganization().getName();

        return userRepository.save(user);
    }
    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public User delete(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>();
    }
}
