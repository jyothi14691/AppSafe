package com.appsafe.service;

import com.appsafe.dao.VisitSafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitSafeService {

    VisitSafeRepository visitSafeRepository;

    @Autowired
    public VisitSafeService(VisitSafeRepository visitSafeRepository) {
        this.visitSafeRepository = visitSafeRepository;
    }

    public Integer getCountOfPeople(String nameLocation, String time) {
        String storeName = "";
        String storeLocation = "";
        String startTime = "";
        String endTime = "";

        String[] input = nameLocation.split(":");
        storeName = input[0].trim();
        storeLocation = input[1].trim();

        String[] hrsMin = time.split(":");
        startTime = hrsMin[0].trim();
        endTime = hrsMin[1].trim();

        if( Integer.parseInt(endTime) >= 0 && Integer.parseInt(endTime) <= 30){
            endTime = "30";
        }
        else
        {
            endTime = "59";
        }

        return visitSafeRepository.findNumOfPeople(storeName,storeLocation,startTime,endTime);
    }
}