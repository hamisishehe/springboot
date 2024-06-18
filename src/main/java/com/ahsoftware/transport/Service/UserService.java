package com.ahsoftware.transport.Service;

import com.ahsoftware.transport.Model.User;

import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public List<Object> isUserPresent(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(Long id);

}
