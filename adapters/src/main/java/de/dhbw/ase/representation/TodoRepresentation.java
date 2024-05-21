package de.dhbw.ase.representation;

import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Status;
import lombok.Builder;

import java.util.UUID;

@Builder
public class TodoRepresentation {
    private UUID todoid;
    private String title;
    private String description;
    private Status status;
    private EndDate enddate;
    private UUID personID;

    public TodoRepresentation(UUID id, String title, String description, Status status, EndDate enddate, UUID personID) {
        this.todoid = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.enddate = enddate;
        this.personID = personID;
    }
    public TodoRepresentation(String title, String description, Status status, EndDate enddate, UUID personID) {
        this.todoid = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.status = status;
        this.enddate = enddate;
        this.personID = personID;
    }
    public TodoRepresentation(){}

    public UUID getId() {return todoid;}

    public void setId(UUID id) {this.todoid = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public String getDescription() {return description;}

    public void setDescription(String description) {this.description = description;}

    public Status getStatus() {return status;}

    public void setStatus(Status status) {this.status = status;}

    public EndDate getEnddate() {return enddate;}

    public void setEnddate(EndDate enddate) {this.enddate = enddate;}

    public UUID getPersonID() {return personID;}

    public void setPersonID(UUID personID) {this.personID = personID;}

}
