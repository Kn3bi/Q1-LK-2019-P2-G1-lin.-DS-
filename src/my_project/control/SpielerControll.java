package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.view.DrawTool;
import my_project.model.AllgemeinesFeld;
import my_project.model.Feld;
import my_project.model.Spieler;
import my_project.view.Wuerfel;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SpielerControll extends InteractiveGraphicalObject {

    private Queue<Spieler> spieler;
    private ProgramController pC;
    private List<AllgemeinesFeld> spielfelder;
    private Wuerfel meineWuerfel;
    private ViewController vC;
    private boolean kaufOption;
    private boolean fremdBesitz;


    public SpielerControll(ProgramController pC, ViewController vC){
        this.pC = pC;
        this.vC = vC;
        meineWuerfel = new Wuerfel();
        vC.draw(meineWuerfel, 2);
        spielfelder = new List<>();
        befuelleListe();
        spieler = new Queue<>();
        spieler.enqueue(new Spieler("rot", spielfelder, true));
        spieler.enqueue(new Spieler("grün", spielfelder, true));
        spieler.enqueue(new Spieler("gelb", spielfelder, true));
        spieler.enqueue(new Spieler("blau", spielfelder, true));

    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawText(700, 500, spieler.front().getFarbe() + " hat:"+ spieler.front().getGeld());
        drawTool.drawText(700,100, spieler.front().getFarbe());
        drawTool.drawText(700, 200,spieler.front().getMeinAktuellesFeld().getName());
        if(!spieler.front().getWuerfe() && spieler.front().getAktuellesFeld() instanceof Feld) {
            if (kaufOption) {
                drawTool.drawText(700, 300, "1. du kannst diese Straße für : " + ((Feld) spieler.front().getMeinAktuellesFeld()).getPreis() + "€ kaufen");
            }
            if (fremdBesitz) {
                drawTool.drawText(700, 300, "Du musst an " + ((Feld) spieler.front().getAktuellesFeld()).getBesitzer().getFarbe() + ", " + ((Feld) spieler.front().getAktuellesFeld()).getMiete() + "€ zahlen");
            }
            if(((Feld) spieler.front().getAktuellesFeld()).getBesitzer() == spieler.front()){
                drawTool.drawText(700, 300, "Diese Straße gehört dir");
                if(((Feld) spieler.front().getAktuellesFeld()).getHaeuseranzahl() < 4){
                    drawTool.drawText(700, 400, "Du kannst für"+ ((Feld)spieler.front().getAktuellesFeld()).getHauspreis()+"ein Haus kaufen");
                }else{
                    drawTool.drawText(700, 400, "Du kannst für"+ ((Feld)spieler.front().getAktuellesFeld()).getHauspreis()+"ein Hotel kaufen");
                }

            }
        }
    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void keyPressed(int key) {
        if(key == KeyEvent.VK_SPACE && aktuellerSpielerHatWurf()){
            spieler.front().geheVorwaerts(meineWuerfel.wuerfelErgebniss());
            spieler.front().setWuerfe(false);
            if(spieler.front().getAktuellesFeld() instanceof Feld) {
                if (((Feld)spieler.front().getAktuellesFeld()).isInBesitz() && ((Feld)spieler.front().getAktuellesFeld()).getBesitzer() != spieler.front()) {
                    fremdBesitz = true;
                } else if (((Feld)spieler.front().getAktuellesFeld()).getBesitzer() == spieler.front()) {

                } else if (!((Feld)spieler.front().getAktuellesFeld()).isInBesitz()) {
                    kaufOption = true;
                }
            }
        }
        if(!spieler.front().getWuerfe()) {
            if (spieler.front().getAktuellesFeld() instanceof Feld) {
                if (kaufOption && key == KeyEvent.VK_1) {
                    ((Feld) spieler.front().getAktuellesFeld()).kaufen(spieler.front());
                    spieler.front().setGeld(-((Feld) spieler.front().getAktuellesFeld()).getPreis());
                    kaufOption = false;
                }
                if (((Feld) spieler.front().getAktuellesFeld()).getBesitzer() == spieler.front()) {
                    if (key == KeyEvent.VK_2) {
                        ((Feld) spieler.front().getAktuellesFeld()).setHaeuserAnzahl();
                        spieler.front().setGeld(-(((Feld) spieler.front().getAktuellesFeld()).getHauspreis()));
                    }
                }
            }
        }
    }

    public void bezahleMiete(){
        System.out.println(((Feld)spieler.front().getAktuellesFeld()).getBesitzer().getFarbe());
        if (spieler.front().getAktuellesFeld() instanceof Feld) {
            spieler.front().setGeld(-((Feld)spieler.front().getMeinAktuellesFeld()).getMiete());
            ((Feld)spieler.front().getMeinAktuellesFeld()).getBesitzer().setGeld(((Feld)spieler.front().getMeinAktuellesFeld()).getMiete());

        }
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

    private void befuelleListe(){
        AllgemeinesFeld[][] tmp = pC.getSpielfelder();
        for(int i = 0; i < tmp.length; i++){
            for(int j = 0; j < tmp[i].length; j++){
                spielfelder.append(tmp[i][j]);
            }
        }
    }

    public boolean aktuellerSpielerHatWurf(){
        return spieler.front().getWuerfe();
    }
    public Spieler getAktuellerSpieler() {return spieler.front();}

    public void rotiereSpieler(){
        spieler.enqueue(spieler.front());
        spieler.front().setWuerfe(true);
        spieler.dequeue();
        if(fremdBesitz){
            bezahleMiete();
        }
    }

    /*public void geheInsGefängnis(){
        spieler.front().setMeinAktuellesFeld("Gefängnis")
    }*/

    private void zeigeAktuelleOptionenAn(){

    }

    public void setzteWurfdatenZurueck(){
        fremdBesitz = false;
        kaufOption = false;
    }
}
