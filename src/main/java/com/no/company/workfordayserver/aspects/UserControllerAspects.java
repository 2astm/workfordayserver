package com.no.company.workfordayserver.aspects;


import com.no.company.workfordayserver.entities.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class UserControllerAspects {

    private final static Logger logger = LoggerFactory.getLogger("user_controller_aspect");

    @Before("userController_pointCut() && args(user)")
    public void logginingForAdd(JoinPoint point, User user) {
        logger.info("Before: " + user.toString());
    }

    @After("userController_pointCut() && args(user, login, password)")
    public void logginingChangeUser(JoinPoint point, User user, String login, String password) {
        logger.info("After: " + user.toString());
    }

    @Pointcut("execution(* com.no.company.workfordayserver.rest.UserController.*(..))")
    public void userController_pointCut() {}
}
