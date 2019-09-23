package com.lambdaschool.liftingweights.controllers;

import com.lambdaschool.liftingweights.services.ExerciseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercises")
public class ExerciseController {

    private static final Logger logger = LoggerFactory.getLogger(ExerciseController.class);

    @Autowired
    ExerciseService exerciseService;

    // GET https://weight-lifting-journal-bw.herokuapp.com/exercises
    // lists all the exercises for a specific past workout - done in workout controller

    // PUT https://weight-lifting-journal-bw.herokuapp.com/exercise/{date}/{id} - edit the current exercise

    // DELETE https://weight-lifting-journal-bw.herokuapp.com/exercise/{date}/{id} - delete the current exercise




    // for workout endpoints

//    https://weight-lifting-journal-bw.herokuapp.com/
//    1. GET workouts/{userid}/previous - lists all previous workouts
//    2. GET workouts/{userid}/previous/{date} - lists all exercises for a specific past workout
//    3. POST workouts/{userid}/exercise/{date} - add a new exercise to the current workout

}