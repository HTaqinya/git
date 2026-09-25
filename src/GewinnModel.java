

public class GewinnModel {
    private int gesamtPunkte;
    private int spielerZahl;
    private int computerZahl;
    private int rundenErgebnis;

    public GewinnModel() {
        this.gesamtPunkte = 30;
    }

    public int getGesamtPunkte() {
        return gesamtPunkte;
    }

    public int getComputerZahl() {
        return computerZahl;
    }

    public int getRundenErgebnis() {
        return rundenErgebnis;
    }

    public void berechneComputerZahl() {
        computerZahl = (int) (Math.random() * 9) + 1;
    }

    public void berechneRunde(int spielerZahl) {
        this.spielerZahl = spielerZahl;
        int differenz = Math.abs(spielerZahl - computerZahl);

        if (differenz == 0) {
            rundenErgebnis = 20;
        } else if (differenz == 1) {
            rundenErgebnis = 5;
        } else {
            rundenErgebnis = -10;
        }

        gesamtPunkte += rundenErgebnis;
    }

    public boolean hatGewonnen() {
        return gesamtPunkte >= 100;
    }

    public boolean hatVerloren() {
        return gesamtPunkte <= 0;
    }
}
