package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;

public class Spieler {
    private int geld;
    private String name;
    private String farbe;
    private List<Feld> spielfelder;
    private boolean wuerfelWurf;

    public Spieler(String farbe, List<Feld> list, boolean wurf){
        wuerfelWurf = wurf;
        spielfelder = list;
        spielfelder.toFirst();
        spielfelder.getContent().aufDiesemFeld(farbe);
        this.farbe = farbe;

    }

    public int getGeld(){
        return geld;
    }

    public boolean getWuerfe(){
        return wuerfelWurf;
    }

    public void geheVorwaerts(int i){
        spielfelder.getContent().diesesFeldVerlassen(farbe);
        for(int j = 0; j < i; j++){
            spielfelder.next();
        }
        spielfelder.getContent().aufDiesemFeld(farbe);
    }

}
