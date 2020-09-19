package com.appsafe.controller;


import com.appsafe.service.VisitSafeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/visitsafe")
public class VisitSafeController {

    private static final Logger logger = LoggerFactory.getLogger(VisitSafeController.class);

    VisitSafeService visitSafeService;

    @Autowired
    public VisitSafeController(VisitSafeService visitSafeService) {
        this.visitSafeService = visitSafeService;
    }


    @GetMapping
    public @ResponseBody
    ResponseEntity<Integer> getNumOfPeople(@RequestParam (name = "name-location") String nameLocation , @RequestParam String time){
        Integer count = -1;
        try{
            logger.info("Exception in VisitSafeController::getNumOfPeople()");
            if(nameLocation != null && time != null){
                count = visitSafeService.getCountOfPeople(nameLocation,time);
            } else{
                logger.error("Store name,location and time should be a valid entry");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }
        catch(Exception e){
            if(e instanceof HttpClientErrorException){
                logger.error("Exception on visitsafeController::getNumOfPeople() {}",e.fillInStackTrace());
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }else{
                logger.error("Exception in visitsafeController::getNumOfPeople() {}",e.fillInStackTrace());
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(count,HttpStatus.OK);
    }
}
