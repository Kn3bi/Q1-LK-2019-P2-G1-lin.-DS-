package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public abstract class Karte extends GraphicalObject {

    private String zeile01;
    private String zeile02;
    private String zeile03;
    private String zeile04;

    public Karte(String zeile01, String zeile02, String zeile03, String zeile04) {
        this.zeile01 = zeile01;
        this.zeile02 = zeile02;
        this.zeile03 = zeile03;
        this.zeile04 = zeile04;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(100,0,0,255);
        drawTool.drawFilledRectangle(500, 500, 110, 80);
        drawTool.formatText("a", 5, 15);
        drawTool.drawText(510,510,zeile01);
        drawTool.drawText(510,535,zeile02);
        drawTool.drawText(510,550,zeile03);
        drawTool.drawText(510,565,zeile04);
    }

    @Override
    public void update(double dt) {

    }

    protected abstract void auswirken();
}
