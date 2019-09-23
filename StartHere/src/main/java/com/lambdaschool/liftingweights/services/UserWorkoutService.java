package com.lambdaschool.liftingweights.services;

import com.lambdaschool.liftingweights.models.Exercise;
import com.lambdaschool.liftingweights.models.UserWorkout;

import java.util.List;

public interface UserWorkoutService {

    List<UserWorkout> findAll();

    UserWorkout findWorkoutByName(String name);

    void delete(long workoutid);

    UserWorkout saveExerciseToWorkout(long workoutid, Exercise exercise);

    UserWorkout update(UserWorkout customer, long id);

}
