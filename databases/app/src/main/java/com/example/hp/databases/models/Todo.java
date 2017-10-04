package com.example.hp.databases.models;

/**
 * Created by Hp on 9/29/2017.
 */

public class Todo {
    int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    String task;
    boolean done;

    public Todo(int id, String task, boolean done) {
        this.id = id;
        this.task = task;
        this.done = done;
    }

    public Todo(String task, boolean done) {
        this.task = task;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public boolean isDone() {
        return done;
    }
}
