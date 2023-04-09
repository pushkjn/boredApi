package com.pushkjn.bored.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pushkjn.bored.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Long> getActivitiesIds(String category, Integer minChallenge, Integer maxChallenge);
}
