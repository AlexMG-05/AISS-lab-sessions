package aiss.lab06.Repository;

import aiss.lab06.Model.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProjectRepository {
    List<Project> projects = new ArrayList<>();

    public ProjectRepository() {
        projects.add(
                new Project(
                        UUID.randomUUID().toString(),
                        "project1",
                        "www.github.com/user1/project1"
                )
        );
        projects.add(
                new Project(
                        UUID.randomUUID().toString(),
                        "project2",
                        "www.github.com/user1/project2"
                )
        );
        projects.add(
                new Project(
                        UUID.randomUUID().toString(),
                        "project3",
                        "www.github.com/user1/project3"
                )
        );
    }

    public List<Project> findAll() { return projects; }

    public Project findById(String id) {
        return projects.stream().filter(project -> project.getId().equals(id)).findFirst().orElse(null);
    }

    public Project create(Project project) {
        Project newProject = new Project(
                UUID.randomUUID().toString(),
                project.getName(),
                project.getWeb_url()
        );
        projects.add(newProject);
        return newProject;
    }

    public void update(Project updatedProject, String id) {
        Project existingProject = findById(id);
        int index = projects.indexOf(existingProject);
        updatedProject.setId(existingProject.getId());
        projects.set(index, updatedProject);
    }

    public void delete(String id) {
        projects.removeIf(p -> p.getId().equals(id));
    }
}
