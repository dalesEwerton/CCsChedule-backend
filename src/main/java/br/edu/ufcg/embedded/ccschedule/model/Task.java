package br.edu.ufcg.embedded.ccschedule.model;

import javax.persistence.*;

@Embeddable
public class Task {

    @Column
    private String taskName;

    @Column
    private String taskDescription;

    @Column int scheduleId;

    public Task(String taskName, String taskDescription, int scheduleId) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.scheduleId = scheduleId;
    }

    public Task(){}

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", taskName, taskDescription);
    }
}