package my_project.control;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.Felder;

public class SpielfeldControll extends GraphicalObject {
    private Felder[][] spielfelder;

    public SpielfeldControll(){
        spielfelder = new Felder[4][9];
        erzeugeFelder();

    }

    private void erzeugeFelder(){
        for(int i = 0; i < spielfelder.length; i++){

        }
    }

    @Override
    public void draw(DrawTool drawTool) {

    }

    @Override
    public void update(double dt) {

    }
}
