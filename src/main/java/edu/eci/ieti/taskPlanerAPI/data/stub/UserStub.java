package edu.eci.ieti.taskPlanerAPI.data.stub;

import edu.eci.ieti.taskPlanerAPI.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserStub {

    private List<User> users;

    public UserStub(){
        this.users = new ArrayList<>();
        users.add(new User("1", "Santiago", "Carrillo", "santiago.carrillo@mail.com"));
        users.add(new User("2", "Test", "testing", "test@mail.com"));
        users.add(new User("3", "Davor", "Cortes", "davor.cortes@mail.com"));
    }

    public List<User> getUsers() {

        return users;
    }

    public  User getUser(String id){

        return users.stream()
                            .filter(user -> user.getId().equals(id))
                            .findFirst()
                            .orElse(null);
    }

    public void addUser(User newUser) {
        users.add(newUser);
    }


    public void updateUser(User updatedUser){

        users.stream()
                .filter(user -> user.getId().equals(updatedUser.getId()))
                .findFirst()
                .ifPresent(user -> {
                    user.setName(updatedUser.getName());
                    user.setLastName(updatedUser.getLastName());
                    user.setEmail(updatedUser.getEmail());
                });
    }

    public void removeUser(String id){
        users.remove(getUser(id));
    }
}
