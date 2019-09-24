package com.lambdaschool.liftingweights.services;

import com.lambdaschool.liftingweights.models.Exercise;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExerciseService {
    List<Exercise> findAllExercises(Pageable pageable);

    Exercise save(Exercise exercise);

    Exercise update(Exercise exercise, long id);

    void delete(long id);

}
