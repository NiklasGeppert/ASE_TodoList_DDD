package de.dhbw.ase.entities;

import de.dhbw.ase.values.EndDate;
import de.dhbw.ase.values.Status;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public final class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID todoId;
    private String title;
    private String description;
    private Status status;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "endDatum", column = @Column(name = "end_date"))
    })
    private EndDate endDate;
    private UUID personID;


    public Todo(){
        this.todoId = UUID.randomUUID();
    }

    public Todo(String title, String description, EndDate endDate, UUID personID){
        this.todoId = UUID.randomUUID();
        this.title= title;
        this.description = description;
        this.endDate = endDate;
        if(endDate.endDate().isAfter(LocalDate.now())){
            setStatus(Status.OVERDUE);
        }
        else {
            setStatus(Status.OPEN);
        }
        this.personID = personID;
    }

    public UUID getTodoID(){return todoId;}

    public String getTitle(){ return title;}

    public void setTitle(String title){ this.title = title;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}

    public EndDate getendDate(){return endDate;}

    public void setendDate(EndDate endDate){this.endDate = endDate;}

    public UUID getPersonID(){return personID;}

    public void setPersonID(UUID personID){this.personID = personID;}


    public Status getStatus() {return status;}

    public void setStatus(Status status) {this.status = status;}

}