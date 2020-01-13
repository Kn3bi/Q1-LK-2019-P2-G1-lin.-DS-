package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Feld extends GraphicalObject {

    private Gebaude[][] meineGebaude;
    private int sichtbarkeitr;
    private int sichtbarkeitg;
    private int sichtbarkeitb;
    private int sichtbarkeitgr;
    private String[][] namen;
    private String name;
    private int preis;
    private boolean inBesitz;
    private Spieler besitzer;


    public Feld(int breite, int hoehe, double x, double y,String name,int preis){
        width = breite;
        height = hoehe;
        this.x = x;
        this.y =y;
        this.name = name;
        this.preis = preis;
        namen = new String[4][10];
        meineGebaude = new Gebaude[2][4];
        sichtbarkeitb =0;
        sichtbarkeitg =0;
        sichtbarkeitgr =0;
        sichtbarkeitr =0;
        setzeStraßennamen();
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

    public void setzeStraßennamen(){
        namen[0][0] = "LOS";
        namen[0][1] = "Badstraße";
        namen[0][2] = "Gemeinschaftsfeld";
        namen[0][3] = "Turmstraße";
        namen[0][4] = "Einkommensteuer";
        namen[0][5] = "Südbahnhof";
        namen[0][6] = "Chausseestraße";
        namen[0][7] = "Ereignisfeld";
        namen[0][8] = "Elisenstraße";
        namen[0][9] = "Postsraße";

        namen[1][0] = "Gefängnis";
        namen[1][1] = "Seestraße";
        namen[1][2] = "Elektrizitätswerk";
        namen[1][3] = "Hafenstraße";
        namen[1][4] = "Neue Straße";
        namen[1][5] = "Westbahnhof";
        namen[1][6] = "Münchner Straße";
        namen[1][7] = "Gemeinschaftsfeld";
        namen[1][8] = "Wiener Straße";
        namen[1][9] = "Berliner Straße";

        namen[2][0] = "Frei Parken";
        namen[2][1] = "Theaterstraße";
        namen[2][2] = "Ereignisfeld";
        namen[2][3] = "Museumsstraße";
        namen[2][4] = "Opernplatz";
        namen[2][5] = "Nordbahnhof";
        namen[2][6] = "Lessingstraße";
        namen[2][7] = "Schillerstraße";
        namen[2][8] = "Wasserwerk";
        namen[2][9] = "Goethestraße";

        namen[3][0] = "Gehe ins Gefängnis";
        namen[3][1] = "Rathausplatz";
        namen[3][2] = "Hauptstraße";
        namen[3][3] = "Gemeinschaftsfeld";
        namen[3][4] = "Bahnhofstraße";
        namen[3][5] = "Hauptbahnhof";
        namen[3][6] = "Ereignisfeld";
        namen[3][7] = "Parkstraße";
        namen[3][8] = "Zusatzsteuer";
        namen[3][9] = "Schloßallee";
    }

    public String[][] getAktuellenNamen(){
        return namen;
    }

    public String getNamen(){
        return name;
    }

    public int getPreis(){
        return preis;
    }

    public Spieler getBesitzer(){
        return besitzer;
    }
}
