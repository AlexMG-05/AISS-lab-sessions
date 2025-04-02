package aiss.restclient2.service;

import aiss.restclient2.model.User;
import aiss.restclient2.model.UserResponse;
import aiss.restclient2.model.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    RestTemplate restTemplate;

    public List<User> findAllUsers(){
        List<User> users = null;
        String uri = "https://reqres.in/api/users";
        //Option 1: getForObject
        UserList userList = restTemplate.getForObject(uri, UserList.class);
        users = userList.getData();
        return users;
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
}
