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

    public String getTitle() {return title;}

    public String getDescription() {return description;}

    public Status getStatus() {return status;}

    public EndDate getEnddate() {return enddate;}

    public UUID getPersonID() {return personID;}

}
