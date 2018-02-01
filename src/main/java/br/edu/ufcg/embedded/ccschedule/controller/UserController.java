package br.edu.ufcg.embedded.ccschedule.controller;

import br.edu.ufcg.embedded.ccschedule.model.Schedule;
import br.edu.ufcg.embedded.ccschedule.model.User;
import br.edu.ufcg.embedded.ccschedule.service.ScheduleServiceImpl;
import br.edu.ufcg.embedded.ccschedule.service.UserServiceImpl;
import br.edu.ufcg.embedded.ccschedule.util.AuthUser;
import br.edu.ufcg.embedded.ccschedule.util.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RequestMapping("/user")
@RestController
@CrossOrigin
public class UserController{


    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ScheduleServiceImpl scheduleService;

    /***
     * Authenticate a user in the system and returns the View Object fo the user
     *
     * @param authUser
     * @return ResponseEntity
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    private ResponseEntity<UserVO> authenticateUser(@RequestBody AuthUser authUser) {

        try {
            User user = userService.findUser(authUser.getUsername());

            if(user == null) {

                return new ResponseEntity("User doesn't exists", HttpStatus.NOT_FOUND);
            }else if(user.getPassword().equals(authUser.getPassword())) {

                UserVO userVO = parseToUserVO(user);
                return new ResponseEntity<>(userVO, HttpStatus.ACCEPTED);
            }else {

                return new ResponseEntity("Invalid Password", HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e) {
            return new ResponseEntity(e, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    /***
     * Create a user and save him in the system
     *
     * @param user
     * @return ResponseEntity
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    private ResponseEntity<UserVO> createUser(@RequestBody User user) {

        User checkUser = userService.findUser(user.getUsername());

        if(checkUser != null) {
            return new ResponseEntity("Username in use!", HttpStatus.CONFLICT);
        }else {
            Integer scheduleId = this.scheduleService.createSchedule();
            user.setScheduleId(scheduleId);
            userService.saveUser(user);
            UserVO userVO = parseToUserVO(userService.findUser(user.getUsername()));

            return new ResponseEntity<>(userVO, HttpStatus.CREATED);
        }
    }

    /***
     * Update user informations in the System
     * @param user
     * @return ResponseEntity
     */
    @RequestMapping(value = "/", method = RequestMethod.PUT)
    private ResponseEntity<UserVO> updateUser(@RequestBody User user) {

        User checkUser = userService.findUser(user.getUsername());

        if(checkUser == null) {

            return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
        }else {
            userService.saveUser(user);
            UserVO userVO = parseToUserVO(userService.findUser(user.getUsername()));

            return new ResponseEntity<>(userVO, HttpStatus.OK);
        }
    }

    /***
     * Delete a user in the System
     *
     * @param username
     * @return ResponseEntity
     */
    @RequestMapping(value = "/{username}", method = RequestMethod.DELETE)
    private ResponseEntity deleteUser(@PathVariable("username") String username) {

        User user = userService.findUser(username);

        if(user != null) {

            userService.deleteByUsername(username);
            return new ResponseEntity(HttpStatus.OK);
        }else {

            return new ResponseEntity("User not found", HttpStatus.NOT_FOUND);
        }
    }

    /***
     * Converts a user entity in a user view object
     *
     * @param user
     * @return
     */
    private UserVO parseToUserVO(User user) {

        UserVO userVO = new UserVO(
                user.getName(),
                user.getJob(),
                user.getAbout(),
                user.getScheduleId()
        );

        return userVO;
    }
}
