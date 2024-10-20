package com.example.demo.exercise;

import com.example.demo.workoutset.WorkoutSet;
import graphql.ErrorType;
import graphql.GraphQLError;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.GraphQlExceptionHandler;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ExerciseController {
    private final ExerciseRepository exerciseRepository;

    @QueryMapping(name = "exercise")
    Exercise exerciseById(@Argument Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }
}
