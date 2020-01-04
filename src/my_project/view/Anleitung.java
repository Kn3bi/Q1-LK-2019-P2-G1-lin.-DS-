package my_project.view;

import KAGO_framework.control.Interactable;
import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class Anleitung extends GraphicalObject {

    private String[] anleitung;
    private Button zurueck;
    private ViewController vC;

    public Anleitung(ViewController vC){
        this.vC = vC;
        zurueck = new Button(750, 10, "Zurück", 40, 100, 1, vC);
        vC.register(zurueck, 0);
        vC.draw(zurueck, 0);
        anleitung = new String[10];
        anleitung[0] = "Dieses Monopoly wird gespielt wie jedes andere Monopoly.";
        anleitung[1] = "Es wird reihum gewürfelt und in jedem Zug hat ein Spieler mehrere Optionen:";
        anleitung[2] = "Das Feld auf das man kommt hat jeweils verschiedene Optionen";
        anleitung[3] = "Kommt man auf eine Straße, wenn sie noch niemandem gehört, kaufen.";
        anleitung[4] =  "Sollte man Besitzer sein kann man ein Haus bauen, ";
        anleitung[5] = "sofern ein anderer Besitzer ist muss man Miete zahlen";
        anleitung[6] = "Sobald man auf allen Straßen einer Farbe vier Häuser besitzt hat";
        anleitung[7] = "man die Möglichkeit diese plus einen Kaufpreis gegen ein Hotel einzutauschen.";
        anleitung[8]= "Die Miete berechnet sich aus der Grundmiete und der Anzahl der Häuser/ Hotels";
        anleitung[9] = "Ein Spieler hat verloren, sobald er kein Geld mehr besitzt";
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(0,255,0,255);
        drawTool.formatText("a", 4, 25);
        for(int i = 0; i < anleitung.length; i++){
            drawTool.drawText(10, 30+i*70, anleitung[i]);
        }
    }

    @Override
    public void update(double dt) {

    }
}
