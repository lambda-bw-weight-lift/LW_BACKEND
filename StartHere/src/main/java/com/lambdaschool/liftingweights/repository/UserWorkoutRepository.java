package com.lambdaschool.liftingweights.repository;

import com.lambdaschool.liftingweights.models.UserWorkout;
import org.springframework.data.repository.CrudRepository;

public interface UserWorkoutRepository  extends CrudRepository<UserWorkout, Long> {

    
}
