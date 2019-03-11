package com.no.company.workfordayserver.aspects;

import com.no.company.workfordayserver.entities.Vacancy;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class VacancyControllerAspects {
    public final static Logger logger = LoggerFactory.getLogger("vacancy_controller_aspect");

    @Before("vacancyController_pointCut() && args(vacancy)")
    public void addVacancy(JoinPoint point, Vacancy vacancy) {
        logger.info("ADDED: Name: " + vacancy.toString());
    }

    /*@Around("vacancyController_pointCut() && args(vacancy)")
    public void changeVacancy(JoinPoint point, Vacancy vacancy) {
        logger.info("CHANGED: Name: " + vacancy.getName() +
                "Price: " + vacancy.getPrice() +
                "City" + vacancy.getCity().getId() +
                "Id" + vacancy.getId());
    }

    // for delete if necessary
   /* @AfterReturning("vacancyController_pointCut() && args(vacancy)")
    public void deleteVacancy(JoinPoint point, Vacancy vacancy) {
        logger.info("DELETED: Name: " + vacancy.getName() +
                "Price: " + vacancy.getPrice() +
                "City" + vacancy.getCity() +
                "Id" + vacancy.getId());
    }*/

    @Pointcut("execution(* com.no.company.workfordayserver.rest.VacancyController.*(..))")
    public void vacancyController_pointCut() {}
}
