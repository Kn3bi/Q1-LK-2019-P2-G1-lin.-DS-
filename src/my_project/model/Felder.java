package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Felder extends GraphicalObject {

    private Gebaude[][] meineGebaude;

    public Felder(int breite, int hoehe, double x, double y){
        width = breite;
        height = hoehe;
        this.x = x;
        this.y =y;
        meineGebaude = new Gebaude[2][4];
    }

    @Override
    public void draw(DrawTool drawTool) {

    }

    @Override
    public void update(double dt) {

    }
}
