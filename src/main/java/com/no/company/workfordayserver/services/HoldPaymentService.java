package com.no.company.workfordayserver.services;

import com.no.company.workfordayserver.entities.HoldPayment;
import com.no.company.workfordayserver.repos.HoldPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HoldPaymentService {

    @Autowired
    private HoldPaymentRepository holdPaymentRepository;

    public void addHoldPayment(HoldPayment holdPayment){
        holdPaymentRepository.save(holdPayment);
    }
}
