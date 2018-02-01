package br.edu.ufcg.embedded.ccschedule.service;

import br.edu.ufcg.embedded.ccschedule.model.User;
import br.edu.ufcg.embedded.ccschedule.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository users;

    @Override
    public void saveUser(User user) {
        this.users.save(user);
    }

    @Override
    public void deleteByUsername(String username) {
        this.users.delete(username);
    }

    @Override
    public User findUser(String username) {
        return users.findOne(username);
    }

    @Override
    public List<User> findAll() {

        return users.findAll();
    }

    @Override
    public boolean linkSchedule(String username, int scheduleId) {

        User user = this.users.findOne(username);

        if(user.getScheduleId() == 0) {
            user.setScheduleId(scheduleId);
            this.users.save(user);
            return true;
        }else {

            return false;
        }
    }

    @Override
    public boolean updateLinkSchedule(String username, int scheduleId) {

        User user = this.users.findOne(username);

        if(user.getScheduleId() != 0) {
            user.setScheduleId(scheduleId);
            this.users.save(user);
            return true;
        }else {

            return false;
        }
    }
}
