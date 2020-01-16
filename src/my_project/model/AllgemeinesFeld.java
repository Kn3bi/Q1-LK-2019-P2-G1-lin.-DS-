package my_project.model;

import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

public class AllgemeinesFeld extends GraphicalObject {

    private Gebaude[][] meineGebaude;
    private int sichtbarkeitr;
    private int sichtbarkeitg;
    private int sichtbarkeitb;
    private int sichtbarkeitgr;
    private String name;




    public AllgemeinesFeld(int breite, int hoehe, double x, double y,String name){
        width = breite;
        height = hoehe;
        this.x = x;
        this.y =y;
        this.name = name;

        meineGebaude = new Gebaude[2][4];
        sichtbarkeitb =0;
        sichtbarkeitg =0;
        sichtbarkeitgr =0;
        sichtbarkeitr =0;

    }

    @Override
    public void draw(DrawTool drawTool) {
        if(width == 58) {
            drawTool.setCurrentColor(0, 0, 0, 255);
            drawTool.drawRectangle(x, y, width, height);
            drawTool.setCurrentColor(255, 0, 0, sichtbarkeitr);
            drawTool.drawFilledCircle(x + 20, y + 40, 20);
            drawTool.setCurrentColor(0, 255, 0, sichtbarkeitg);
            drawTool.drawFilledCircle(x + 40, y + 40, 20);
            drawTool.setCurrentColor(0, 0, 255, sichtbarkeitb);
            drawTool.drawFilledCircle(x + 20, y + 60, 20);
            drawTool.setCurrentColor(0, 255, 255, sichtbarkeitgr);
            drawTool.drawFilledCircle(x + 40, y + 60, 20);
        }else{
            drawTool.setCurrentColor(0, 0, 0, 255);
            drawTool.drawRectangle(x, y, width, height);
            drawTool.setCurrentColor(255, 0, 0, sichtbarkeitr);
            drawTool.drawFilledCircle(x + 40, y + 20, 20);
            drawTool.setCurrentColor(0, 255, 0, sichtbarkeitg);
            drawTool.drawFilledCircle(x + 40, y + 20, 20);
            drawTool.setCurrentColor(0, 0, 255, sichtbarkeitb);
            drawTool.drawFilledCircle(x + 60, y + 40, 20);
            drawTool.setCurrentColor(0, 255, 255, sichtbarkeitgr);
            drawTool.drawFilledCircle(x + 60, y + 40, 20);
        }

    }

    @Override
    public void update(double dt) {

    }

    public void aufDiesemFeld(String farbe){
        if(farbe.equals("rot")){
            sichtbarkeitr = 255;
            System.out.println("Bin angekommen");
        }else if(farbe.equals("grün")){
            sichtbarkeitgr = 255;
        }else if(farbe.equals("blau")){
            sichtbarkeitb = 255;
        }else if(farbe.equals("gelb")){
            sichtbarkeitg = 255;
        }
    }

    public void diesesFeldVerlassen(String farbe){
        if(farbe.equals("rot")){
            System.out.println("> Sichtbarkeit auf dem aktuellen FEld wird auf Null gesetzt");
            sichtbarkeitr = 0;
            System.out.println(sichtbarkeitr);
        }else if(farbe.equals("grün")){
            sichtbarkeitgr = 0;
        }else if(farbe.equals("blau")){
            sichtbarkeitb = 0;
        }else if(farbe.equals("gelb")){
            sichtbarkeitg = 0;
        }
    }

    public String getName(){
        return name;
    }


}



