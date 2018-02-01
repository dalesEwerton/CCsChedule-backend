package br.edu.ufcg.embedded.ccschedule.controller;

import br.edu.ufcg.embedded.ccschedule.model.Schedule;
import br.edu.ufcg.embedded.ccschedule.model.Task;
import br.edu.ufcg.embedded.ccschedule.service.ScheduleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/schedule")
@RestController
@CrossOrigin
public class ScheduleController {

    @Autowired
    ScheduleServiceImpl scheduleService;

    /***
     * Create and save a Schedule in the System
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Integer> create() {

        try {
            Integer scheduleID = scheduleService.createSchedule();
            return new ResponseEntity<>(scheduleID, HttpStatus.CREATED);
        }catch (Exception e) {
            return  new ResponseEntity(e, HttpStatus.BAD_REQUEST);
        }
    }

    /***
     * Get all the schedules in the System
     *
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Schedule>> all() {

        return new ResponseEntity<>(scheduleService.findAll(), HttpStatus.OK);
    }

    /***
     * Get a specific schedule in the System by the ID
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<Task>> getSchedule(@PathVariable("id") int id) {

        Schedule schedule = scheduleService.findSchedule(id);

        if(schedule != null) {

            return new ResponseEntity<>(schedule.getSchedule(), HttpStatus.OK);
        }else {
            return new ResponseEntity("No schedule for ID",HttpStatus.BAD_REQUEST);
        }
    }

    /***
     * Removes a schedule from the System
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteSchedule(@PathVariable("id") int id) {

        scheduleService.deleteSchedule(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    /***
     * Adds a task in a specific schedule in the System
     *
     * @param task
     * @param index
     * @return
     */
    @RequestMapping(value = "/task/{index}", method = RequestMethod.POST)
    public ResponseEntity<Schedule> addTaskToSchedule(@RequestBody Task task, @PathVariable("index") int index) {

        int scheduleId = task.getScheduleId();


        if(task != null) {
            Schedule response = scheduleService.addTaskToSchedule(scheduleId, index, task);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    /***
     * Updates a Task from a specific schedule in the System
     *
     * @param task
     * @param index
     * @return
     */
    @RequestMapping(value = "/task/{index}", method = RequestMethod.PUT)
    public ResponseEntity<Schedule> updateTaskInShceule(@RequestBody Task task, @PathVariable("index") int index) {

        int scheduleId = task.getScheduleId();

        if(task != null) {
            Schedule response = scheduleService.updateTaskInSchedule(scheduleId, index, task);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    /***
     * Removes a task from a specific schedule in the System
     *
     * @param scheduleId
     * @param index
     * @return
     */
    @RequestMapping(value = "/task/{scheduleId}/{index}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTaskFromSchedule( @PathVariable("scheduleId") int scheduleId
            ,@PathVariable("index") int index) {

        scheduleService.removeTaskFromSchedule(scheduleId, index);
        return new ResponseEntity(HttpStatus.OK);
    }
}
