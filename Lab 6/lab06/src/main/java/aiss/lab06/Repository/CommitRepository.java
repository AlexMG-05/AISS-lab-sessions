package aiss.lab06.Repository;

import aiss.lab06.Model.Commit;
import aiss.lab06.Model.Project;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class CommitRepository {
    List<Commit> commits = new ArrayList<>();

    public CommitRepository() {
        commits.add(
                new Commit(
                        UUID.randomUUID().toString(),
                        "Fixed README",
                        "Fixed some things from the README file",
                        "user1@example.com",
                        LocalDateTime.of(2025, 1, 1, 12, 30)
                )
        );
        commits.add(
                new Commit(
                        UUID.randomUUID().toString(),
                        "Example 2",
                        "Fixed some things from the Example 2 file",
                        "user1@example.com",
                        LocalDateTime.of(2025, 1, 2, 12, 30)
                )
        );
        commits.add(
                new Commit(
                        UUID.randomUUID().toString(),
                        "Example 3",
                        "Fixed some things from the Example 3 file",
                        "user1@example.com",
                        LocalDateTime.of(2025, 1, 3, 12, 30)
                )
        );
    }
    public List<Commit> findAll() { return commits; }

    public Commit findById(String id) {
        return commits.stream().filter(commit -> commit.getId().equals(id)).findFirst().orElse(null);
    }

    public Commit create(Commit commit) {
        Commit newCommit = new Commit(
                UUID.randomUUID().toString(),
                commit.getTitle(),
                commit.getMessage(),
                commit.getAuthor_email(),
                commit.getAuthored_date()
        );
        commits.add(newCommit);
        return newCommit;
    }

    public void update(Commit updatedCommit, String id) {
        Commit existingCommit = findById(id);
        int index = commits.indexOf(existingCommit);
        updatedCommit.setId(existingCommit.getId());
        commits.set(index, updatedCommit);
    }

    public void delete(String id) {
        commits.removeIf(c -> c.getId().equals(id));
    }
}
