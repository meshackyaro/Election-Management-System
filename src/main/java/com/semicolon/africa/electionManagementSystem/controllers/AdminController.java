package com.semicolon.africa.electionManagementSystem.controllers;

import com.semicolon.africa.electionManagementSystem.dtos.requests.ScheduleElectionRequest;
import com.semicolon.africa.electionManagementSystem.dtos.responses.ScheduleElectionResponse;
import com.semicolon.africa.electionManagementSystem.services.ElectionManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/admin")
@RestController
public class  AdminController {


    private final ElectionManagementService electionManagementService;

    @Autowired
    public AdminController(ElectionManagementService electionManagementService) {
        this.electionManagementService = electionManagementService;
    }

    @PostMapping("/schedule")
    public ResponseEntity<?> scheduleElection(@RequestBody ScheduleElectionRequest request) {
        try{
            ScheduleElectionResponse response = electionManagementService.scheduleElection(request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
