package co.com.jorgecabrerasouto.ls.web.dto;

import java.util.HashSet;
import java.util.Set;

import co.com.jorgecabrerasouto.ls.persistence.model.Task;

public class ProjectDto {

    private Long id;

    private String name;

//    private LocalDate dateCreated;

    private Set<Task> tasks;

//    public ProjectDto(String name, LocalDate dateCreated) {
    public ProjectDto(String name) {
        this.name = name;
//        this.dateCreated = dateCreated;
        this.tasks = new HashSet<>();
    }

//    public ProjectDto(Long id, String name, LocalDate dateCreated) {
    public ProjectDto(Long id, String name) {
        this.id = id;
        this.name = name;
//        this.dateCreated = dateCreated;
        this.tasks = new HashSet<>();
    }
    
    protected ProjectDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public LocalDate getDateCreated() {
//        return dateCreated;
//    }
//
//    public void setDateCreated(LocalDate dateCreated) {
//        this.dateCreated = dateCreated;
//    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
//        result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((tasks == null) ? 0 : tasks.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ProjectDto other = (ProjectDto) obj;
//        if (dateCreated == null) {
//            if (other.dateCreated != null)
//                return false;
//        } else if (!dateCreated.equals(other.dateCreated))
//            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (tasks == null) {
            if (other.tasks != null)
                return false;
        } else if (!tasks.equals(other.tasks))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Project [id=" + id + ", name=" + name + ", tasks=" + tasks + "] \n";
    }

}
