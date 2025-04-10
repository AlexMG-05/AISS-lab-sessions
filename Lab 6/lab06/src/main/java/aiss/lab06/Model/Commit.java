package aiss.lab06.Model;

import java.time.LocalDateTime;

public class Commit {
    private String id;
    private String title;
    private String message;
    private String author_email;
    private LocalDateTime authored_date;

    public Commit(String id, String title, String message, String author_email, LocalDateTime authored_date) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.author_email = author_email;
        this.authored_date = authored_date;
    }

    // Getters
    public String getId() { return id; }
    public String getMessage() { return message; }
    public String getAuthor_email() { return author_email; }
    public LocalDateTime getAuthored_date() { return authored_date; }
    public String getTitle() { return title; }

    // Setters
    public void setId(String id) { this.id = id; }
    public void setMessage(String message) { this.message = message; }
    public void setAuthor_email(String author_email) { this.author_email = author_email; }
    public void setAuthored_date(LocalDateTime authored_date) { this.authored_date = authored_date; }
    public void setTitle(String title) { this.title = title; }


}
