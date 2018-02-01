package br.edu.ufcg.embedded.ccschedule.service;

import br.edu.ufcg.embedded.ccschedule.model.Schedule;
import br.edu.ufcg.embedded.ccschedule.model.Task;

import java.util.List;

public interface ScheduleService {

    Integer createSchedule();
    Schedule saveSchedule(Schedule schedule);
    Schedule findSchedule(Integer id);
    List<Schedule> findAll();
    void deleteSchedule(Integer id);

    Schedule addTaskToSchedule(Integer idSchedule, Integer indexTask, Task task);
    Schedule updateTaskInSchedule(Integer idSchedule, Integer indexTask, Task task);
    Schedule removeTaskFromSchedule(Integer idSchedule, Integer index);
}
