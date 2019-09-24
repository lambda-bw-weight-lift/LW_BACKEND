package com.lambdaschool.liftingweights.repository;

import com.lambdaschool.liftingweights.models.UserWorkout;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserWorkoutRepository extends PagingAndSortingRepository<UserWorkout, Long> {

//    @Transactional
//    @Modifying
//    @Query(value = "INSERT INTO userworkouts (workoutid, exerciesid) values(:workoutid, exerciesid)", nativeQuery = true)
//    void insertExerciseIntoWorkouts(long workoutid, long exerciseid);
}
