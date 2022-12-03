package com.university.lab567.service;

import com.university.lab567.pojo.TimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class TimeService {

    public TimeResponse getCurrentUnixtime() {
        Long time = System.currentTimeMillis() / 1000L;
        return new TimeResponse(time);
    }
}
