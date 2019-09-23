package com.lambdaschool.liftingweights.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Table(name = "userworkouts")
public class UserWorkout extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long workoutid;

    private String workoutname;

    private Date workoutdate;

    private Time workoutlenght;

    @ManyToOne
    @JoinColumn(name = "userid",
            nullable = false)
    @JsonIgnoreProperties("userworkouts")
    private User user;

    public UserWorkout() {
    }

    public UserWorkout(String workoutname, Date workoutdate, Time workoutlenght, User user) {
        this.workoutname = workoutname;
        this.workoutdate = workoutdate;
        this.workoutlenght = workoutlenght;
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

    public Date getWorkoutdate() {
        return workoutdate;
    }

    public void setWorkoutdate(Date workoutdate) {
        this.workoutdate = workoutdate;
    }

    public Time getWorkoutlenght() {
        return workoutlenght;
    }

    public void setWorkoutlenght(Time workoutlenght) {
        this.workoutlenght = workoutlenght;
    }

    public User getUser() {
        return user;
    }

    public void setUser_id(User user) {
        this.user = user;
    }
}
