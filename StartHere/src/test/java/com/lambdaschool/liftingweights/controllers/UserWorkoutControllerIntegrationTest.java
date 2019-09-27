package com.lambdaschool.liftingweights.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.liftingweights.models.Exercise;
import com.lambdaschool.liftingweights.models.User;
import com.lambdaschool.liftingweights.models.UserWorkout;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.lessThan;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserWorkoutControllerIntegrationTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void initialiseRestAssuredMockMvcWebApplicationContext() {
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }

    @Test
    public void whenMeasuredResponseTime() {
        given().when().get("/workouts/all").then().time(lessThan(5000L));
    }

    @Test
    public void whenMeasuredResponseTime2() {
        given().when().get("/workouts/12").then().time(lessThan(5000L));
    }

    @Test
    public void givenPostAWorkout() throws Exception {

        ArrayList<UserWorkout> thisPay = new ArrayList<>();
        User newUser = new User();
        newUser.setUsername("TestUser1");
        newUser.setPassword("TestPassword1");

        UserWorkout newWorkout = new UserWorkout(newUser, "09/26/19", "1:11:11", "09");


        newWorkout.getExercises().add(new Exercise("soLong", "20 lbs", "3 x 15", "3 min", "so tired", newWorkout));


        // we have a java object that we need to convert to json with the following lines
        ObjectMapper mapper = new ObjectMapper();
        String stringR3 = mapper.writeValueAsString(newWorkout);

        given().contentType("application/json").body(stringR3).when().post("/workouts/current/barnbarn").then().statusCode(201);
    }

}
