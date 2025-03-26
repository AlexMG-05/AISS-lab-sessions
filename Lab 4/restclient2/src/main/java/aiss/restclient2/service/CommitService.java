package aiss.restclient2.service;

import aiss.restclient2.model.Commit;

import aiss.restclient2.model.Commits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CommitService {
    @Autowired
    RestTemplate restTemplate;

    //Exercise 2
    public List<Commit> findAllCommits(String owner, String repo) {
        String baseUri = "https://api.github.com/repos/";
        String uri = baseUri + owner + "/" + repo + "/commits";
        //Option 1: getForObject
        Commit[] commitList = restTemplate.getForObject(uri, Commit[].class);
        return Arrays.stream(commitList).toList();
    }

    //Exercise 3: pagination
    private ResponseEntity<Commit[]> findAllCommitsPagination(String uri){
        HttpHeaders headers = new HttpHeaders();
        String token = "{your token}";

        if(token != "") {
            headers.add("Authorization", "Bearer " + token); //Sets auth header as in Postman
        }

        HttpEntity<Commit[]> request = new HttpEntity<>(null, headers);
        ResponseEntity<Commit[]> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                request,
                Commit[].class
        );
        return response;
    }

    public List<Commit> findAllCommitsPagination(String owner, String repo) {
        HttpHeaders headers = new HttpHeaders();
        String token = "{your token}";

        String baseUri = "https://api.github.com/repos/";
        String uri = baseUri + owner + "/" + repo + "/commits";

        List<Commit> commits = new ArrayList<>();
        boolean hasMorePages = true;
        int page = 1;  //We start from page 1

        headers.setBearerAuth(token); //Sets the token in the Authorization header, like in Postman
        while (hasMorePages && page <= 30) {
            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(uri).queryParam("page", page);
            HttpEntity<?> entity = new HttpEntity<>(headers); //Creates the http headers

            ResponseEntity<Commit[]> response = restTemplate.exchange(
                    uriBuilder.toUriString(),
                    HttpMethod.GET,
                    entity,
                    Commit[].class
            );   //Whatever this shit does, copilot autofilled it and works

            List<Commit> pageCommits = Arrays.asList(response.getBody());
            commits.addAll(pageCommits);

            //Checks if there are more pages remaining
            String linkHeader = response.getHeaders().getFirst("Link");
            if (linkHeader == null || !linkHeader.contains("rel=\"next\"")) hasMorePages = false;
            else page ++;
        }
        return commits;
    }

}
