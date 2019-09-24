package com.lambdaschool.liftingweights.controllers;

import com.lambdaschool.liftingweights.models.ErrorDetail;
import com.lambdaschool.liftingweights.models.Exercise;
import com.lambdaschool.liftingweights.models.User;
import com.lambdaschool.liftingweights.models.UserWorkout;
import com.lambdaschool.liftingweights.services.ExerciseService;
import com.lambdaschool.liftingweights.services.UserWorkoutService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    private static final Logger logger = LoggerFactory.getLogger(WorkoutController.class);

    @Autowired
    ExerciseService exerciseService;

    @Autowired
    UserWorkoutService workoutService;

    //  BASE URL: https://weight-lifting-journal-bw.herokuapp.com/
    //  GET /workouts/all - lists all previous workouts
    @ApiOperation(value = "Returns all previous workouts with ability for paging and sorting.", response = UserWorkout.class, responseContainer = "List")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "integer", paramType = "query",
                    value = "Results page you want to retrieve (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "integer", paramType = "query",
                    value = "Number of records per page."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "Sorting criteria in the format: property(,asc|desc). " +
                            "Default sort order is ascending. " +
                            "Multiple sort criteria are supported.")})
    @ApiResponses({
            @ApiResponse(code = 200, response = UserWorkout.class, responseContainer = "List", message = "It worked!")
    })
    @GetMapping(value = "/all", produces = {"application/json"})
    public ResponseEntity<?> getAllWorkouts(@PageableDefault(page = 0, size = 5)Pageable pageable) {
        List<UserWorkout> allWorkouts = new ArrayList<>();
        workoutService.findAllWorkouts(pageable).iterator().forEachRemaining(allWorkouts::add);
        return new ResponseEntity<>(allWorkouts, HttpStatus.OK);
    }

    // GET /workouts/{workoutid} - lists all exercises for a specific workout
    @ApiOperation(value = "Lists all exercises for a specific workout.")
    @ApiResponses({
            @ApiResponse(code = 200, response = UserWorkout.class, responseContainer = "List", message = "It worked!")
    })
    @GetMapping(value = "/{workoutid}", produces = {"application/json"})
    public ResponseEntity<?> getAllExercisesByWorkoutId(@PathVariable long workoutid) {
        UserWorkout workout = workoutService.findById(workoutid);

        List<Exercise> allExercises = new ArrayList<>();

        return new ResponseEntity<>(allExercises, HttpStatus.OK);
    }


    //  POST /workouts/current - create a new workout 201 & 500
    @ApiOperation(value = "Creates a new Workout", response = UserWorkout.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, response = UserWorkout.class, message = "It worked!"),
            @ApiResponse(code = 500, message = "Error creating a new workout.", response = ErrorDetail.class)
    })
    @PostMapping(value = "/current/{username}", produces = {"application/json"})
    public ResponseEntity<?> createNewWorkout(@Valid @RequestBody UserWorkout newWorkout, @PathVariable String username) {
        workoutService.saveWorkout(newWorkout, username);
        return new ResponseEntity<>( null, HttpStatus.CREATED);
    }


    //  POST /workouts/{workoutid} - add a new exercise to the workout
    @ApiOperation(value = "updates workout with a new exercise", response = UserWorkout.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Exercise successfully added to existing workout", response = void.class),
            @ApiResponse(code = 500, message = "Error updating workout exercise", response = ErrorDetail.class)
    })
    @PostMapping(value = "/{workoutid}", consumes = {"application/json"}, produces = {"application/json"})
    public ResponseEntity<?> updateWorkoutExercise(@Valid
                                                   @RequestBody Exercise newExercise,
                                                   @PathVariable long workoutid, HttpServletRequest request) {
        logger.trace(request.getMethod().toUpperCase() + " " + request.getRequestURI() + " accessed.");

        workoutService.saveExerciseToWorkout(workoutid, newExercise);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
