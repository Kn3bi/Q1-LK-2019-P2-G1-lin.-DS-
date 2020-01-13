package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.Feld;
import my_project.view.Anleitung;
import my_project.view.Spielbrett;
import my_project.view.Startbildschirm;

import java.awt.event.MouseEvent;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute
    private int szene;
    // Referenzen

    private SpielfeldControll spielfeldControll;
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private Startbildschirm startbildschirm;
    private Anleitung anleitung;
    private SpielerControll spielerControll;
    private Spielbrett spielbrett;

    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param ViewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController ViewController){
        this.viewController = ViewController;
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen. Achtung: funktioniert nicht im Szenario-Modus
     */
    public void startProgram() {
        viewController.createScene();
        viewController.createScene();
        viewController.createScene();
        spielbrett = new Spielbrett();
        viewController.draw(spielbrett, 2);
        startbildschirm = new Startbildschirm(viewController, this);
        viewController.draw(startbildschirm, 1);
        anleitung = new Anleitung(viewController);
        viewController.draw(anleitung, 0);
        spielfeldControll = new SpielfeldControll(spielerControll, viewController);
        spielerControll = new SpielerControll(this, viewController);
        viewController.register(spielerControll, 2);
        viewController.draw(spielerControll, 2);
        spielfeldControll.setSpielerControll(spielerControll);
        viewController.draw(spielfeldControll, 2);
        viewController.showScene(1);
    }

    /**
     * Für FORTGESCHRITTENE
     * Diese Methode wird wiederholt automatisch aufgerufen und zwar für jede Frame einmal, d.h. über 25 mal pro Sekunde.
     * @param dt Die Zeit in Sekunden, die seit dem letzten Aufruf der Methode vergangen ist.
     */
    public void updateProgram(double dt){


    }

    /**
     * Für FORTGESCHRITTENE
     * Diese Methode wird einmalig aufgerufen für jedes Mal, wenn die Maus im Fenster geklickt wird.
     * @param e Das übergebene Objekt enthält alle Informationen zum MouseEvent
     */
    public void mouseClicked(MouseEvent e){


    }

    public void setSzene(int i){
        viewController.showScene(i);
    }

    public Feld[][] getSpielfelder(){
        return spielfeldControll.getSpielfelder();
    }

}
