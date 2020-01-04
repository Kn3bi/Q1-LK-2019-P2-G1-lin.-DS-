package my_project.control;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.abitur.datenstrukturen.Queue;
import KAGO_framework.view.DrawTool;
import my_project.model.Spieler;

public class SpielerControll extends GraphicalObject {

    private Queue<Spieler> spieler;

    public SpielerControll(){
        spieler = new Queue<>();
        for(int i = 0; i < 4; i++){
            spieler.enqueue(new Spieler());
        }
    }

    @Override
    public void draw(DrawTool drawTool) {

    }

    @Override
    public void update(double dt) {

    }
}
