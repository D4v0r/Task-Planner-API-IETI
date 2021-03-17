package edu.eci.ieti.taskPlanerAPI.services.user.impl;

import edu.eci.ieti.taskPlanerAPI.data.stub.UserStub;
import edu.eci.ieti.taskPlanerAPI.model.User;
import edu.eci.ieti.taskPlanerAPI.services.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserStub stub;

    {
        stub = new UserStub();
    }

    @Override
    public List<User> getAll() {
        return stub.getUsers();
    }

    @Override
    public User getById(String userId) {
        return stub.getUser(userId);
    }

    @Override
    public User create(User user) {
        stub.addUser(user);

        return getById(user.getId());
    }

    @Override
    public User update(User user) {

        stub.updateUser(user);
        return getById(user.getId());
    }

    @Override
    public void remove(String userId) {
        stub.removeUser(userId);
    }
}
