package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.SpielfeldControll;

public class Feld extends AllgemeinesFeld {

    private Gebaude[][] meineGebaude;
    private int sichtbarkeitr;
    private int sichtbarkeitg;
    private int sichtbarkeitb;
    private int sichtbarkeitgr;
    private String name;
    private int preis;
    private boolean inBesitz;
    protected Spieler besitzer;


    public Feld(int breite, int hoehe, double x, double y,String name,int preis){
        super(breite,hoehe,x,y,name);
        width = breite;
        height = hoehe;
        this.x = x;
        this.y =y;
        this.name = name;
        this.preis = preis;
        meineGebaude = new Gebaude[2][4];
        sichtbarkeitb =0;
        sichtbarkeitg =0;
        sichtbarkeitgr =0;
        sichtbarkeitr =0;
        besitzer = null;
    }

    public void update(double dt) {

    }

    public String getName(){
        return name;
    }

    public Spieler getBesitzer(){
        return besitzer;
    }
}
