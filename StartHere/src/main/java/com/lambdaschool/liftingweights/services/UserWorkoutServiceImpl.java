package com.lambdaschool.liftingweights.services;

import com.lambdaschool.liftingweights.models.Exercise;
import com.lambdaschool.liftingweights.models.UserWorkout;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userWorkoutService")
public class UserWorkoutServiceImpl implements UserWorkoutService {
    @Override
    public List<UserWorkout> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public UserWorkout findWorkoutByName(String name) {
        return null;
    }

    @Override
    public UserWorkout findById(long id) {
        return null;
    }

    @Override
    public void delete(long workoutid) {

    }

    @Override
    public UserWorkout saveWorkout(UserWorkout workout) {
        return null;
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
