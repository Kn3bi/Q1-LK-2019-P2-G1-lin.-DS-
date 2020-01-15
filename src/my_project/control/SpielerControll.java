package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.view.DrawTool;
import my_project.model.Feld;
import my_project.model.Spieler;
import my_project.view.Wuerfel;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class SpielerControll extends InteractiveGraphicalObject {

    private Queue<Spieler> spieler;
    private ProgramController pC;
    private List<Feld> spielfelder;
    private Wuerfel meineWuerfel;
    private ViewController vC;
    private String aktuelleStrasse;
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
        drawTool.drawText(700,100, spieler.front().getFarbe());
        drawTool.drawText(700, 200,spieler.front().getMeinAktuellesFeld().getName());
    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void keyPressed(int key) {
        if(key == KeyEvent.VK_SPACE && aktuellerSpielerHatWurf()){
            spieler.front().geheVorwaerts(meineWuerfel.wuerfelErgebniss());
            spieler.front().setWuerfe(false);
        }
    }

    public void bezahleMiete(){
        spieler.front().setGeld(spieler.front().getMeinAktuellesFeld().getMiete());
        spieler.front().getMeinAktuellesFeld().getBesitzer().setGeld(-spieler.front().getMeinAktuellesFeld().getMiete());
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
        Feld[][] tmp = pC.getSpielfelder();
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
        System.out.println("> Die Rotation funktioniert");
        spieler.enqueue(spieler.front());
        spieler.front().setWuerfe(true);
        spieler.dequeue();
    }

    /*public void geheInsGefängnis(){
        spieler.front().setMeinAktuellesFeld("Gefängnis")
    }*/

    private void zeigeAktuelleOptionenAn(){

    }
}
