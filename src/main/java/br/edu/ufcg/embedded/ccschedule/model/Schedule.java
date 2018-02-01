package br.edu.ufcg.embedded.ccschedule.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Schedule")
@Entity(name = "tb_schedule")
public class Schedule {

    public static final int HOURS = 7;
    public static final int DAYS = 7;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ElementCollection
    private List<Task> schedule;


    public Schedule() {
        this.schedule = new ArrayList<>();
        initSchedule();
    }

    public void addTask(int index, Task task){

        this.schedule.add(index, task);
        this.schedule.remove(index+1);
    }

    public void removeTask(int index){

        Task emptyTask = new Task("empty", "empty", this.id);
        this.schedule.add(index, emptyTask);
    }

    public void updateTask(int index, Task t){
        this.schedule.add(index, t);
        this.schedule.remove(index+1);
    }

    public int size() {
        return HOURS * DAYS;
    }

    public Task getTask(int index){
        return this.schedule.get(index);
    }

    public List<Task> getSchedule() {
        return schedule;
    }

    public Integer getId() {
        return id;
    }

    private void initSchedule() {

        Task emptyTask = new Task("empty", "empty", this.id);
        for(int i = 0 ; i < DAYS * HOURS; i++) {
            this.schedule.add(i, emptyTask);
        }
    }

}