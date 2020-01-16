package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.view.DrawTool;
import my_project.control.SpielerControll;
import my_project.control.SpielfeldControll;

public class RotationsButton extends ButtonOberklasse {

    private SpielerControll spielerControll;

    public RotationsButton(double x, double y, String text, int hoehe, double breite, ViewController sb, SpielerControll sC) {
        super(x, y, text, hoehe, breite, sb);
        spielerControll = sC;
    }

    @Override
    public void draw(DrawTool drawTool) {
        if(!spielerControll.aktuellerSpielerHatWurf()){
            super.draw(drawTool);
        }
    }

    protected void reagiere(){
        if(spielerControll.aktuellerSpielerHatWurf() == false) {
            spielerControll.rotiereSpieler();
        }
    }

    public void setSpielerControll(SpielerControll sC){
        spielerControll = sC;
    }
}
