package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Stack;
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
    private Stack<Karte> karten;


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
        karten = new Stack();
        erzeugeKarten();
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
        spielfelder[0][1] = new Feld(58, 90, 608-58, 610,"Neupforte",60);
        spielfelder[0][2] = new Ereignisfeld(58, 90, 608-58*2, 610,"Gemeinschaftsfeld");
        spielfelder[0][3] = new Feld(58, 90, 608-58*3, 610,"Holzgraben",60);
        spielfelder[0][4] = new Einkommenssteuer(58, 90, 608-58*4, 610,"Einkommensteuer", 200);
        spielfelder[0][5] = new Bahnhof(58, 90, 608-58*5, 610,"Südbahnhof");
        spielfelder[0][6] = new Feld(58, 90, 608-58*6, 610,"Jülicher Stra?e",100);
        spielfelder[0][7] = new Ereignisfeld(58, 90, 608-58*7, 610,"Ereignisfeld");
        spielfelder[0][8] = new Feld(58, 90, 608-58*8, 610,"Vaalser Straße", 100);
        spielfelder[0][9] = new Feld(58, 90, 608-58*9, 610,"Krefelder Straße",120);

        spielfelder[1][0] = new Gefaengnis(90, 90, 0, 610,"Gefängnis");
        spielfelder[1][1] = new Feld(90, 58, 0, 610-58,"Adalbertsteinweg",140);
        spielfelder[1][2] = new Versorgungswerke(90, 58, 0, 610-58*2,"Elektrizitätswerk");
        spielfelder[1][3] = new Feld(90, 58, 0, 610-58*3,"Kurbrunnen Straße",140);
        spielfelder[1][4] = new Feld(90, 58, 0, 610-58*4,"An der Schanz",160);
        spielfelder[1][5] = new Bahnhof(90, 58, 0, 610-58*5,"Westbahnhof");
        spielfelder[1][6] = new Feld(90, 58, 0, 610-58*6,"Pontwall", 180);
        spielfelder[1][7] = new Ereignisfeld(90, 58, 0, 610-58*7,"Gemeinschaftsfeld");
        spielfelder[1][8] = new Feld(90, 58, 0, 610-58*8,"Heinrichsallee", 180);
        spielfelder[1][9] = new Feld(90, 58, 0, 610-58*9,"Boxgraben",200);

        spielfelder[2][0] = new AllgemeinesFeld(90, 90, 0, 0,"Frei Parken");
        spielfelder[2][1] = new Feld(58, 90, 90, 0,"Seilgraben",220);
        spielfelder[2][2] = new Ereignisfeld(58, 90, 90+58, 0,"Ereignisfeld");
        spielfelder[2][3] = new Feld(58, 90, 90+58*2, 0,"Tempelgraben",220);
        spielfelder[2][4] = new Feld(58, 90, 90+58*3, 0,"Kapuzinergraben",240);
        spielfelder[2][5] = new Bahnhof(58, 90, 90+58*4, 0,"Nordbahnhof");
        spielfelder[2][6] = new Feld(58, 90, 90+58*5, 0,"Jakobsstraße",260);
        spielfelder[2][7] = new Feld(58, 90, 90+58*6, 0,"Peterstraße",260);
        spielfelder[2][8] = new Versorgungswerke(58, 90, 90+58*7, 0,"Wasserwerk");
        spielfelder[2][9] = new Feld(58, 90, 90+58*8, 0,"Theaterstraße",280);

        spielfelder[3][0] = new AllgemeinesFeld(90, 90, 610, 0,"Gehe ins Gefängnis");
        spielfelder[3][1] = new Feld(90, 58, 610, 90,"Willy-Brandt Platz",300);
        spielfelder[3][2] = new Feld(90, 58, 610, 90+58*1,"Münsterplatz", 300);
        spielfelder[3][3] = new Ereignisfeld(90, 58, 610, 90+58*2,"Gemeinschaftsfeld");
        spielfelder[3][4] = new Feld(90, 58, 610, 90+58*3,"Markt",320);
        spielfelder[3][5] = new Bahnhof(90, 58, 610, 90+58*4,"Hauptbahnhof");
        spielfelder[3][6] = new Ereignisfeld(90, 58, 610, 90+58*5,"Ereignisfeld");
        spielfelder[3][7] = new Feld(90, 58, 610, 90+58*6,"Großkölnstraße",350);
        spielfelder[3][8] = new Einkommenssteuer(90, 58, 610, 90+58*7,"Zusatzsteuer", 200);
        spielfelder[3][9] = new Feld(90, 58, 610, 90+58*8,"Krämerstraße",400);


        for(int i = 0; i < spielfelder.length; i++){
            for(int j = 0; j < spielfelder[i].length; j++){
                vC.draw(spielfelder[i][j], 2);
            }
        }



    }

    public void setzeStraßennamen(){
    }

    public void setPreis(){
    }

    private void erzeugeKarten(){
        karten.push(new FeldWechselKarte("Gehe auf Los!", null, null, null));
        karten.push(new FeldWechselKarte("Begib dich zur Schloßallee", null, null, null));
        karten.push(new FeldWechselKarte("Du besuchst das Gefängnis", null, null, null));
        karten.push(new FeldWechselKarte("Betrete das Feld frei parken", null, null, null));
        karten.push(new GeldVeraenderndeKarte("Du hast einen Schönheitswettbewerb gewonnen", "Du erhälst 50€", null, null));
        karten.push(new GeldVeraenderndeKarte("Wegen deines guten Betragens ", "erhälst du 200€", null, null));
        karten.push(new GeldVeraenderndeKarte("Di eWelt meint es gut mit dir", "Hier hast du 50€", null, null));

    }

    public Karte erhalteKarte(){
        if(karten.isEmpty()) erzeugeKarten();
        Karte rueckgabe = karten.top();
        karten.pop();
        return rueckgabe;
    }
}
