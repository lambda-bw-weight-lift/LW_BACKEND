package com.lambdaschool.liftingweights.services;


import com.lambdaschool.liftingweights.StartHereApplication;
import com.lambdaschool.liftingweights.exceptions.ResourceNotFoundException;
import com.lambdaschool.liftingweights.models.Exercise;
import com.lambdaschool.liftingweights.models.User;
import com.lambdaschool.liftingweights.models.UserWorkout;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartHereApplication.class)
public class ExerciseServiceImplTest {

    @Autowired
    private UserWorkoutServiceImpl userworkoutservice;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ExerciseServiceImpl exerciseService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void findAllExercises2() {
        assertEquals(2, exerciseService.findAllExercises2().size());
    }

    @Test
    public void save() {
        User newUser = new User();
        newUser.setUsername("TestUser1");
        newUser.setPassword("TestPassword1");
        userService.save(newUser);

        UserWorkout newWorkout = new UserWorkout(newUser, "09/26/19", "1:11:11", "09");
        userworkoutservice.saveWorkout(newWorkout, newUser.getUsername());

        Exercise testExercise = new Exercise("soLong", "20 lbs", "3 x 15", "3 min", "so tired", newWorkout);
        exerciseService.save(testExercise);
        assertEquals("so tired", exerciseService.save(testExercise).getExerciseregion());

    }

    @Test
    public void update() {
        User newUser = new User();
        newUser.setUsername("TestUser1");
        newUser.setPassword("TestPassword1");
        userService.save(newUser);

        UserWorkout newWorkout = new UserWorkout(newUser, "09/26/19", "1:11:11", "09");
        userworkoutservice.saveWorkout(newWorkout, newUser.getUsername());
        Exercise updateExercise = new Exercise("PUMPED", "2000 lbs", "3 x 15", "3 min", "GAINS", newWorkout);

        updateExercise.setExerciseregion("MUSCLE");
        exerciseService.save(updateExercise);
        assertEquals("MUSCLE", exerciseService.save(updateExercise).getExerciseregion());
    }

    @Test
    public void deleteFound() {
        exerciseService.delete(101);
        assertEquals(1, exerciseService.findAllExercises2().size());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void deleteNotFound() {
        exerciseService.delete(1000);
        assertEquals(1, exerciseService.findAllExercises2().size());
    }
}