package edu.eci.ieti.Tasks.data;

import edu.eci.ieti.Tasks.dto.Status;
import edu.eci.ieti.Tasks.dto.TaskDto;

public class Task {
    private String id;
    private String name;
    private String description;
    private Status status;
    private String assignedTo;
    private String dueDate;
    private String created;

    public Task(String id, TaskDto dto, String created) {
        this.id = id;
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.status = dto.getStatus();
        this.assignedTo = dto.getAssignedTo();
        this.dueDate = dto.getDueDate();
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", assignedTo='" + assignedTo + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", created='" + created + '\'' +
                '}';
    }
}