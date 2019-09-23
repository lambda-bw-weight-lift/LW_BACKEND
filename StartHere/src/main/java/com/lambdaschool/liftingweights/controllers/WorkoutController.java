package com.lambdaschool.liftingweights.controllers;

import com.lambdaschool.liftingweights.models.ErrorDetail;
import com.lambdaschool.liftingweights.models.Exercise;
import com.lambdaschool.liftingweights.models.UserWorkout;
import com.lambdaschool.liftingweights.services.ExerciseService;
import com.lambdaschool.liftingweights.services.UserWorkoutService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private static final Logger logger = LoggerFactory.getLogger(WorkoutController.class);

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    UserWorkoutService workoutService;

    //    https://weight-lifting-journal-bw.herokuapp.com/
    //    1. GET workouts/{userid}/previous - lists all previous workouts


    //    2. GET workouts/{userid}/previous/{date}/{workoutid} - lists all exercises for a specific past workout


    //    3. POST workouts/{userid}/exercise/{date} - add a new exercise to the current workout
    @ApiOperation(value = "updates workout with a new exercise", response = UserWorkout.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Exercise successfully added to existing workout", response = void.class),
            @ApiResponse(code = 500, message = "Error updating workout exercise", response = ErrorDetail.class)
    })
    @PostMapping(value = "/workouts/{userid}/exercise/{workoutid}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> updateBookAuthor(@Valid
                                              @RequestBody Exercise exercise,
                                              @PathVariable
                                                      long userid, @PathVariable long workoutid, HttpServletRequest request) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed.");

        workoutService.saveExerciseToWorkout(workoutid, exercise);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
