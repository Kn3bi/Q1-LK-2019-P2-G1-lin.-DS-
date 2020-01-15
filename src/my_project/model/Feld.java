package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

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
    protected int miete;
    private int haeuser;


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
        miete = berechneMiete();
        haeuser = 0;
    }

    public void update(double dt) {

    }

    public String getName(){
        return name;
    }

    public Spieler getBesitzer(){
        return besitzer;
    }

    public boolean istInBesitz(){
        return inBesitz;
    }

    public int getPreis(){
        return preis;
    }

    public int berechneMiete(){
        int m =0;
        if(haeuser==0){
            m = preis/4;
        }else if(haeuser==1){
            m = (preis/4)*2;
        }else if(haeuser==2){
            m = (preis/4)*3;
        }else if(haeuser==3){
            m = preis;
        }else if(haeuser == 4){
            m = (preis/4)*5;
        }else if(haeuser==5){
            m = preis*2;
        }
        return m;
    }
    public int getMiete(){
        return miete;
    }
}
