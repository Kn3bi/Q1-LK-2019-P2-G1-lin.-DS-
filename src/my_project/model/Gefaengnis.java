package my_project.model;

import KAGO_framework.view.DrawTool;

public class Gefaengnis extends AllgemeinesFeld {
    public Gefaengnis(int breite, int hoehe, double x, double y, String name) {
        super(breite, hoehe, x, y, name);
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
    }
}
