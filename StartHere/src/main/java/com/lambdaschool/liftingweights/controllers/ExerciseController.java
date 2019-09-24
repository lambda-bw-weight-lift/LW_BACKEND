package com.lambdaschool.liftingweights.controllers;

import com.lambdaschool.liftingweights.models.ErrorDetail;
import com.lambdaschool.liftingweights.models.Exercise;
import com.lambdaschool.liftingweights.services.ExerciseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exercise")
public class ExerciseController {

    private static final Logger logger = LoggerFactory.getLogger(ExerciseController.class);

    @Autowired
    ExerciseService exerciseService;


    // PUT /exercise/{exerciseid} - edit the current exercise
    @ApiOperation(value = "Updates an exercise", response = Exercise.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, response = Exercise.class, message = "Exercise successfully updated."),
            @ApiResponse(code = 500, response = ErrorDetail.class, message = "Error updating exercise.")
    })
    public ResponseEntity<?> updateExerciseInfo(@RequestBody Exercise exercise, @PathVariable long exerciseid) {
        exerciseService.update(exercise, exerciseid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // DELETE /exercise/{exerciseid} - delete the current exercise
    @ApiOperation(value = "Deletes the current exercise", response = void.class)
    @DeleteMapping(value = "/{exerciseid}", produces = {"application/json"})
    public ResponseEntity<?> deleteExerciseById(@PathVariable long exerciseid) {
        exerciseService.delete(exerciseid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
