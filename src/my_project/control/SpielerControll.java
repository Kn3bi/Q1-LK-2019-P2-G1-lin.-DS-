package my_project.control;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.view.DrawTool;
import my_project.model.Spieler;

public class SpielerControll extends GraphicalObject {

    private Queue<Spieler> spieler;
    private ProgramController pC;

    public SpielerControll(ProgramController pC){
        this.pC = pC;
        spieler = new Queue<>();
        spieler.enqueue(new Spieler("rot"));
        spieler.enqueue(new Spieler("grün"));
        spieler.enqueue(new Spieler("gelb"));
        spieler.enqueue(new Spieler("blau"));

    }

    @Override
    public void draw(DrawTool drawTool) {

    }

    @Override
    public void update(double dt) {

    }
}
