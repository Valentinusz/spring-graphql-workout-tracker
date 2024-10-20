package com.example.demo.exercise;

import com.example.demo.workoutset.WorkoutSet;
import com.example.demo.workoutset.WorkoutSetId;
import org.springframework.data.repository.CrudRepository;

import java.util.Map;
import java.util.Optional;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
    @Override
    Optional<Exercise> findById(Long aLong);
}
