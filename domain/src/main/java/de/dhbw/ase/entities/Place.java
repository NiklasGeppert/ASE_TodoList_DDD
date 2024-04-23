package de.dhbw.ase.entities;

import de.dhbw.ase.values.Adress;
import de.dhbw.ase.values.PlaceName;

public class Place {
    private PlaceName name;
    private Adress adress;

    public Place(PlaceName name, Adress adress) {
        this.name = name;
        this.adress = adress;
    }

    public PlaceName getName() {return name;}

    public void setAdress(Adress adress) {this.adress = adress;}

    public Adress getAdress() {return adress;}

    public void setName(PlaceName name) {this.name = name;}

}
