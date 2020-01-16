package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class Wuerfel extends GraphicalObject {
    private BufferedImage currentWuerfel01;
    private BufferedImage currentWuerfel02;
    private BufferedImage[] wuerfel;

    private int zahlEins;
    private int zahlZwei;

    public Wuerfel(){
        wuerfel = new BufferedImage[6];
        setNewImage("assets/images/wuerfel/wuerfelEins.png");
        wuerfel[0] = getMyImage();
        setNewImage("assets/images/wuerfel/wuerfelZwei.png");
        wuerfel[1] = getMyImage();
        setNewImage("assets/images/wuerfel/wuerfelDrei.png");
        wuerfel[2] = getMyImage();
        setNewImage("assets/images/wuerfel/wuerfelVier.png");
        wuerfel[3] = getMyImage();
        setNewImage("assets/images/wuerfel/wuerfelFünf.png");
        wuerfel[4] = getMyImage();
        setNewImage("assets/images/wuerfel/wuerfelSechs.png");
        wuerfel[5] = getMyImage();


    }


    public int wuerfelErgebniss(){
        zahlEins=wuerfelnIntern();
        zahlZwei=wuerfelnIntern();
        int ergebnis = zahlEins + zahlZwei;
        return ergebnis;
    }



    private int wuerfelnIntern(){
        int augzahl = 1+ (int)(Math.random()*6);
        return augzahl;
    }

    @Override
    public void draw(DrawTool drawTool) {
        if(zahlEins > 0 && zahlZwei > 0) {
            drawTool.drawImage(wuerfel[zahlEins - 1], 350, 300);
            drawTool.drawImage(wuerfel[zahlZwei - 1], 200, 300);
        }
    }

    @Override
    public void update(double dt) {

    }

    public int getZahlEins() {
        return zahlEins;
    }

    public int getZahlZwei() {
        return zahlZwei;
    }
}
