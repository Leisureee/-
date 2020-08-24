package me.lolico.sms.service;


import me.lolico.sms.entity.User;
import me.lolico.sms.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;

@Service
public class UserService {

    private final UserMapper mapper;
    private Function<String, String> passwordEncoder = password -> password;

    public UserService(UserMapper mapper) {
        this.mapper = mapper;
    }

    public User getUserById(int id) throws SQLException {
        return mapper.getUserById(id);
    }

    public User getUserByName(String name) throws SQLException {
        return mapper.getUserByName(name);
    }

    public List<User> getAllUser() throws SQLException {
        return mapper.getAllUser();
    }

    public User verifyUser(User user) throws SQLException {
        return mapper.verifyUser(user);
    }

    public void deleteUserById(int id) throws SQLException {
        mapper.deleteUserById(id);
    }

    public void insertUser(User user) throws SQLException {
        user.setPassword(passwordEncoder.apply(user.getPassword()));
        mapper.insertUser(user);
    }

    public void updateUser(User user) throws SQLException {
        mapper.updateUser(user);
    }

    public void setPasswordEncoder(Function<String, String> passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}