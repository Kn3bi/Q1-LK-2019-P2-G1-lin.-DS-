package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.MouseEvent;

public class Button extends InteractiveGraphicalObject {

    private String text;
    private double hoehe;
    private double breite;
    private Startbildschirm startbildschirm;


    private int buttonNummer;

    public Button(double x, double y, String text, double hoehe, double breite, int buttonNummer, Startbildschirm sb){
        startbildschirm = sb;
        this.x = x;
        this.y = y;
        this.text = text;
        this.hoehe = hoehe;
        this.breite = breite;
        this.buttonNummer = buttonNummer;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0, 0, 255, 255);
        drawTool.drawRectangle(x, y, breite, hoehe);
        drawTool.drawText(x, y, text);
    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        double mouseX = e.getX();
        double mouseY = e.getY();
        if(mouseX > x && mouseX < x+breite && mouseY > y && mouseY < y+hoehe){
            startbildschirm.setSzene(buttonNummer);
        }
    }

    @Override
    public void keyPressed(int key) {

    }
    @Override
    public void keyReleased(int key) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
}
