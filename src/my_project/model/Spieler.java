package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;
import my_project.view.Felder;

public class Spieler {
    private int geld;
    private String name;
    private String farbe;
    private List<Feld> spielfelder;
    private boolean wuerfelWurf;

    public Spieler(String farbe, List<Feld> list, boolean wurf){
        wuerfelWurf = wurf;
        spielfelder = new List<>();
        spielfelderBefuellen(list);
        spielfelder.toLast();
        spielfelder.getContent().aufDiesemFeld(farbe);
        this.farbe = farbe;

    }

    public int getGeld(){
        return geld;
    }

    public boolean getWuerfe(){
        return wuerfelWurf;
    }

    public void setWuerfe(boolean a){
        wuerfelWurf = a;
    }

    public void geheVorwaerts(int i){
        spielfelder.getContent().diesesFeldVerlassen(farbe);
        System.out.println(farbe);
        for(int j = 0; j < i; j++){
            spielfelder.next();
            if(!spielfelder.hasAccess()){
                spielfelder.toFirst();
            }
        }
        System.out.println(spielfelder.getContent());
        spielfelder.getContent().aufDiesemFeld(farbe);
    }

    private void spielfelderBefuellen(List<Feld> list){
        list.toFirst();
        while(list.hasAccess()){
            spielfelder.append(list.getContent());
            list.next();
        }
    }
}