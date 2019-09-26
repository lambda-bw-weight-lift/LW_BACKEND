package com.lambdaschool.liftingweights.services;

import com.lambdaschool.liftingweights.StartHereApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartHereApplication.class)


class UserWorkoutServiceImplTest {

@Autowired
private UserWorkoutServiceImpl userworkoutservice;


    @BeforeEach
    void setUp() {
    }

    @Test
    void findAllWorkouts() {
    }

    @Test
    void delete() {
        userworkoutservice.delete(100);
        assertEquals(1,userworkoutservice.findAll().size());
    }

    @Test
    void saveWorkout() {
    }

    @Test
    void saveExerciseToWorkout() {
    }

    @Test
    void findById() {
    }

    @Test
    void update() {
    }

    @Test
    void findAll() {
    }
}