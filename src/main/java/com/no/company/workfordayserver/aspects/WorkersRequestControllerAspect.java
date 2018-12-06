package com.no.company.workfordayserver.aspects;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.Vacancy;
import com.no.company.workfordayserver.entities.WorkerRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WorkersRequestControllerAspect {

    public final static Logger logger = LoggerFactory.getLogger("worker_request_controller_aspect");

    @Before("point_cut() && args(workerRequest)")
    public void addRequest(JoinPoint joinPoint, WorkerRequest workerRequest){
        logger.info("Price: "  + workerRequest.getPrice() +
                "\nState: " + workerRequest.getStateRequest() +
                "\nId: " + workerRequest.getId());
    }

    @Before("point_cut() && args(user)")
    public void getRequestsByUser(JoinPoint joinPoint, User user){
        logger.info("User: " + user.getLogin());
    }

    @Before("point_cut() && args(vacancy)")
    public void getRequestsByVacancy(JoinPoint joinPoint, Vacancy vacancy){
        logger.info("Vacancy: " + vacancy.getName());
    }

    @Before(value = "point_cut() && args(id, state, login, password)")
    public void getRequestsByVacancy(JoinPoint joinPoint, long id, WorkerRequest.State_request state,
                                  String login,String password){
        logger.info("id: " + id +
                "\nState: " + state +
                "\nLogin: " + login +
                "\nPassword: " + password);
    }

    @Pointcut("execution(* com.no.company.workfordayserver.rest.WorkersRequestController.*(..))")
    public void point_cut(){}
}
