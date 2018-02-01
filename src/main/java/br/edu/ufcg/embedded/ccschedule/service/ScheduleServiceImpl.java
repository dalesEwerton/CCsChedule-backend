package br.edu.ufcg.embedded.ccschedule.service;

import br.edu.ufcg.embedded.ccschedule.model.Schedule;
import br.edu.ufcg.embedded.ccschedule.model.Task;
import br.edu.ufcg.embedded.ccschedule.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;


    @Override
    public Integer createSchedule() {
        Schedule schedule = new Schedule();
        return scheduleRepository.save(schedule).getId();
    }

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule findSchedule(Integer id) {
        return scheduleRepository.getOne(id);
    }

    @Override
    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Override
    public void deleteSchedule(Integer id) {
        scheduleRepository.delete(id);
    }

    @Override
    public Schedule addTaskToSchedule(Integer idSchedule, Integer indexTask, Task task) {

        Schedule schedule = scheduleRepository.getOne(idSchedule);
        schedule.addTask(indexTask, task);

        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule updateTaskInSchedule(Integer idSchedule, Integer indexTask, Task task) {

        Schedule schedule = scheduleRepository.getOne(idSchedule);
        schedule.updateTask(indexTask, task);

        return scheduleRepository.save(schedule);
    }

    @Override
    public Schedule removeTaskFromSchedule(Integer idSchedule, Integer indexTask) {

        Schedule schedule = scheduleRepository.getOne(idSchedule);
        schedule.removeTask(indexTask);

        return scheduleRepository.save(schedule);
    }
}
