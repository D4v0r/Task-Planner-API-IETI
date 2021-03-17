package edu.eci.ieti.taskPlanerAPI.services.user;

import edu.eci.ieti.taskPlanerAPI.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(String userId);

    User create(User user);

    User update(User user);

    void remove(String userId);
}
