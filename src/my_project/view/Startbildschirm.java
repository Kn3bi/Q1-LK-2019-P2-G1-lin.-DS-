package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.event.MouseEvent;

public class Startbildschirm extends InteractiveGraphicalObject {

    private Button anleitung;
    private Button spiel;
    private ViewController viewController;
    private  ProgramController pC;

    public Startbildschirm(ViewController viewController, ProgramController pC){
        this.pC = pC;
        this.viewController = viewController;
        anleitung = new Button(100, 400, "Anleitung", 50, 150, 0, this);
        spiel = new Button(500, 400, "Zum Spiel", 50, 150, 2, this);
        viewController.draw(anleitung, 1);
        viewController.draw(spiel, 1);
    }

    @Override
    public void draw(DrawTool drawTool) {

        drawTool.setCurrentColor(255,0,0,100);
        drawTool.drawFilledRectangle(0, 0, 1000, 800);

    }

    @Override
    public void update(double dt) {

    }

    public void setSzene(int i){
        pC.setSzene(i);
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
    public void mouseClicked(MouseEvent e) {

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
