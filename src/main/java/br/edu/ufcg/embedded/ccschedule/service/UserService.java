package br.edu.ufcg.embedded.ccschedule.service;

import br.edu.ufcg.embedded.ccschedule.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    void deleteByUsername(String username);

    User findUser(String username);

    List<User> findAll();

    boolean linkSchedule(String username, int scheduleId);

    boolean updateLinkSchedule(String username, int scheduleId);

}
