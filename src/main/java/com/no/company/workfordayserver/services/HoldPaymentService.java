package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.HoldPayment;
import com.no.company.workfordayserver.repos.HoldPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class HoldPaymentService {

    @Autowired
    private HoldPaymentRepository holdPaymentRepository;

    public void addHoldPayment(HoldPayment holdPayment){
        holdPaymentRepository.save(holdPayment);
    }
}
