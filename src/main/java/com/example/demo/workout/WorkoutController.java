package com.example.demo.workout;

import graphql.schema.DataFetchingEnvironment;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Set;

@Controller
@RequiredArgsConstructor
public class WorkoutController {
    private final WorkoutRepository workoutRepository;

    @QueryMapping
    public Workout workout(@Argument long id, DataFetchingEnvironment env) {
        if (env.getSelectionSet().contains("sets")) {
            return workoutRepository.findWithSetsById(id).orElse(null);
        }
        return workoutRepository.findById(id).orElse(null);
    }
}
