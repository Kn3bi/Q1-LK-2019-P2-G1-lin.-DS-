package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;

public class Spieler {
    private int geld;
    private String name;
    private String farbe;
    private List<Feld> spielfelder;
    private boolean wuerfelWurf;
    private String aktuelleStraße;

    public Spieler(String farbe, List<Feld> list, boolean wurf/*String aktuelleStraße*/){
        wuerfelWurf = wurf;
        spielfelder = new List<>();
        spielfelderBefuellen(list);
        spielfelder.toLast();
        spielfelder.getContent().aufDiesemFeld(farbe);
        this.farbe = farbe;
        geld = 1500;
        //this.aktuelleStraße = aktuelleStraße;

    }

    public int getGeld(){
        return geld;
    }

    public void setGeld(int geld){ this.geld = this.geld - geld; }

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

    public Feld getMeinAktuellesFeld(){
        return spielfelder.getContent();
    }

    public String getFarbe() {
        return farbe;
    }

}
