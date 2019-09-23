package com.lambdaschool.liftingweights.repository;

import com.lambdaschool.liftingweights.models.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}
