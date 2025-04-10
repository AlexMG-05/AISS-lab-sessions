package aiss.lab06.Controller;

import aiss.lab06.Model.Commit;
import aiss.lab06.Model.Project;
import aiss.lab06.Repository.CommitRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commits")
public class CommitController {
    private final CommitRepository commitRepository;

    @Autowired
    public CommitController(CommitRepository commitRepository) { this.commitRepository = commitRepository; }

    //GET http://localhost:8080/api/commits
    @GetMapping
    public List<Commit> findAll() { return commitRepository.findAll(); }

    //GET http://localhost:8080/api/commits/{id}
    @GetMapping("/{id}")
    public Commit findById(@PathVariable String id) { return commitRepository.findById(id); }

    //POST http://localhost:8080/api/commits
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Commit create(@Valid @RequestBody Commit commit) { return commitRepository.create(commit); }

    //PUT http://localhost:8080/api/commits/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Commit updatedCommit, @PathVariable String id) { commitRepository.update(updatedCommit, id); }

    //DELETE http://localhost:8080/api/commits/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) { commitRepository.delete(id); }
}
