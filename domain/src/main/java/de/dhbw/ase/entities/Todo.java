package de.dhbw.ase.entities;

import de.dhbw.ase.values.EndDatum;
import de.dhbw.ase.values.Status;

import java.time.LocalDate;
import java.util.UUID;

public final class Todo {
    private UUID uuid;
    private String title;
    private String description;
    private Status status;
    private EndDatum enddate;
    private UUID personID;
    private Ort place;


    public Todo(){

    }

    public Todo(String title, EndDatum enddate){
        this.uuid = UUID.randomUUID();
        this.title= title;
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

    public EndDatum getEnddate(){return enddate;}

    public void setEnddate(EndDatum enddate){this.enddate = enddate;}

    public UUID getPersonID(){return personID;}

    public void setPersonID(UUID personID){this.personID = personID;}

    public Ort getPlace(){return place;}

    public void setPlace(Ort place){this.place = place;}

}