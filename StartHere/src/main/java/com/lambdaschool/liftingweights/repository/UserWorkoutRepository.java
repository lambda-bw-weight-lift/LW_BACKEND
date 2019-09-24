package com.lambdaschool.liftingweights.repository;

import com.lambdaschool.liftingweights.models.UserWorkout;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserWorkoutRepository extends PagingAndSortingRepository<UserWorkout, Long> {

//@Transactional
//@Modifying
//@Query("INSERT INTO USER(workoutid)")
//void addWorkoutToUser(long userid)
}
