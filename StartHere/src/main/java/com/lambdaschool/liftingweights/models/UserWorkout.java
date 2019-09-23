package com.lambdaschool.liftingweights.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "userworkouts")
public class UserWorkout extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long workoutid;

    private String workoutname;

    Date date = new Date();

    private String workoutlength;

    @ManyToOne
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties("userworkouts")
    private User user;


    @OneToMany(mappedBy = "userworkout",
            cascade = CascadeType.ALL)
    @JsonIgnoreProperties("userworkout")
    private List<Exercise> exercises = new ArrayList<>();

    public UserWorkout() {

    }


    public UserWorkout( User user, String workoutname, String workoutlength) {
        this.workoutname = workoutname;

        this.workoutlength = workoutlength;
        this.user = user;
    }

    public long getWorkoutid() {
        return workoutid;
    }

    public void setWorkoutid(long workoutid) {
        this.workoutid = workoutid;
    }

    public String getWorkoutname() {
        return workoutname;
    }

    public void setWorkoutname(String workoutname) {
        this.workoutname = workoutname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getWorkoutlength() {
        return workoutlength;
    }

    public void setWorkoutlength(String workoutlength) {
        this.workoutlength = workoutlength;
    }

    public User getUser() {
        return user;
    }

    public void setUser_id(User user) {
        this.user = user;
    }
}
