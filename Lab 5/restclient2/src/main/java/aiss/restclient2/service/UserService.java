package aiss.restclient2.service;

import aiss.restclient2.model.User;
import aiss.restclient2.model.UserList;
import aiss.restclient2.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;
    //Exception handling (exercise 4) added
    public List<User> findAllUsers(){
        String uri = "https://reqres.in/api/users";
        List<User> users = null;
        try {
            //Option 1: getForObject
            UserList userList = restTemplate.getForObject(uri, UserList.class);
            users = userList.getData();
            return users;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public UserResponse findUserById(int id){
        String uri = "https://reqres.in/api/users/" + id;
        try{
            UserResponse user = restTemplate.getForObject(uri, UserResponse.class);
            return user;
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }

    public User createUser(User user){
        String uri = "https://reqres.in/api/users";
        try{
            User createdUser = restTemplate.postForObject(uri, user, User.class);
            return createdUser;
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }

    public User updateUser(User user, Integer id){
        String uri = "https://reqres.in/api/users/" + id;
        try{
            HttpEntity<User> request = new HttpEntity<>(user);
            ResponseEntity<User> response = restTemplate.exchange(uri, HttpMethod.PUT, request, User.class);
            User updatedUser = response.getBody();
            return updatedUser;
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteUser(int id){
        String uri = "https://reqres.in/api/users/" + id;
        try{
            restTemplate.delete(uri);
        } catch (RestClientException e) {
            throw new RuntimeException(e);
        }
    }
}
