package com.lambdaschool.liftingweights.repository;

import com.lambdaschool.liftingweights.models.Exercise;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExerciseRepository extends PagingAndSortingRepository<Exercise, Long> {
}
