package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class Spielbrett extends GraphicalObject {

    private BufferedImage spielplan;

    public Spielbrett(){
        //setNewImage("assets/images/Monopoly/monopoly.jpg");
        spielplan = getMyImage();
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(spielplan, 0, 0);
    }

    @Override
    public void update(double dt) {

    }
}
