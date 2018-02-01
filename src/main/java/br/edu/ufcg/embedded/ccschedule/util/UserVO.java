package br.edu.ufcg.embedded.ccschedule.util;

public class UserVO {

    private String name;
    private String job;
    private String about;
    private int scheduleId;

    public UserVO(String name, String job, String about, int scheduleId) {
        this.name = name;
        this.job = job;
        this.about = about;
        this.scheduleId = scheduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }
}
