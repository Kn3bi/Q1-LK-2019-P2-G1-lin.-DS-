package my_project.control;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.Felder;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SpielfeldControll extends GraphicalObject {
    private Felder[][] spielfelder;
    private BufferedImage spielbrett;

    public SpielfeldControll(){
        spielfelder = new Felder[4][9];
        erzeugeFelder();

        setNewImage("assets/images/monopolySpielbrett.jpg");
        spielbrett = getMyImage();
    }

    private void erzeugeFelder(){
        for(int i = 0; i < spielfelder.length; i++){

        }
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawImage(spielbrett, 0, 0);
    }

    @Override
    public void update(double dt) {

    }
}
