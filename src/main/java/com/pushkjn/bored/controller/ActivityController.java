package com.pushkjn.bored.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pushkjn.bored.dto.CreateActivityResponce;
import com.pushkjn.bored.dto.GetActivityResponce;
import com.pushkjn.bored.model.Activity;
import com.pushkjn.bored.service.Impl.ActivityServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ActivityController {
    private final ActivityServiceImpl service;

    @GetMapping("/activity/all")
    List<GetActivityResponce> getAllActivities() {
        List<GetActivityResponce> all = service.getAllActivities();

        return all;
    }

    @GetMapping("/activity")
    GetActivityResponce getRandomActivity(@RequestParam(required = false) String category, @RequestParam(required = false) Integer minChallenge,
            @RequestParam(required = false) Integer maxChallenge) {

        GetActivityResponce responce = service.getRandomActivity(category, minChallenge, maxChallenge);
        
        return responce;
    }

    @PostMapping("/activity")
    CreateActivityResponce createActivity(@RequestBody Activity a) {
        CreateActivityResponce responce = service.createActivity(a);
        return responce;
    }
}
