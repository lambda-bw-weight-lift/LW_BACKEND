package com.lambdaschool.liftingweights.repository;

import com.lambdaschool.liftingweights.models.Exercise;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ExerciseRepository extends PagingAndSortingRepository<Exercise, Long> {

}
