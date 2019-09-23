package com.lambdaschool.liftingweights.services;

import java.util.List;

public interface UserWorkout {

    List<UserWorkout> findAll();

    UserWorkout findWorkoutByName(String name);

    void delete(long workoutid);

    UserWorkout save(UserWorkout customer);

    UserWorkout update(UserWorkout customer, long id);

}
