package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.Payment;
import com.no.company.workfordayserver.repos.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService{

    @Autowired
    private PaymentRepository repository;


    public void setRepository(PaymentRepository repository) {
        this.repository = repository;
    }

    public void addPayment(Payment payment){
        repository.save(payment);
    }
}
