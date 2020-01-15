package my_project.model;

import KAGO_framework.view.DrawTool;

public class Feld extends AllgemeinesFeld {

    private Gebaude[][] meineGebaude;
    private int sichtbarkeitr;
    private int sichtbarkeitg;
    private int sichtbarkeitb;
    private int sichtbarkeitgr;
    private int haeuser;
    private boolean hotel;
    private String name;
    private int preis;
    private boolean inBesitz;
    protected Spieler besitzer;
    protected int miete;


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
        inBesitz = false;
        miete = berechneMiete();
        haeuser = 0;
    }

    @Override
    public void draw(DrawTool drawTool) {
        super.draw(drawTool);

        drawTool.setCurrentColor(0,180,0,255);
        if(haeuser == 1){
            drawTool.drawFilledRectangle(x+10, y+5, 8, 8);
        }else if(haeuser == 2){
            drawTool.drawFilledRectangle(x+10, y+5, 8, 8);
            drawTool.drawFilledRectangle(x+20, y+5, 8, 8);
        }else if(haeuser == 3){
            drawTool.drawFilledRectangle(x+10, y+5, 8, 8);
            drawTool.drawFilledRectangle(x+20, y+5, 8, 8);
            drawTool.drawFilledRectangle(x+30, y+5, 8, 8);
        }else if(haeuser == 4){
            drawTool.drawFilledRectangle(x+10, y+5, 8, 8);
            drawTool.drawFilledRectangle(x+20, y+5, 8, 8);
            drawTool.drawFilledRectangle(x+30, y+5, 8, 8);
            drawTool.drawFilledRectangle(x+40, y+5, 8, 8);
        }else if(hotel){
            drawTool.setCurrentColor(255,0,0,255);
            drawTool.drawFilledRectangle(x +10, y+5, 15,15);
        }

        //if(hotel)
    }

    @Override
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

    public Gebaude[][] getMeineGebaude() {
        return meineGebaude;
    }

    public int getSichtbarkeitr() {
        return sichtbarkeitr;
    }

    public int getSichtbarkeitg() {
        return sichtbarkeitg;
    }

    public int getSichtbarkeitb() {
        return sichtbarkeitb;
    }

    public int getSichtbarkeitgr() {
        return sichtbarkeitgr;
    }


    public boolean isInBesitz() {
        return inBesitz;
    }

    public int getMiete() {
        return miete;
    }

    public int getHauspreis(){
        if(haeuser ==0){
            return preis/4;
        }else if(haeuser == 1){
            return preis/3;
        }else if(haeuser == 2){
            return preis/2;
        }else if(haeuser == 3){
            return preis;
        }else if(haeuser == 4){
            return preis*2;
        }
        return 0;
    }

    public int getHaeuseranzahl(){
        return haeuser;
    }

    public void kaufen(Spieler s){
        besitzer = s;
        inBesitz = true;
    }

    public void setHaeuserAnzahl(){
        if(haeuser ==0){
            haeuser = 1;
        }else if(haeuser == 1){
            haeuser = 2;
        }else if(haeuser == 2){
            haeuser = 3;
        }else if(haeuser == 3){
            haeuser = 4;
        }else if(haeuser == 4){
            haeuser = 0;
            hotel = true;
        }
    }
}
