package com.university.lab567.controller;

import com.university.lab567.pojo.TimeResponse;
import com.university.lab567.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TimeController {

    private TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @GetMapping("/time")
    public ResponseEntity<TimeResponse> getTime(){
        return ResponseEntity.ok(timeService.getCurrentUnixtime());
    }

}
