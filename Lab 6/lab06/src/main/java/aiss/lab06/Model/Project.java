package aiss.lab06.Model;

import java.util.ArrayList;
import java.util.List;

public class Project {
    private String id;
    private String name;
    private String web_url;
    private List<Commit> commitList;

    public Project(String id, String name, String web_url) {
        this.id = id;
        this.name = name;
        this.web_url = web_url;
        this.commitList = new ArrayList<Commit>();
    }

    //Getters
    public String getName() {return name;}

    public String getId() {return id;}

    public String getWeb_url() {return web_url;}

    public List<Commit> getCommitList() {return commitList;}

    //Setters
    public void setId(String id) {this.id = id;}

    public void setName(String name) {this.name = name;}

    public void setWeb_url(String web_url) {this.web_url = web_url;}

    public void setCommitList(List<Commit> commitList) {this.commitList = commitList;}
}
