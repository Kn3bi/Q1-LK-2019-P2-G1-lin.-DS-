package my_project.model;

public class Einkommenssteuer extends AllgemeinesFeld {
    private int steuern;
    public Einkommenssteuer(int breite, int hoehe, double x, double y, String name, int steuern ) {
        super(breite, hoehe, x, y, name);
        this.steuern = steuern;
    }

    public int getSteuern(){
        return steuern;
    }
}
