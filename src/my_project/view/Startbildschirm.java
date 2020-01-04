package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.control.ProgramController;

import java.awt.event.MouseEvent;

public class Startbildschirm extends GraphicalObject {

    private Button anleitung;
    private Button spiel;
    private ViewController viewController;
    private  ProgramController pC;

    public Startbildschirm(ViewController viewController, ProgramController pC){
        this.pC = pC;
        this.viewController = viewController;
        anleitung = new Button(100, 400, "Anleitung", 50, 150, 0, this);
        spiel = new Button(500, 400, "Zum Spiel", 50, 150, 2, this);
        viewController.draw(anleitung);
        viewController.draw(spiel);
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
}
