package de.dhbw.ase.entities;

import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Status;

import java.time.LocalDate;
import java.util.UUID;

public final class Todo {
    private UUID uuid;
    private String title;
    private String description;
    private Status status;
    private EndDate enddate;
    private UUID personID;
    private Place place;


    public Todo(){

    }

    public Todo(String title,String description, EndDate enddate){
        this.uuid = UUID.randomUUID();
        this.title= title;
        this.description = description;
        this.enddate = enddate;
        if(enddate.endDatum().isBefore(LocalDate.now())){
            this.status = Status.OPEN;
        }
        else {
            this.status = Status.OVERDUE;
        }
    }

    public UUID getTodoID(){return uuid;}

    public String getTitle(){ return title;}

    public void setTitle(String title){ this.title = title;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}

    public EndDate getEnddate(){return enddate;}

    public void setEnddate(EndDate enddate){this.enddate = enddate;}

    public UUID getPersonID(){return personID;}

    public void setPersonID(UUID personID){this.personID = personID;}

    public Place getPlace(){return place;}

    public void setPlace(Place place){this.place = place;}

    public Status getStatus() {return status;}

    public void setStatus(Status status) {this.status = status;}
}