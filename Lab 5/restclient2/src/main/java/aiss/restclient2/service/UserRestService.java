package aiss.restclient2.service;

import aiss.restclient2.modelREST.UserRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserRestService {

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<UserRest> createUserRest(UserRest user) {
        HttpHeaders headers = new HttpHeaders();
        String token = "{your_token}"; //Here it is necessary to create a new token in the REST page (by linking your GitHub account)

        HttpEntity<UserRest> request = new HttpEntity<>(user, headers);
        headers.add("Authorization", "Bearer " + token);

        String uri = "https://gorest.co.in/public/v2/users";
        try{
            ResponseEntity<UserRest> response = restTemplate.exchange(
                    uri,
                    HttpMethod.POST,
                    request,
                    UserRest.class);
            return response;
        } catch (RestClientException e){
            throw new RuntimeException(e);
        }
    }
}
