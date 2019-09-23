package com.lambdaschool.liftingweights.services;

import com.lambdaschool.liftingweights.models.Exercise;
import com.lambdaschool.liftingweights.models.UserWorkout;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userWorkoutService")
public class UserWorkoutServiceImpl implements UserWorkoutService {
    @Override
    public List<UserWorkout> findAll() {
        return null;
    }

    @Override
    public UserWorkout findWorkoutByName(String name) {
        return null;
    }

    @Override
    public void delete(long workoutid) {

    }

    @Override
    public UserWorkout saveExerciseToWorkout(long workoutid, Exercise exercise) {
        return null;
    }

    @Override
    public UserWorkout update(UserWorkout customer, long id) {
        return null;
    }
}
