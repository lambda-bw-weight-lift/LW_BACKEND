package com.lambdaschool.liftingweights.services;

import com.lambdaschool.liftingweights.exceptions.ResourceNotFoundException;
import com.lambdaschool.liftingweights.models.Exercise;
import com.lambdaschool.liftingweights.models.User;
import com.lambdaschool.liftingweights.models.UserWorkout;
import com.lambdaschool.liftingweights.repository.ExerciseRepository;
import com.lambdaschool.liftingweights.repository.UserWorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userWorkoutService")
public class UserWorkoutServiceImpl implements UserWorkoutService {
    @Autowired
    UserWorkoutRepository userworkoutrepo;

    @Autowired
    ExerciseRepository exerciserepo;

    @Override
    public List<UserWorkout> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public UserWorkout findWorkoutByName(String name) {
        return null;
    }

    @Override
    public void delete(long workoutid) {

    }

    @Transactional
    @Override
    public UserWorkout saveWorkout(UserWorkout workout) {
        return null;
    }

    @Override
    public UserWorkout saveExerciseToWorkout(long workoutid, Exercise exercise) {
        UserWorkout uw = userworkoutrepo.findById(workoutid)
                .orElseThrow(() -> new ResourceNotFoundException("Workout id" + workoutid + " not found!"));
        Exercise ex = new Exercise(exercise.getExercisename(), exercise.getWeightlifted(), exercise.getReps(), exercise.getRestperiod(), exercise.getExerciseregion());

        uw.getExercises().add(ex);
        return userworkoutrepo.save(uw);
    }


    @Override
    public UserWorkout findById(long workoutid) throws ResourceNotFoundException {
        return userworkoutrepo.findById(workoutid)
                .orElseThrow(() -> new ResourceNotFoundException("Workout id" + workoutid + "not Found!"));
    }


    @Override
    public UserWorkout update(UserWorkout customer, long id) {
        return null;
    }


}
