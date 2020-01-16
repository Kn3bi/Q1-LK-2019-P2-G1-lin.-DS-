package my_project.model;

public class Bahnhof extends AllgemeinesFeld {

    private Spieler besitzer;
    private int preis;
    private boolean inBesitz;

    public Bahnhof(int breite, int hoehe, double x, double y, String name) {
        super(breite, hoehe, x, y, name);
        preis = 200;
        inBesitz = false;
        besitzer = null;
    }

    public Spieler getBesitzer() {
        return besitzer;
    }

    public int getPreis() {
        return preis;
    }

    public boolean isInBesitz() {
        return inBesitz;
    }

    public void kaufen(Spieler s){
        inBesitz = true;
        besitzer = s;
    }
}
