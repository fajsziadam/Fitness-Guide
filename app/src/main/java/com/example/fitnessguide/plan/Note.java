package com.example.fitnessguide.plan;

import com.google.firebase.Timestamp;

public class Note {
    String title;
    String muscle;
    String excercises;
    String repeate;
    Timestamp timestamp;

    public Note() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMuscle() {
        return muscle;
    }

    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }

    public String getExcercises() {
        return excercises;
    }

    public void setExcercises(String excercises) {
        this.excercises = excercises;
    }

    public String getRepeate() {
        return repeate;
    }

    public void setRepeate(String repeate) {
        this.repeate = repeate;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
