package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class Feld extends GraphicalObject {

    private Gebaude[][] meineGebaude;
    private int sichtbarkeitr;
    private int sichtbarkeitg;
    private int sichtbarkeitb;
    private int sichtbarkeitgr;

    public Feld(int breite, int hoehe, double x, double y){
        width = breite;
        height = hoehe;
        this.x = x;
        this.y =y;
        meineGebaude = new Gebaude[2][4];
        sichtbarkeitb =0;
        sichtbarkeitg =0;
        sichtbarkeitgr =0;
        sichtbarkeitr =0;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,0,0,255);
        drawTool.drawRectangle(x, y, width, height);
        drawTool.setCurrentColor(255,0,0,sichtbarkeitr);
        drawTool.drawFilledCircle(20, 40, 10);
        drawTool.setCurrentColor(0,255,0,sichtbarkeitg);
        drawTool.drawFilledCircle(40, 40, 10);
        drawTool.setCurrentColor(0,0,255,sichtbarkeitb);
        drawTool.drawFilledCircle(20, 60, 10);
        drawTool.setCurrentColor(0,255,255,sichtbarkeitgr);
        drawTool.drawFilledCircle(40, 60, 10);
    }

    @Override
    public void update(double dt) {

    }

    public void aufDiesemFeld(String farbe){
        if(farbe.equals("rot")){
            sichtbarkeitr = 255;
        }else if(farbe.equals("grün")){
            sichtbarkeitgr = 255;
        }else if(farbe.equals("blau")){
            sichtbarkeitb = 255;
        }else if(farbe.equals("gelb")){
            sichtbarkeitg = 255;
        }
    }
    public void diesesFeldVerlassen(String farbe){
        if(farbe.equals("rot")){
            sichtbarkeitr = 0;
        }else if(farbe.equals("grün")){
            sichtbarkeitgr = 0;
        }else if(farbe.equals("blau")){
            sichtbarkeitb = 0;
        }else if(farbe.equals("gelb")){
            sichtbarkeitg = 0;
        }
    }
}
