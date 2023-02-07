package com.jsftwospring.services.impl;

import com.jsftwospring.entity.User;
import com.jsftwospring.services.interfaces.UserService;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Andrey <Andrey at andrew.my@yahoo.com>
 */
public class UserServiceImpl implements UserService {

    private Map<Integer, User> map = new TreeMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        User user = new User(1, "John");
        map.put(user.getId(), user);
        user = new User(2, "Elvis Aaron Presley");
        map.put(user.getId(), user);
        user = new User(3, "Bill");
        map.put(user.getId(), user);
    }

    @Override
    public User getUser(Integer id) {
        return map.get(id);
    }
}
