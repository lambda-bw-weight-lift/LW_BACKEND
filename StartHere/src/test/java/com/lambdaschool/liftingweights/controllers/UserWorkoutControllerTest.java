package com.lambdaschool.liftingweights.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.liftingweights.models.User;
import com.lambdaschool.liftingweights.models.UserWorkout;
import com.lambdaschool.liftingweights.services.UserService;
import com.lambdaschool.liftingweights.services.UserWorkoutService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.Assert.assertEquals;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@WebMvcTest(value = WorkoutController.class, secure = false)
public class UserWorkoutControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserWorkoutService workoutService;

    @MockBean
    private UserService userService;

    private ArrayList<UserWorkout> userWorkoutsList;

    @Before
    public void setUp() {
        userWorkoutsList = new ArrayList<>();

        User newUser = new User();
        newUser.setUserid(2001);
        newUser.setUsername("username1");
        newUser.setPassword("password1");

        UserWorkout w1 = new UserWorkout(newUser, "09/26/19", "1:11:11", "09");
        w1.setWorkoutid(500);
        userWorkoutsList.add(w1);
        UserWorkout w2 = new UserWorkout(newUser, "09/25/19", "1:25:00", "01");
        w2.setWorkoutid(501);
        userWorkoutsList.add(w2);
        UserWorkout w3 = new UserWorkout(newUser, "09/24/19", "1:22:11", "06");
        w3.setWorkoutid(502);
        userWorkoutsList.add(w3);
    }

    @Test
    public void getAllWorkouts() throws Exception {
        String apiUrl = "/workouts/all";

        Mockito.when(workoutService.findAll()).thenReturn(userWorkoutsList);

        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);

        MvcResult r = mockMvc.perform(rb).andReturn();

        String tr = r.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(userWorkoutsList);

        assertEquals("Rest API returns List", er, tr);
    }

//    @Test
//    public void getRestaurantByIdFound() throws Exception {
//        String apiUrl = "/workouts/12";
//
//
//        Mockito.when(workoutService.findById(12)).thenReturn(workoutService.get(1));
//
//
//        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);
//
//
//        MvcResult r = mockMvc.perform(rb).andReturn();
//        String tr = r.getResponse().getContentAsString();
//
//
//        ObjectMapper mapper = new ObjectMapper();
//        String er = mapper.writeValueAsString(workoutService.get(1));
//
//
//        assertEquals("Rest API returns List", er, tr);
//    }
//
//
//    @Test
//    public void addNewCourse() throws Exception {
//        String apiUrl = "/workouts/current/{username}";
//
//        User newUser = new User();
//        newUser.setUsername("WorkoutTest");
//        newUser.setPassword("TestPassword1");
//        userService.save(newUser);
//
//        UserWorkout newWorkout = new UserWorkout(newUser, "09/26/19", "1:11:11", "09");
//        newWorkout.setWorkoutid(1234);
//
//        ObjectMapper mapper = new ObjectMapper();
//        String courseString = mapper.writeValueAsString(newWorkout);
//
//        Mockito.when(workoutService.saveWorkout(any(UserWorkout.class))).thenReturn(newWorkout);
//
//        RequestBuilder rb = MockMvcRequestBuilders.post(apiUrl).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(courseString);
//
//        mockMvc.perform(rb).andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//    }
}
