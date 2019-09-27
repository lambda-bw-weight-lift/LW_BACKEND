package com.lambdaschool.liftingweights.controllers;

import com.lambdaschool.liftingweights.models.*;
import com.lambdaschool.liftingweights.services.ExerciseService;
import com.lambdaschool.liftingweights.services.UserWorkoutService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ExerciseController.class, secure = false)
@EnableAutoConfiguration(exclude = JpaRepositoriesAutoConfiguration.class)
public class ExerciseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserWorkoutService userWorkoutService;

    @MockBean
    private ExerciseService exerciseService;

    private ArrayList<Exercise> exerciseList;

    @Before
    public void setUp() {
        exerciseList = new ArrayList<>();

        User newUser = new User();
        newUser.setUserid(2001);
        newUser.setUsername("username1");
        newUser.setPassword("password1");

        UserWorkout w1 = new UserWorkout(newUser, "09/26/19", "1:11:11", "09");

        Exercise e1 = new Exercise("soLong1", "20 lbs", "3 x 15", "3 min", "so tired1", w1);
        e1.setExerciseid(1001);
        exerciseList.add(e1);
        Exercise e2 = new Exercise("soLong2", "20 lbs", "3 x 15", "3 min", "so tired2", w1);
        e2.setExerciseid(1002);
        exerciseList.add(e2);
        Exercise e3 = new Exercise("soLong3", "20 lbs", "3 x 15", "3 min", "so tired3", w1);
        e3.setExerciseid(1003);
        exerciseList.add(e3);

    }

    @Test
    public void updateExerciseInfo() throws Exception {

        MockHttpServletRequestBuilder builder =
            MockMvcRequestBuilders.put("/exercise/{exerciseid}", 1001)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(getArticleInJson(1001));
        this.mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Exercise updated."))
                .andDo(MockMvcResultHandlers.print());
//        Mockito.when(exerciseService.findExerciseById(1001)).thenReturn();


    }
    private String getArticleInJson(long id) {
        return "{\"exerciseid\":\"" + id + "\", \"exercisename\":\"test data\"}";
    }
}
