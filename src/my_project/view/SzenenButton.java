package my_project.view;

import KAGO_framework.control.ViewController;

public class SzenenButton extends ButtonOberklasse {

    private int buttonNummer;

    public SzenenButton(double x, double y, String text, int hoehe, double breite, int buttonNummer, ViewController sb){
        super(x, y, text, hoehe, breite, sb);
        this.buttonNummer = buttonNummer;
    }

    @Override
    protected void reagiere() {
        System.out.println(buttonNummer);
        viewController.showScene(buttonNummer);
    }
}
