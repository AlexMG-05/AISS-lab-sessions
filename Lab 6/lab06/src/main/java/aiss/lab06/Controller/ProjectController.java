package aiss.lab06.Controller;

import aiss.lab06.Model.Project;
import aiss.lab06.Repository.ProjectRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectController(ProjectRepository projectRepository) { this.projectRepository = projectRepository; }

    //GET http://localhost:8080/api/projects
    @GetMapping
    public List<Project> findAll() { return projectRepository.findAll(); }

    //GET http://localhost:8080/api/projects/{id}
    @GetMapping("/{id}")
    public Project findById(@PathVariable String id) { return projectRepository.findById(id); }

    //POST http://localhost:8080/api/projects
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Project create(@Valid @RequestBody Project project) { return projectRepository.create(project); }

    //PUT http://localhost:8080/api/projects/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Project updatedProject, @PathVariable String id) { projectRepository.update(updatedProject, id); }

    //DELETE http://localhost:8080/api/projects/{id}
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) { projectRepository.delete(id); }
}
