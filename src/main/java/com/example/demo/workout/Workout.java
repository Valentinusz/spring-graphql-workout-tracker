package com.example.demo.workout;

import com.example.demo.exercise.Exercise;
import com.example.demo.user.User;
import com.example.demo.workoutset.WorkoutSet;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedAttributeNode;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.NamedEntityGraphs;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "workout")
@NamedEntityGraph(name = "Workout-WorkoutSet", attributeNodes = @NamedAttributeNode("workoutSets"))
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "workout")
    private Set<WorkoutSet> workoutSets;
}