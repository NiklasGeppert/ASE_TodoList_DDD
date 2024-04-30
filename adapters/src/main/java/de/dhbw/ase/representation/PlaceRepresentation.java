package de.dhbw.ase.representation;

import de.dhbw.ase.values.Address;
import de.dhbw.ase.values.PlaceName;

public class PlaceRepresentation {
    private PlaceName placeName;
    private Address adress;

    public PlaceRepresentation(PlaceName placeName, Address adress) {
        this.placeName = placeName;
        this.adress = adress;
    }

    public PlaceRepresentation(){}

    public Address getAdress() {return adress;}

    public PlaceName getPlaceName(){return placeName;}

}
