package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.List;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.view.DrawTool;
import my_project.model.*;
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
    private boolean neukauf;


    public SpielerControll(ProgramController pC, ViewController vC) {
        this.pC = pC;
        this.vC = vC;
        meineWuerfel = new Wuerfel();
        vC.draw(meineWuerfel, 2);
        spielfelder = new List<>();
        befuelleListe();
        neukauf = false;
        spieler = new Queue<>();
        spieler.enqueue(new Spieler("rot", spielfelder, true));
        spieler.enqueue(new Spieler("grün", spielfelder, true));
        spieler.enqueue(new Spieler("gelb", spielfelder, true));
        spieler.enqueue(new Spieler("blau", spielfelder, true));

    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawText(700, 500, spieler.front().getFarbe() + " hat:" + spieler.front().getGeld());
        drawTool.drawText(800, 5, spieler.front().getFarbe());
        drawTool.drawText(700, 200, "Aktuelles Feld: " + spieler.front().getMeinAktuellesFeld().getName());
        if (!spieler.front().getWuerfe() && spieler.front().getAktuellesFeld() instanceof Feld) {
            if (kaufOption) {
                drawTool.drawText(700, 300, "1. du kannst diese Straße für : " + ((Feld) spieler.front().getMeinAktuellesFeld()).getPreis() + "€ kaufen");
            }
            if (fremdBesitz) {
                drawTool.drawText(700, 300, "Du musst an " + ((Feld) spieler.front().getAktuellesFeld()).getBesitzer().getFarbe() + ", " + ((Feld) spieler.front().getAktuellesFeld()).getMiete() + "€ zahlen");
            }
            if (((Feld) spieler.front().getAktuellesFeld()).getBesitzer() == spieler.front() && !neukauf) {
                drawTool.drawText(700, 300, "Diese Straße gehört dir");
                if (((Feld) spieler.front().getAktuellesFeld()).getHaeuseranzahl() < 4) {
                    drawTool.drawText(700, 400, "Du kannst für" + ((Feld) spieler.front().getAktuellesFeld()).getHauspreis() + "ein Haus kaufen");
                } else {
                    drawTool.drawText(700, 400, "Du kannst für" + ((Feld) spieler.front().getAktuellesFeld()).getHauspreis() + "ein Hotel kaufen");
                }

            }
        }else if(!spieler.front().getWuerfe() && spieler.front().getAktuellesFeld() instanceof Einkommenssteuer){
            drawTool.drawText(700, 300, "Du musst eine Steuer zahlen, in Höhe von: "
                    + ((Einkommenssteuer)spieler.front().getAktuellesFeld()).getSteuern()+ "€ zahlen");
        }else if(!spieler.front().getWuerfe() && spieler.front().getAktuellesFeld() instanceof Bahnhof){

        }

        if (spieler.front().getImGefängnis()) {
            drawTool.drawText(700, 300, "Drücke >b<, um 50$ zu bezahlen " +
                    "und aus dem Gefängnis zu entkommen");
        }

    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void keyPressed(int key) {
        if (key == KeyEvent.VK_SPACE && aktuellerSpielerHatWurf()) {
            //prüft, ob sich der Spieler in einem Gefänfgnis befindet
            if (spieler.front().getImGefängnis()) {
                //Diese Überprüfung wird aufgerufen, bevor der Spieler die Möglichkeit hat,
                // weiterzugehen, da die Wirkung des Gefägnis, stehen zu bleiben,
                // vor dem Zug eintritt.
                versucheAusDemGefängnisZuEntkommen(spieler.front(), false);
                spieler.front().setWuerfe(false);
            }
            if (!spieler.front().getImGefängnis()) {
                spieler.front().geheVorwaerts(meineWuerfel.wuerfelErgebniss());
                spieler.front().setWuerfe(false);
                //prüft, ob der Spieler in einem Gefängnisfeld gelandet ist
                if (spieler.front().getAktuellesFeld().getName().equals("Gehe ins Gefängnis")) {
                    spieler.front().setImGefängnis(true);
                    spielfelder.toFirst();
                    while(!spielfelder.getContent().getName().equals("Gefängnis")) spielfelder.next();
                    spieler.front().getAktuellesFeld().diesesFeldVerlassen(spieler.front().getFarbe());
                    spieler.front().setMeinAktuellesFeld(spielfelder.getContent());
                    spieler.front().getAktuellesFeld().aufDiesemFeld(spieler.front().getFarbe());

                } else if (spieler.front().getAktuellesFeld() instanceof Einkommenssteuer) {
                    spieler.front().setGeld(-((Einkommenssteuer) spieler.front().getAktuellesFeld()).getSteuern());
                } else if (spieler.front().getAktuellesFeld() instanceof Feld) {
                    if (((Feld) spieler.front().getAktuellesFeld()).isInBesitz() && ((Feld) spieler.front().getAktuellesFeld()).getBesitzer() != spieler.front()) {
                        fremdBesitz = true;
                        bezahleMiete();
                    } else if (((Feld) spieler.front().getAktuellesFeld()).getBesitzer() == spieler.front()) {

                    } else if (!((Feld) spieler.front().getAktuellesFeld()).isInBesitz()) {
                        kaufOption = true;
                    }
                }
            }
        }
            if (key == KeyEvent.VK_B) {
                versucheAusDemGefängnisZuEntkommen(spieler.front(), true);
            }
            if (!spieler.front().getWuerfe()) {
                if (spieler.front().getAktuellesFeld() instanceof Feld) {
                    if (kaufOption && key == KeyEvent.VK_1) {
                        ((Feld) spieler.front().getAktuellesFeld()).kaufen(spieler.front());
                        spieler.front().setGeld(-((Feld) spieler.front().getAktuellesFeld()).getPreis());
                        kaufOption = false;
                        neukauf = true;
                    }
                    if (((Feld) spieler.front().getAktuellesFeld()).getBesitzer() == spieler.front() && !neukauf) {
                        if (key == KeyEvent.VK_1) {
                            ((Feld) spieler.front().getAktuellesFeld()).setHaeuserAnzahl();
                            spieler.front().setGeld(-(((Feld) spieler.front().getAktuellesFeld()).getHauspreis()));
                        }
                    }
                }
            }
    }

        /**
         * Diese Methode geht alle Möglichkeiten für einen Spieler durch,
         * aus dem Gefängnis zu gehen.
         * Diese Überprüfung wird aufgerufen, bevor der Spieler die Möglichkeit hat, weiterzugehen,
         * da die Wirkung des Gefägnis, stehen zu bleiben, vor dem Zug eintritt.
         * @param spieler ein Spieler, der im Gefängnis sitzt
         * @param raus die Erlabnis des Spielers,
         *            aus dem Gefängnis gegen einen Geldbetrag raus zu gehen.
         */

        public void versucheAusDemGefängnisZuEntkommen (Spieler spieler,boolean raus){
            //prüft, ob der spieler exiestiert und im Gefängnis ist,
            // es müssen auch schon Würfel exiestieren
            if (spieler != null && spieler.getImGefängnis() && meineWuerfel != null) {
                fremdBesitz = false;
                kaufOption = false;
                // erhöht die Zeit im Gefängnis um eine Runde
                spieler.setZeitImGefängnis(spieler.getZeitImGefängnis() + 1);
                if (raus) {  // Falls die Erlabnis erteilt wurde(durch drücken von der Taste b )
                    // , raus zu gehen --> Gehe raus und bezahle
                    spieler.setGeld(spieler.getGeld() - 50);
                    spieler.setImGefängnis(false);
                    spieler.setZeitImGefängnis(0);
                } else if (meineWuerfel.getZahlEins() == meineWuerfel.getZahlZwei()
                        && spieler.getZeitImGefängnis() != 1) {
                    //Falls Pasch gewürfelt --> gehe raus
                    spieler.setImGefängnis(false);
                    spieler.setZeitImGefängnis(0);

                } else if (spieler.getZeitImGefängnis() == 3) {
                    // Falls schon drei Runden im Gefängnis --> gehe raus
                    spieler.setGeld(spieler.getGeld() - 50);
                    spieler.setImGefängnis(false);
                    spieler.setZeitImGefängnis(0);
                }
            }
        }

        public void bezahleMiete () {
            System.out.println(((Feld) spieler.front().getAktuellesFeld()).getBesitzer().getFarbe());
            if (spieler.front().getAktuellesFeld() instanceof Feld) {
                spieler.front().setGeld(-((Feld) spieler.front().getMeinAktuellesFeld()).getMiete());
                ((Feld) spieler.front().getMeinAktuellesFeld()).getBesitzer().setGeld(((Feld) spieler.front().getMeinAktuellesFeld()).getMiete());

            }
        }

        @Override
        public void keyReleased ( int key){

        }

        @Override
        public void mouseReleased (MouseEvent e){

        }

        @Override
        public void mouseClicked (MouseEvent e){

        }

        @Override
        public void mouseDragged (MouseEvent e){

        }

        @Override
        public void mouseMoved (MouseEvent e){

        }

        @Override
        public void mousePressed (MouseEvent e){

        }

        private void befuelleListe () {
            AllgemeinesFeld[][] tmp = pC.getSpielfelder();
            for (int i = 0; i < tmp.length; i++) {
                for (int j = 0; j < tmp[i].length; j++) {
                    spielfelder.append(tmp[i][j]);
                }
            }
        }

        public boolean aktuellerSpielerHatWurf () {
            return spieler.front().getWuerfe();
        }
        public Spieler getAktuellerSpieler () {
            return spieler.front();
        }

        public void rotiereSpieler () {
            spieler.enqueue(spieler.front());
            spieler.front().setWuerfe(true);
            spieler.dequeue();
            setzteWurfdatenZurueck();
        }

    /*public void geheInsGefängnis(){
        spieler.front().setMeinAktuellesFeld("Gefängnis")
    }*/

        private void zeigeAktuelleOptionenAn () {

        }

        public void setzteWurfdatenZurueck () {
            fremdBesitz = false;
            kaufOption = false;
            neukauf = false;
        }
    }
