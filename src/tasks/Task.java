package tasks;

import java.util.Objects;

public class Task {
    protected Integer Id;
    private String title;
    private String description;
    private Status status;

    public Task(String title, String description) {
        Id = 0;
        this.title = title;
        this.description = description;
        status = Status.NEW;
    }

    public Task(String title, String description, Status status, Integer Id){
        this.Id = Id;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public Task(Task task){
        System.out.println(task);
        this.Id = task.Id;
        this.title = task.title;
        this.description = task.description;
        this.status = task.status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Id.equals(task.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + Id +
                ", title='" + title + '\'' +
                ", status=" + status +
                '}';
    }


}
