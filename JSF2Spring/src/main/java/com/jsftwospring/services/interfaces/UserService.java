package com.jsftwospring.services.interfaces;

import com.jsftwospring.entity.User;
import org.springframework.beans.factory.InitializingBean;

import java.io.Serializable;

/**
 * @author Andrey <Andrey at andrew.my@yahoo.com>
 */
public interface UserService extends Serializable, InitializingBean {

    User getUser(Integer id);

}
