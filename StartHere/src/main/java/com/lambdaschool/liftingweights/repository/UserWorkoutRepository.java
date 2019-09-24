package com.lambdaschool.liftingweights.repository;

import com.lambdaschool.liftingweights.models.UserWorkout;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserWorkoutRepository extends PagingAndSortingRepository<UserWorkout, Long> {


}
