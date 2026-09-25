import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnModelGUI extends JFrame {
    private GewinnModel gewinnModel;
    private JButton buttonSpieler;
    private JButton buttonComputer;
    private JTextField textFieldGesamtPunkte;
    private JTextField textFieldSpielerZahl;
    private JTextField textFieldComputerZahl;

    public GewinnModelGUI() {
        this.gewinnModel = new GewinnModel();
        this.setLayout(new BorderLayout());


        this.buttonSpieler = new JButton("Spieler");
        this.buttonComputer = new JButton("Computer");
        this.textFieldGesamtPunkte = new JTextField();
        this.textFieldSpielerZahl = new JTextField();
        this.textFieldComputerZahl = new JTextField();


        this.buttonSpieler.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handhabung des Ereignisses
            }
        });


        this.add(this.buttonSpieler, BorderLayout.NORTH);
        this.add(this.textFieldGesamtPunkte, BorderLayout.CENTER);
        this.add(this.textFieldSpielerZahl, BorderLayout.EAST);
        this.add(this.buttonComputer, BorderLayout.SOUTH);
        this.add(this.textFieldComputerZahl, BorderLayout.WEST);

        this.setSize(800, 500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new GewinnModelGUI();
    }
}
