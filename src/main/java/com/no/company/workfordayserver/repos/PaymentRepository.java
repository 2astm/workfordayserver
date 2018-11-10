package com.no.company.workfordayserver.repos;

import com.no.company.workfordayserver.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
