package com.lambdaschool.liftingweights.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "exercises")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long exerciseid;

    @Column(nullable = false)
    private String exercisename;

    @Column(nullable = false)
    private String weightlifted;

    @Column(nullable = false)
    private String reps;

    @Column(nullable = false)
    private String restperiod;

    @Column(nullable = false)
    private String exerciseregion;

//    @ManyToOne
//    @JoinColumn(name = "")
//    @JsonIgnoreProperties("exercises")
//    private Workout workout;


    public Exercise() {
    }

    public Exercise(String exercisename, String weightlifted, String reps, String restperiod, String exerciseregion) {
        this.exercisename = exercisename;
        this.weightlifted = weightlifted;
        this.reps = reps;
        this.restperiod = restperiod;
        this.exerciseregion = exerciseregion;
    }

    public long getExerciseid() {
        return exerciseid;
    }

    public String getExercisename() {
        return exercisename;
    }

    public void setExercisename(String exercisename) {
        this.exercisename = exercisename;
    }

    public String getWeightlifted() {
        return weightlifted;
    }

    public void setWeightlifted(String weightlifted) {
        this.weightlifted = weightlifted;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public String getRestperiod() {
        return restperiod;
    }

    public void setRestperiod(String restperiod) {
        this.restperiod = restperiod;
    }

    public String getExerciseregion() {
        return exerciseregion;
    }

    public void setExerciseregion(String exerciseregion) {
        this.exerciseregion = exerciseregion;
    }
}
