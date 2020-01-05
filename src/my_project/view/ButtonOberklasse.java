package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.event.MouseEvent;

public abstract class ButtonOberklasse extends InteractiveGraphicalObject {

    private String text;
    private int hoehe;
    private double breite;
    protected ViewController viewController;

    public ButtonOberklasse(double x, double y, String text, int hoehe, double breite, ViewController sb){
        viewController = sb;
        this.x = x;
        this.y = y;
        this.text = text;
        this.hoehe = hoehe;
        this.breite = breite;
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0, 0, 0, 255);
        drawTool.formatText("a", 4, 30);
        drawTool.drawRectangle(x, y, breite, hoehe);
        drawTool.drawText(x, y+hoehe-8, text);
    }

    @Override
    public void update(double dt) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        double mouseX = e.getX();
        double mouseY = e.getY();
        if(mouseX > x && mouseX < x+breite && mouseY > y && mouseY < y+hoehe){
            reagiere();
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

    protected abstract void reagiere();
}
