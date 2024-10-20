package com.example.demo.workoutset;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface WorkoutSetRepository extends ListCrudRepository<WorkoutSet, Long> {
    List<WorkoutSet> findAllByWorkoutId(long workoutId);
}
