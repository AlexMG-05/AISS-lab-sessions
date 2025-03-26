package aiss.restclient2.service;

import aiss.restclient2.model.Commit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommitServiceTest {

    @Autowired
    CommitService service;

    @Test
    @DisplayName("Exercise 2: get all commits")
    void findAllCommits() {
        List<Commit> commits = service.findAllCommits("octocat", "hello-world");
        //List<Commit> commits = service.findAllCommits("spring-projects", "spring-framework");
        assertFalse(commits.isEmpty(), "The list of commits is empty");
        System.out.println(commits);
        System.out.println("Number of commits: " + commits.size() + "\nThe maximun allowed to be shown is 30, but in reality there are more");
    }

    @Test
    @DisplayName("Exercise 3: get paginated commits")
    void findAllCommitsPagination() {
        //List<Commit> commits = service.findAllCommitsPagination("octocat", "hello-world");
        List<Commit> commits = service.findAllCommitsPagination("spring-projects", "spring-framework");
        assertFalse(commits.isEmpty(), "The list of commits is empty");
        System.out.println("Size of paginated commits " + commits.size());
    }
}