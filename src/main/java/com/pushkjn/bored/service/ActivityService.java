package com.pushkjn.bored.service;

import java.util.List;

import com.pushkjn.bored.dto.CreateActivityResponce;
import com.pushkjn.bored.dto.GetActivityResponce;
import com.pushkjn.bored.model.Activity;

public interface ActivityService {
    GetActivityResponce getRandomActivity(String category, Integer minChallenge, Integer maxChallenge);
    CreateActivityResponce createActivity(Activity a);
    List<GetActivityResponce> getAllActivities();
}