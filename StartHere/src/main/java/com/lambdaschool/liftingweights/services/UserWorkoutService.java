package com.lambdaschool.liftingweights.services;

import com.lambdaschool.liftingweights.models.Exercise;
import com.lambdaschool.liftingweights.models.UserWorkout;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public interface UserWorkoutService {

    List<UserWorkout> findAllWorkouts(Pageable pageable);

    void delete(long workoutid);

    UserWorkout saveWorkout(UserWorkout workout, String username);

    Exercise saveExerciseToWorkout(long workoutid, Exercise exercise);

    UserWorkout update(UserWorkout workout, long id);

    UserWorkout findById(long workoutid);

    ArrayList<UserWorkout> findAll();

}
