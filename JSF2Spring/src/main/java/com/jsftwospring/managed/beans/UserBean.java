package com.jsftwospring.managed.beans;

import com.jsftwospring.entity.User;
import com.jsftwospring.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Andrey <Andrey at andrew.my@yahoo.com>
 */
@ManagedBean(name = "userBean", eager = true)
@RequestScoped
@Component
public class UserBean {

    @Autowired
    public UserService userService;

    private User user;

    @PostConstruct
    public void init(){
        user = new User();
    }

    public String fetchUser() {
        user = userService.getUser(user.getId());
        return "output";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}