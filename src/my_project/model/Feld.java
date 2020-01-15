package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Feld extends GraphicalObject {

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

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x, y, width, height);
        drawTool.setCurrentColor(255,0,0,sichtbarkeitr);
        drawTool.drawFilledCircle(x+20, y+40, 20);
        drawTool.setCurrentColor(0,255,0,sichtbarkeitg);
        drawTool.drawFilledCircle(x+40, y+40, 20);
        drawTool.setCurrentColor(0,0,255,sichtbarkeitb);
        drawTool.drawFilledCircle(x+20, y+60, 20);
        drawTool.setCurrentColor(0,255,255,sichtbarkeitgr);
        drawTool.drawFilledCircle(x+40, y+60, 20);
    }

    @Override
    public void update(double dt) {

    }

    public void aufDiesemFeld(String farbe){
        if(farbe.equals("rot")){
            sichtbarkeitr = 255;
        }else if(farbe.equals("grün")){
            sichtbarkeitgr = 255;
        }else if(farbe.equals("blau")){
            sichtbarkeitb = 255;
        }else if(farbe.equals("gelb")){
            sichtbarkeitg = 255;
        }
    }

    public void diesesFeldVerlassen(String farbe){
        if(farbe.equals("rot")){
            System.out.println("> Sichtbarkeit auf dem aktuellen FEld wird auf Null gesetzt");
            sichtbarkeitr = 0;
            System.out.println(sichtbarkeitr);
        }else if(farbe.equals("grün")){
            sichtbarkeitgr = 0;
        }else if(farbe.equals("blau")){
            sichtbarkeitb = 0;
        }else if(farbe.equals("gelb")){
            sichtbarkeitg = 0;
        }
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
