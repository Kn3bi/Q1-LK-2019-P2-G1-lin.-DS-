package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.*;
import my_project.view.RotationsButton;

import java.awt.event.MouseEvent;

public class SpielfeldControll extends InteractiveGraphicalObject {
    private AllgemeinesFeld[][] spielfelder;
    private SpielerControll sC;
    private ViewController vC;
    private RotationsButton naechsterButton;
    private String[][] namen;
    private int[][] preise;


    public SpielfeldControll(SpielerControll spC, ViewController vC){
        this.vC = vC;
        sC = spC;
        spielfelder = new AllgemeinesFeld[4][10];
        naechsterButton = new RotationsButton(750, 600, "Nächster", 40, 100, vC, sC);
        namen = new String[4][10];
        preise = new int[4][10];
        setzeStraßennamen();
        setPreis();
        erzeugeFelder();
        vC.register(naechsterButton, 2);
        vC.draw(naechsterButton, 2);
    }



    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawText(700, 30, "Aktueller Spieler:" );
        drawTool.setCurrentColor(0,0,0,100);
    }

    @Override
    public void update(double dt) {
        if(sC.aktuellerSpielerHatWurf() == false){
            registriereNaechsterButton();
        }
    }

    @Override
    public void keyPressed(int key) {

    }

    @Override
    public void keyReleased(int key) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    public AllgemeinesFeld[][] getSpielfelder(){
        return spielfelder;
    }

    public void registriereNaechsterButton(){

    }

    public void setSpielerControll(SpielerControll sC){
        this.sC = sC;
        naechsterButton.setSpielerControll(sC);
    }

    public void rotiereSpieler(){
        sC.rotiereSpieler();
    }


    private void erzeugeFelder(){

        spielfelder[0][0] = new AllgemeinesFeld(90, 90, 608, 610,"Los!");
        spielfelder[0][1] = new Feld(58, 90, 608-58, 610,"Badstraße",100);
        spielfelder[0][2] = new Ereignisfeld(58, 90, 608-58*2, 610,"Gemeinschaftsfeld");
        spielfelder[0][3] = new Feld(58, 90, 608-58*3, 610,"Turmstraße",100);
        spielfelder[0][4] = new Einkommenssteuer(58, 90, 608-58*4, 610,"Einkommensteuer");
        spielfelder[0][5] = new Bahnhof(58, 90, 608-58*5, 610,"Südbahnhof");
        spielfelder[0][6] = new Feld(58, 90, 608-58*6, 610,"Chausseestraße",100);
        spielfelder[0][7] = new Ereignisfeld(58, 90, 608-58*7, 610,"Ereignisfeld");
        spielfelder[0][8] = new Feld(58, 90, 608-58*8, 610,"Elisenstraße", 100);
        spielfelder[0][9] = new Feld(58, 90, 608-58*9, 610,"Postsraße",100);

        spielfelder[1][0] = new Gefaengnis(90, 90, 0, 610,"Gefängnis");
        spielfelder[1][1] = new Feld(90, 58, 0, 610-58,"Seestraße",100);
        spielfelder[1][2] = new Versorgungswerke(90, 58, 0, 610-58*2,"Elektrizitätswerk");
        spielfelder[1][3] = new Feld(90, 58, 0, 610-58*3,"Hafenstraße",0);
        spielfelder[1][4] = new Feld(90, 58, 0, 610-58*4,"Neue Straße",0);
        spielfelder[1][5] = new Bahnhof(90, 58, 0, 610-58*5,"Westbahnhof");
        spielfelder[1][6] = new Feld(90, 58, 0, 610-58*6,"Münchner Straße", 0);
        spielfelder[1][7] = new Ereignisfeld(90, 58, 0, 610-58*7,"Gemeinschaftsfeld");
        spielfelder[1][8] = new Feld(90, 58, 0, 610-58*8,"Wiener Straße", 0);
        spielfelder[1][9] = new Feld(90, 58, 0, 610-58*9,"Berliner Straße",0);

        spielfelder[2][0] = new AllgemeinesFeld(90, 90, 0, 0,"Frei Parken");
        spielfelder[2][1] = new Feld(58, 90, 90, 0,"Theaterstraße",0);
        spielfelder[2][2] = new Ereignisfeld(58, 90, 90+58, 0,"Ereignisfeld");
        spielfelder[2][3] = new Feld(58, 90, 90+58*2, 0,"Museumsstraße",0);
        spielfelder[2][4] = new Feld(58, 90, 90+58*3, 0,"Opernplatz",0);
        spielfelder[2][5] = new Bahnhof(58, 90, 90+58*4, 0,"Aachen Schanz Bahnhof");
        spielfelder[2][6] = new Feld(58, 90, 90+58*5, 0,"Lessingstraße",0);
        spielfelder[2][7] = new Feld(58, 90, 90+58*6, 0,"Schillerstraße",0);
        spielfelder[2][8] = new Versorgungswerke(58, 90, 90+58*7, 0,"Wasserwerk");
        spielfelder[2][9] = new Feld(58, 90, 90+58*8, 0,"Goethestraße",0);

        spielfelder[3][0] = new AllgemeinesFeld(90, 90, 610, 0,"Gehe ins Gefängnis");
        spielfelder[3][1] = new Feld(90, 58, 610, 90,"Rathausplatz",0);
        spielfelder[3][2] = new Feld(90, 58, 610, 90+58*1,"Hauptstraße", 0);
        spielfelder[3][3] = new Ereignisfeld(90, 58, 610, 90+58*2,"Gemeinschaftsfeld");
        spielfelder[3][4] = new Feld(90, 58, 610, 90+58*3,"Bahnhofstraße",0);
        spielfelder[3][5] = new Bahnhof(90, 58, 610, 90+58*4,"Hauptbahnhof");
        spielfelder[3][6] = new Ereignisfeld(90, 58, 610, 90+58*5,"Ereignisfeld");
        spielfelder[3][7] = new Feld(90, 58, 610, 90+58*6,"Parkstraße",0);
        spielfelder[3][8] = new Einkommenssteuer(90, 58, 610, 90+58*7,"Zusatzsteuer");
        spielfelder[3][9] = new Feld(90, 58, 610, 90+58*8,"Schloßallee",0);

        for(int i = 0; i < spielfelder.length; i++){
            for(int j = 0; j < spielfelder[i].length; j++){
                vC.draw(spielfelder[i][j], 2);
            }
        }



    }

    public void setzeStraßennamen(){





    }

    public void setPreis(){
        preise[0][0] = 60;
        preise[0][1] = 0;
        preise[0][2] = 60;
        preise[0][3] = 0;
        preise[0][4] = 200;
        preise[0][5] = 100;
        preise[0][6] = 0;
        preise[0][7] = 100;
        preise[0][8] = 100;
        preise[1][9] = 0;

        preise[1][0] = 140;
        preise[1][1] = 150;
        preise[1][2] = 140;
        preise[1][3] = 160;
        preise[1][4] = 200;
        preise[1][5] = 180;
        preise[1][6] = 0;
        preise[1][7] = 180;
        preise[1][8] = 200;
        preise[2][9] = 0;

        preise[2][0] = 220;
        preise[2][1] = 0;
        preise[2][2] = 220;
        preise[2][3] = 240;
        preise[2][4] = 200;
        preise[2][5] = 260;
        preise[2][6] = 260;
        preise[2][7] = 150;
        preise[2][8] = 280;
        preise[3][9] = 0;

        preise[3][0] = 300;
        preise[3][1] = 300;
        preise[3][2] = 0;
        preise[3][3] = 320;
        preise[3][4] = 200;
        preise[3][5] = 0;
        preise[3][6] = 350;
        preise[3][7] = 100;
        preise[3][8] = 400;
        preise[0][9] = 0;
    }


    public int getPreis(int i,int j){
        return preise[i][j];
    }
    public String getNamen(int i,int j){
        return namen[i][j];
    }
   /*
    public Feld getAktuellesFeld(){
       // return
    }
    */

}
