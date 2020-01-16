package my_project.model;

import KAGO_framework.view.DrawTool;

public class Gefaengnis extends AllgemeinesFeld {

    protected int sichtbarkeitrIG;
    protected int sichtbarkeitgIG;
    protected int sichtbarkeitbIG;
    protected int sichtbarkeitgrIG;

    public Gefaengnis(int breite, int hoehe, double x, double y, String name) {
        super(breite, hoehe, x, y, name);
        sichtbarkeitbIG = 0;
        sichtbarkeitgIG =0;
        sichtbarkeitgrIG =0;
        sichtbarkeitrIG =0;
    }

    public void draw(DrawTool drawTool){
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.drawRectangle(x, y, width, height);
        drawTool.setCurrentColor(255, 0, 0, sichtbarkeitr);
        drawTool.drawFilledCircle(x + 0, y + 20, 20);
        drawTool.setCurrentColor(0, 255, 0, sichtbarkeitg);
        drawTool.drawFilledCircle(x + 0, y + 50, 20);
        drawTool.setCurrentColor(0, 0, 255, sichtbarkeitb);
        drawTool.drawFilledCircle(x + 10, y + 70, 20);
        drawTool.setCurrentColor(0, 255, 255, sichtbarkeitgr);
        drawTool.drawFilledCircle(x + 40, y + 70, 20);

        drawTool.setCurrentColor(255, 0, 0, sichtbarkeitrIG);
        drawTool.drawFilledCircle(x + 30, y + 20, 20);
        drawTool.setCurrentColor(0, 255, 0, sichtbarkeitgIG);
        drawTool.drawFilledCircle(x + 30, y + 50, 20);
        drawTool.setCurrentColor(0, 0, 255, sichtbarkeitbIG);
        drawTool.drawFilledCircle(x + 50, y + 20, 20);
        drawTool.setCurrentColor(0, 255, 255, sichtbarkeitgrIG);
        drawTool.drawFilledCircle(x + 50, y + 50, 20);
    }

    public void aufDiesemFeldImGefaengnis(String farbe){
        if(farbe.equals("rot")){
            sichtbarkeitrIG = 255;
        }else if(farbe.equals("grün")){
            sichtbarkeitgrIG = 255;
        }else if(farbe.equals("blau")){
            sichtbarkeitbIG = 255;
        }else if(farbe.equals("gelb")){
            sichtbarkeitgIG = 255;
        }
    }
}
