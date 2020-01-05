package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;

public class Spieler {
    private int geld;
    private String name;
    private String farbe;
    private List<Feld> spielfelder;

    public Spieler(String farbe){
        spielfelder = new List<>();
        this.farbe = farbe;

    }

    public int getGeld(){
        return geld;
    }


}
