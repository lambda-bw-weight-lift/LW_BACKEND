package com.lambdaschool.liftingweights.services;


import com.lambdaschool.liftingweights.exceptions.ResourceNotFoundException;
import com.lambdaschool.liftingweights.models.Exercise;
import com.lambdaschool.liftingweights.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "exerciseService")
public class ExerciseServiceImpl implements ExerciseService {

    @Autowired
    ExerciseRepository exerciserepos;


    @Override
    public List<Exercise> findAllExercises(Pageable pageable) {
        List<Exercise> myExercises = new ArrayList<>();
        exerciserepos.findAll(pageable).iterator().forEachRemaining(myExercises::add);
        return myExercises;
    }

    @Transactional
    @Override
    public Exercise save(Exercise exercise) {
        Exercise newExercise = new Exercise();

        newExercise.setExercisename(exercise.getExercisename());
        newExercise.setWeightlifted(exercise.getWeightlifted());
        newExercise.setReps(exercise.getReps());
        newExercise.setRestperiod(exercise.getRestperiod());
        newExercise.setExerciseregion(exercise.getExerciseregion());

//        newExercise.setWorkout(exercise.getWorkout());

        return exerciserepos.save(newExercise);
    }

    @Override
    public Exercise update(Exercise exercise, long id) {
        Exercise currentExercise = exerciserepos.findById(id).orElseThrow(() -> new ResourceNotFoundException("Exercise id " + id + " not found!"));

        if (exercise.getExercisename() != null) {
            currentExercise.setExercisename(exercise.getExercisename());
        }
        if (exercise.getWeightlifted() != null) {
            currentExercise.setExercisename(exercise.getWeightlifted());
        }
        if (exercise.getReps() != null) {
            currentExercise.setReps(exercise.getReps());
        }
        if (exercise.getRestperiod() != null) {
            currentExercise.setRestperiod(exercise.getRestperiod());
        }
        if (exercise.getExerciseregion() != null) {
            currentExercise.setExerciseregion(exercise.getExerciseregion());
        }

        return exerciserepos.save(currentExercise);
    }

    @Transactional
    @Override
    public void delete(long id) {
        if (exerciserepos.findById(id).isPresent()) {
            exerciserepos.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Workout id " + id + " not found.");
        }
    }
}
