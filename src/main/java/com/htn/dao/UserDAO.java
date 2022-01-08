package com.htn.dao;

import com.htn.models.User;

public interface UserDAO {

    public User getUser(String username);

    public User saveUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

}
