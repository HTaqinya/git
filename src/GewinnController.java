
import javax.swing.*;

public class GewinnController {

    private GewinnModel model;
    private GewinnModelGUI view;

    public GewinnController(GewinnModel model, GewinnModelGUI view) {
        this.model = model;
        this.view = view;

        view.getSpielerZahlFeld().addActionListener(e -> spieleRunde());

        view.getNochEinmalButton().addActionListener(e -> nochEinmal());

        view.setVisible(true);
    }

    private void spieleRunde() {
        if (model.hatGewonnen() || model.hatVerloren()) {
            return;
        }

        String eingabe = view.getSpielerZahlFeld().getText().trim();
        int spielerZahl;

        try {
            spielerZahl = Integer.parseInt(eingabe);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(view, "Bitte eine Zahl von 1 bis 9 eingeben!",
                    "Ungültige Eingabe", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (spielerZahl < 1 || spielerZahl > 9) {
            JOptionPane.showMessageDialog(view, "Bitte eine Zahl von 1 bis 9 eingeben!",
                    "Ungültige Eingabe", JOptionPane.WARNING_MESSAGE);
            return;
        }

        model.berechneComputerZahl();
        model.berechneRunde(spielerZahl);

        view.getComputerZahlFeld().setText(String.valueOf(model.getComputerZahl()));
        view.getGesamtPunkteLabel().setText(String.valueOf(model.getGesamtPunkte()));

        if (model.hatVerloren()) {
            view.getRundenErgebnisLabel().setText("Verloren");
            view.getSpielerZahlFeld().setEnabled(false);
        } else if (model.hatGewonnen()) {
            view.getRundenErgebnisLabel().setText("Gewonnen");
            view.getSpielerZahlFeld().setEnabled(false);
        } else {
            int ergebnis = model.getRundenErgebnis();
            String vorzeichen = ergebnis >= 0 ? "+" : "";
            view.getRundenErgebnisLabel().setText(vorzeichen + ergebnis);
        }
    }

    private void nochEinmal() {
        view.getSpielerZahlFeld().setText("");
        view.getComputerZahlFeld().setText("");
        view.getRundenErgebnisLabel().setText("Tippe eine Zahl von 1 bis 9");
        view.getGesamtPunkteLabel().setText("Gesamtpunkte: " + model.getGesamtPunkte());
        view.getSpielerZahlFeld().requestFocusInWindow();
    }
}

