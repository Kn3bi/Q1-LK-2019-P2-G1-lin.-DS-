package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.Feld;
import my_project.view.RotationsButton;
import my_project.view.SzenenButton;
import my_project.view.Wuerfel;

import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class SpielfeldControll extends InteractiveGraphicalObject {
    private Feld[][] spielfelder;
    private SpielerControll sC;
    private ViewController vC;
    private RotationsButton naechsterButton;
    private String[][] namen;
    private int[][] preise;
    private Feld feld;


    public SpielfeldControll(SpielerControll spC, ViewController vC){
        this.vC = vC;
        sC = spC;
        spielfelder = new Feld[4][10];
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

    public Feld[][] getSpielfelder(){
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

    public void bezahleMiete(){
       if(feld.getBesitzer() !=  sC.getAktuellerSpieler()){
          // sC.getAktuellerSpieler().setGeld(getPreis(getAktuellesFeld()));
       }
    }

    private void erzeugeFelder(){
        for(int i = 0; i < spielfelder[0].length; i++){
            if(i != 9){
                spielfelder[0][i] = new Feld(58, 90, 550-i*58, 610,getNamen(0,i),getPreis(0,i));
                vC.draw(spielfelder[0][i], 2);
            }else{
                spielfelder[0][i] = new Feld(90, 90, 550-(i-1)*58-90, 610, getNamen(0,i),getPreis(0,i));
                vC.draw(spielfelder[0][i], 2);
            }

        }
        for(int i = 0; i < spielfelder[1].length; i++){
            if(i != 9){
                spielfelder[1][i] = new Feld(90, 58, 0, 550-58*i,getNamen(1,i),getPreis(1,i));
                vC.draw(spielfelder[1][i], 2);
            }else{
                spielfelder[1][i] = new Feld(90, 90, 0, 550-58*(i-1)-90,getNamen(1,i),getPreis(1,i));
                vC.draw(spielfelder[1][i], 2);
            }

        }
        for(int i = 0; i < spielfelder[2].length; i++){
            if(i != 9){
                spielfelder[2][i] = new Feld(58, 90, 90+58*i, 0,getNamen(2,i),getPreis(2,i));
                vC.draw(spielfelder[2][i], 2);
            }else{
                spielfelder[2][i] = new Feld(90, 90, 90+58*i, 0,getNamen(2,i),getPreis(2,i));
                vC.draw(spielfelder[2][i], 2);
            }

        }
        for(int i = 0; i < spielfelder[3].length; i++){
            if(i != 9){
                spielfelder[3][i] = new Feld(90, 58, 610, 90+58*i,getNamen(3,i),getPreis(3,i));
                vC.draw(spielfelder[3][i], 2);
            }else{
                spielfelder[3][i] = new Feld(90, 90, 610, 90+58*i,getNamen(3,i),getPreis(3,i));
                vC.draw(spielfelder[3][i], 2);
            }

        }
    }

    public void setzeStraßennamen(){
        namen[0][0] = "Badstraße";
        namen[0][1] = "Gemeinschaftsfeld";
        namen[0][2] = "Turmstraße";
        namen[0][3] = "Einkommensteuer";
        namen[0][4] = "Südbahnhof";
        namen[0][5] = "Chausseestraße";
        namen[0][6] = "Ereignisfeld";
        namen[0][7] = "Elisenstraße";
        namen[0][8] = "Postsraße";
        namen[0][9] = "Gefängnis";

        namen[1][0] = "Seestraße";
        namen[1][1] = "Elektrizitätswerk";
        namen[1][2] = "Hafenstraße";
        namen[1][3] = "Neue Straße";
        namen[1][4] = "Westbahnhof";
        namen[1][5] = "Münchner Straße";
        namen[1][6] = "Gemeinschaftsfeld";
        namen[1][7] = "Wiener Straße";
        namen[1][8] = "Berliner Straße";
        namen[1][9] = "Frei Parken";

        namen[2][0] = "Theaterstraße";
        namen[2][1] = "Ereignisfeld";
        namen[2][2] = "Museumsstraße";
        namen[2][3] = "Opernplatz";
        namen[2][4] = "Nordbahnhof";
        namen[2][5] = "Lessingstraße";
        namen[2][6] = "Schillerstraße";
        namen[2][7] = "Wasserwerk";
        namen[2][8] = "Goethestraße";
        namen[2][9] = "Gehe ins Gefängnis";

        namen[3][0] = "Rathausplatz";
        namen[3][1] = "Hauptstraße";
        namen[3][2] = "Gemeinschaftsfeld";
        namen[3][3] = "Bahnhofstraße";
        namen[3][4] = "Hauptbahnhof";
        namen[3][5] = "Ereignisfeld";
        namen[3][6] = "Parkstraße";
        namen[3][7] = "Zusatzsteuer";
        namen[3][8] = "Schloßallee";
        namen[3][9] = "LOS";
    }

    public void setPreis(){
        preise[0][0] = 60;
        preise[0][1] = 0;
        preise[0][2] = 60;
        preise[0][3] = 200;
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
