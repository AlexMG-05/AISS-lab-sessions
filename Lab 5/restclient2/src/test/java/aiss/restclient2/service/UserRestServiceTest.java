package aiss.restclient2.service;

import aiss.restclient2.modelREST.UserRest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserRestServiceTest {
    @Autowired
    UserRestService service;

    @Test
    void createUserRest() {
        UserRest newUser = new UserRest();
        newUser.setName("Pablo");
        newUser.setEmail("pablo@motos.com");
        newUser.setGender("male");
        newUser.setStatus("active");

        ResponseEntity<UserRest> createdUser = service.createUserRest(newUser);
        System.out.println(createdUser);
    }
}