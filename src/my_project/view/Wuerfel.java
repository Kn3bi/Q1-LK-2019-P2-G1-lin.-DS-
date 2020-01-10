package my_project.view;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.image.BufferedImage;

public class Wuerfel extends GraphicalObject {
    private BufferedImage currentWuerfel01;
    private BufferedImage currentWuerfel02;
    private BufferedImage[] wuerfel;

    public Wuerfel(){


    }

    public int wuerfeln(){
        return wuerfelnIntern();
    }

    public int wuerfelnIntern(){
        int augzahl = 1+ (int)(Math.random()*6);
        if(augzahl == 1){

        }else if(augzahl == 2){

        }else if(augzahl ==3){

        }else if(augzahl == 4){

        }else if(augzahl == 5){

        }else{

        }
        return augzahl;
    }

    @Override
    public void draw(DrawTool drawTool) {

    }

    @Override
    public void update(double dt) {

    }
}
