package com.example.demo.workoutset;

import com.example.demo.workout.Workout;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WorkoutSetId implements Serializable {
    private Integer position;
    private Long workoutId;

    @Override
    public final boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer()
                                                                                     .getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer()
                                                                                              .getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass)
            return false;
        WorkoutSetId that = (WorkoutSetId) o;
        return getPosition() != null && Objects.equals(getPosition(), that.getPosition()) && getWorkoutId() != null && Objects.equals(getWorkoutId(), that.getWorkoutId());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(position, workoutId);
    }
}
