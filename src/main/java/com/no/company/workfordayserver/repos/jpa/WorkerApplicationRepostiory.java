package com.no.company.workfordayserver.repos.jpa;

import com.no.company.workfordayserver.entities.User;
import com.no.company.workfordayserver.entities.WorkerApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerApplicationRepostiory extends JpaRepository<WorkerApplication, Long> {
    void deleteByIdAndUser(Long workerApplicationID, User user);
}
