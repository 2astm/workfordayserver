package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.HoldPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HoldPaymentRepository extends JpaRepository<HoldPayment, Long> {
}
