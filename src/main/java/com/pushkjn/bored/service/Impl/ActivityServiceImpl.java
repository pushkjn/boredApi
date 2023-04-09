package com.pushkjn.bored.service.Impl;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.pushkjn.bored.dto.CreateActivityResponce;
import com.pushkjn.bored.dto.GetActivityResponce;
import com.pushkjn.bored.exceptions.ActivityNotFoundException;
import com.pushkjn.bored.model.Activity;
import com.pushkjn.bored.repository.ActivityRepository;
import com.pushkjn.bored.service.ActivityService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository repo;
    private final Random randomizer = new Random();

    @Override
    public CreateActivityResponce createActivity(Activity a) {
        Activity createdActivity = repo.save(a);

        CreateActivityResponce responce = new CreateActivityResponce(createdActivity.getExternal_id());

        return responce;
    }

    @Override
    public List<GetActivityResponce> getAllActivities() {
        return repo.findAll().stream()
                .map(GetActivityResponce::from)
                .toList();
    }

    @Override
    public GetActivityResponce getRandomActivity(String category, Integer minChallenge, Integer maxChallenge) {
        List<Long> ids = repo.getActivitiesIds(category, minChallenge, maxChallenge);

        Activity randomActivity = repo.findById(ids.get(randomizer.nextInt(ids.size())))
                .orElseThrow(() -> new ActivityNotFoundException("No such activity"));

        return GetActivityResponce.from(randomActivity);
    }
}
