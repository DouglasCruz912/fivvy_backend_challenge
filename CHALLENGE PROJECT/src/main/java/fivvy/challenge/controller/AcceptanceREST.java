package fivvy.challenge.controller;

import fivvy.challenge.bo.Acceptance;
import fivvy.challenge.bo.Disclaimer;
import fivvy.challenge.entity.AcceptanceEntity;
import fivvy.challenge.entity.DisclaimerEntity;
import fivvy.challenge.service.AcceptanceService;
import fivvy.challenge.service.DisclaimerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AcceptanceREST {
    private final static Logger logger = LoggerFactory.getLogger(AcceptanceREST.class);

    @Autowired
    private AcceptanceService acceptanceService;

    @RequestMapping(value = "/getAllAcceptance", method= RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<Acceptance>> getAllAcceptance(
            @RequestParam(value = "user_id", required = false) Long userId
    ){
        List<Acceptance> acceptances = new ArrayList<>();
        final List<AcceptanceEntity> acceptanceEntities = acceptanceService.findAllAcceptance(userId);
        acceptanceEntities.forEach(acceptanceEntity -> {
            Acceptance acceptance = new Acceptance(acceptanceEntity);
            acceptances.add(acceptance);
        });
        return new ResponseEntity<>(acceptances, HttpStatus.OK);
    }

    @RequestMapping(value = "/createAcceptance", method= RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public  ResponseEntity<String> createAcceptance(
            @RequestBody AcceptanceEntity acceptance
    ){

        acceptanceService.save(acceptance);
        return new ResponseEntity<>("Acceptance Created Succefully", HttpStatus.OK);

    }



}
