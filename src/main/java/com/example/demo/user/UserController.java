package com.example.demo.user;

import com.example.demo.workout.Workout;
import com.example.demo.workout.WorkoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    public final UserRepository userRepository;
    public final WorkoutRepository workoutRepository;

    @QueryMapping
    public User me() {
        return userRepository.findById(1L);
    }

    @SchemaMapping(typeName = "User", field = "workouts")
    public List<Workout> workouts() {
        return workoutRepository.findAllByUserId(1L);
    }
}
