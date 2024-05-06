package de.dhbw.ase.entities;

import de.dhbw.ase.values.Address;
import de.dhbw.ase.values.PlaceName;

public class Place {
    private PlaceName name;
    private Address adress;

    public Place(PlaceName name, Address adress) {
        this.name = name;
        this.adress = adress;
    }

    public PlaceName getName() {return name;}

    public void setAdress(Address adress) {this.adress = adress;}

    public Address getAdress() {return adress;}

    public void setName(PlaceName name) {this.name = name;}

}
