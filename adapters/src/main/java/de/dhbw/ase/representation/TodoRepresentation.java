package de.dhbw.ase.representation;

import de.dhbw.ase.entities.Place;
import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Status;

import java.util.UUID;

public class TodoRepresentation {
    private UUID id;
    private String title;
    private String description;
    private Status status;
    private EndDate enddate;
    private UUID personID;
    private Place place;

    public TodoRepresentation(UUID id, String title, String description, Status status, EndDate enddate, UUID personID, Place place) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.enddate = enddate;
        this.personID = personID;
        this.place = place;
    }
    public TodoRepresentation(String title, String description, Status status, EndDate enddate, UUID personID, Place place) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.status = status;
        this.enddate = enddate;
        this.personID = personID;
        this.place = place;
    }
    public TodoRepresentation(){}

    public UUID getId() {return id;}

    public String getTitle() {return title;}

    public String getDescription() {return description;}

    public Status getStatus() {return status;}

    public EndDate getEnddate() {return enddate;}

    public UUID getPersonID() {return personID;}

    public Place getPlace() {return place;}
}
