package com.lambdaschool.liftingweights.services;

import com.lambdaschool.liftingweights.models.Exercise;

import java.util.List;

public interface ExerciseService {
    List<Exercise> findAllExercises();

    Exercise save(Exercise exercise);

    Exercise update(Exercise exercise, long id);

    void delete(long id);

}
