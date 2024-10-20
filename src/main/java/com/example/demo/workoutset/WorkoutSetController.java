package com.example.demo.workoutset;

import com.example.demo.exercise.Exercise;
import com.example.demo.workout.Workout;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Parameter;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class WorkoutSetController {

    private final WorkoutSetRepository workoutSetRepository;

    @SchemaMapping
	public List<WorkoutSet> sets(Workout workout) {
		return workoutSetRepository.findAllByWorkoutId(workout.getId());
	}

//	@SchemaMapping
//	public Exercise exercise(WorkoutSet set) {
//		return set.getExercise();
//	}

	@SchemaMapping
	public int position(WorkoutSet set) {
		return set.getId().getPosition();
	}

	@BatchMapping(field = "exercise")
	public Map<WorkoutSet, Exercise> exerciseBatch(List<WorkoutSet> sets) {
        return sets.stream().collect(Collectors.toMap(Function.identity(), WorkoutSet::getExercise));
    }
}
