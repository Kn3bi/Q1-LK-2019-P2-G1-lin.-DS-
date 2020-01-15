package my_project.model;

import KAGO_framework.model.abitur.datenstrukturen.List;

public class Spieler {
    private int geld;
    private String name;
    private String farbe;
    private List<AllgemeinesFeld> spielfelder;
    private boolean wuerfelWurf;
    private String aktuelleStraße;

    private Boolean imGefängnis;
    private int zeitImGefängnis;

    public Spieler(String farbe, List < AllgemeinesFeld > list, boolean wurf/*String aktuelleStraße*/){
            wuerfelWurf = wurf;
            spielfelder = new List<>();
            spielfelderBefuellen(list);
            spielfelder.toFirst();
            spielfelder.getContent().aufDiesemFeld(farbe);
            this.farbe = farbe;
            geld = 1500;
            //this.aktuelleStraße = aktuelleStraße;
            imGefängnis = false;
            zeitImGefängnis = 0;

        }

        public int getGeld () {
            return geld;
        }

        public void setGeld ( int geld){
            this.geld = this.geld + geld;
        }

        public boolean getWuerfe () {
            return wuerfelWurf;
        }

        public void setWuerfe ( boolean a){
            wuerfelWurf = a;
        }

        public void geheVorwaerts ( int i){
            spielfelder.getContent().diesesFeldVerlassen(farbe);
            for (int j = 0; j < i; j++) {
                spielfelder.next();
                if (!spielfelder.hasAccess()) {
                    spielfelder.toFirst();
                }
            }
            spielfelder.getContent().aufDiesemFeld(farbe);
        }

        private void spielfelderBefuellen (List < AllgemeinesFeld > list) {
            list.toFirst();
            while (list.hasAccess()) {
                spielfelder.append(list.getContent());
                list.next();
            }
        }

        public AllgemeinesFeld getMeinAktuellesFeld () {
            return spielfelder.getContent();
        }

        public void setMeinAktuellesFeld (Feld feld){
            while (spielfelder.getContent() != feld) {
                spielfelder.next();
            }
        }

        public String getFarbe () {
            return farbe;
        }

        public String getName () {
            return name;
        }

        public List<AllgemeinesFeld> getSpielfelder () {
            return spielfelder;
        }

        public AllgemeinesFeld getAktuellesFeld () {
            return spielfelder.getContent();
        }

        public boolean isWuerfelWurf () {
            return wuerfelWurf;
        }

        public String getAktuelleStraße () {
            return aktuelleStraße;
        }
    public Boolean getImGefängnis() {
        return imGefängnis;
    }

    public void setImGefängnis(Boolean imGefängnis) {
        this.imGefängnis = imGefängnis;
    }

    public int getZeitImGefängnis() {
        return zeitImGefängnis;
    }

    public void setZeitImGefängnis(int zeitImGefängnis) {
        this.zeitImGefängnis = zeitImGefängnis;
    }
}
