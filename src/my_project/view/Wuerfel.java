package my_project.view;

import java.awt.image.BufferedImage;

public class Wuerfel {
    private BufferedImage currentWuerfel01;
    private BufferedImage currentWuerfel02;
    private BufferedImage wuerfel01;
    private BufferedImage wuerfel02;
    private BufferedImage wuerfel03;
    private BufferedImage wuerfel04;
    private BufferedImage wuerfel05;
    private BufferedImage wuerfel06;

    public Wuerfel(){


    }

    private int wuerfelnIntern(){
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
}
