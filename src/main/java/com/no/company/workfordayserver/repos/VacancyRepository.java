package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.City;
import com.no.company.workfordayserver.entities.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long>{

    @Modifying
    @Transactional
    @Query(value = "update Vacancy set name = ?2 where id = ?1")
    void updateName(long id, String name);

    @Modifying
    @Transactional
    @Query(value = "update Vacancy set price = ?2 where id = ?1")
    void updatePrice(long id, double price);

    @Modifying
    @Transactional
    @Query(value = "update Vacancy set state = ?2 where id = ?1")
    void updateState(long id, Vacancy.State state);

    @Modifying
    @Transactional
    @Query(value = "update Vacancy set city = ?2 where id = ?1")
    void updateCity(long id, City city);

    @Modifying
    @Transactional
    @Query(value = "update Vacancy set dateStart = ?2 where id = ?1")
    void updateDateStart(long id, Date date);

    @Modifying
    @Transactional
    @Query(value = "update Vacancy set dateEnd = ?2 where id = ?1")
    void updateDateEnd(long id, Date date);

}
