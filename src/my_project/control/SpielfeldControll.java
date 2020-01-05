package my_project.control;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.model.InteractiveGraphicalObject;
import KAGO_framework.view.DrawTool;
import my_project.model.Feld;
import my_project.view.Wuerfel;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class SpielfeldControll extends InteractiveGraphicalObject {
    private Feld[][] spielfelder;
    private BufferedImage spielbrett;
    private SpielerControll sC;
    private ViewController vC;


    public SpielfeldControll(SpielerControll spC, ViewController vC){
        this.vC = vC;
        sC = spC;
        spielfelder = new Feld[4][10];
        erzeugeFelder();


        setNewImage("assets/images/Monopoly/monopoly.jpg");
        spielbrett = getMyImage();
    }

    private void erzeugeFelder(){
        for(int i = 0; i < spielfelder[0].length; i++){
            if(i != 9){
                spielfelder[0][i] = new Feld(58, 90, 550-i*58, 610);
                vC.draw(spielfelder[0][i], 2);
            }else{
                spielfelder[0][i] = new Feld(90, 90, 550-(i-1)*58-90, 610);
                vC.draw(spielfelder[0][i], 2);
            }

        }
        for(int i = 0; i < spielfelder[1].length; i++){
            if(i != 9){
                spielfelder[1][i] = new Feld(90, 58, 0, 550-58*i);
                vC.draw(spielfelder[1][i], 2);
            }else{
                spielfelder[1][i] = new Feld(90, 90, 0, 550-58*(i-1)-90);
                vC.draw(spielfelder[1][i], 2);
            }

        }
        for(int i = 0; i < spielfelder[2].length; i++){
            if(i != 9){
                spielfelder[2][i] = new Feld(58, 90, 90+58*i, 0);
                vC.draw(spielfelder[2][i], 2);
            }else{
                spielfelder[2][i] = new Feld(90, 90, 90+58*i, 0);
                vC.draw(spielfelder[2][i], 2);
            }

        }
        for(int i = 0; i < spielfelder[3].length; i++){
            if(i != 9){
                spielfelder[3][i] = new Feld(90, 58, 610, 90+58*i);
                vC.draw(spielfelder[3][i], 2);
            }else{
                spielfelder[3][i] = new Feld(90, 90, 610, 90+58*i);
                vC.draw(spielfelder[3][i], 2);
            }

        }
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.drawText(700, 30, "Aktueller Spieler:" );
        drawTool.setCurrentColor(0,0,0,100);
        //drawTool.drawImage(spielbrett, 0, 0);
    }

    @Override
    public void update(double dt) {

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

    public Feld[][] getSpielfelder(){
        return spielfelder;
    }
}
