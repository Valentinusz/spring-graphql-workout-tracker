package com.example.demo.workout;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends CrudRepository<Workout, Long> {
    Optional<Workout> findById(Long id);

    @EntityGraph(attributePaths = "workoutSets")
    Optional<Workout> findWithSetsById(Long id);

    List<Workout> findAllByUserId(Long userId);
}
