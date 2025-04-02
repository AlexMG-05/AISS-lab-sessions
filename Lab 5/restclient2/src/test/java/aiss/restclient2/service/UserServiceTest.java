package aiss.restclient2.service;

import aiss.restclient2.model.User;
import aiss.restclient2.model.UserResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService service;
    @Test
    @DisplayName("Get all users")
    void findAllUsers() {
        List<User> users = service.findAllUsers();
        assertFalse(users.isEmpty(), "The list of users is empty");
        System.out.println(users);
    }
    @Test
    void findUserById() {
        UserResponse user = service.findUserById(2);
        System.out.println(user);
    }

    @Test
    void createUser() {
        User newUser = new User();
        newUser.setFirstName("Pablo");
        newUser.setLastName("Motos");
        newUser.setEmail("pabmot@us.es");
        User createdUser = service.createUser(newUser);
        System.out.println(createdUser);
    }

    @Test
    void updateUser() {
        Integer id = 2;
        User u = new User();
        u.setFirstName("Ronaldo");
        u.setId(2);
        User updatedUser = service.updateUser(u, id);
        assertTrue(u.getId()==id, "The id is wrong");
        System.out.println(updatedUser);
    }


    @Test
    void deleteUser() {
        int id = 2;
        service.deleteUser(id);
        /*
        UserResponse user = service.findUserById(id);
        assertNull(user, "The user has been deleted");
        */
    }
}