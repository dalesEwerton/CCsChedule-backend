package br.edu.ufcg.embedded.ccschedule.model;

import javax.persistence.*;
import java.util.Objects;
import java.lang.String;

@Table(name = "User")
@Entity(name = "tb_user")
public class User {

    @Id
    private String username;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private int scheduleId;

    @Column
    private String job;

    @Column
    private String about;

    public User() { }

    public User(String name, String username, String password, String job, String about) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.scheduleId = 0;
        this.job = job;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {

        return Objects.hash(username);
    }
}