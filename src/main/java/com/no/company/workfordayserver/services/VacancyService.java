package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.repos.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacancyService {


    private VacancyRepository vacancyRepository;

    @Autowired
    public void setVacancyRepository(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

}
