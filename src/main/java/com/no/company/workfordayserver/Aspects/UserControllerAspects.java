package com.no.company.workfordayserver.Aspects;


import com.no.company.workfordayserver.entities.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class UserControllerAspects {

    private final static Logger logger = (Logger) LoggerFactory.getLogger("controller_aspect");

    @Before("point_cut() && args(user)")
    public void logginingForAdd(JoinPoint point, User user) {
        logger.info("Before: " + user + "Name: " + user.getName() + "Surname: " + user.getSurname() +
                "Phone Number: " + user.getPhoneNumber() + "Address: " + user.getEmail());
    }

    @After("point_cut() && args(user, login, password)")
    public void logginingChangeUser(JoinPoint point, User user, String login, String password) {
        logger.info("After: " + user + "Name: " + user.getName() + "Surname: " + user.getSurname() +
                "Phone Number: " + user.getPhoneNumber() + "Address: " + user.getEmail() + "Login: " + user.getLogin() + "Password: " + user.getPassword());
    }

    @Pointcut("execution(*com.no.company.workfordayserver.rest.UserController.*(..))")
    public void userController_pointCut() {

    }
}
