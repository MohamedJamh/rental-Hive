package com.rentalhive.service;

import com.rentalhive.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    public User save(User user);
    public User update(User user);
    public User delete(User user);
    public List<User> findAll();

}
