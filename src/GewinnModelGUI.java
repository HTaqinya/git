import javax.swing.*;
import java.awt.*;

public class GewinnModelGUI extends JFrame {

    private JLabel rundenErgebnisLabel;
    private JLabel gesamtPunkteLabel;
    private JTextField spielerZahlFeld;
    private JTextField computerZahlFeld;
    private JButton nochEinmalButton;

    private static final Font HEADER_FONT = new Font("SansSerif", Font.PLAIN, 14);
    private static final Font ERGEBNIS_FONT = new Font("SansSerif", Font.BOLD, 16);
    private static final Font ZAHLEN_FONT = new Font("SansSerif", Font.BOLD, 28);

    public GewinnModelGUI() {
        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 450);
        setLocationRelativeTo(null);
        setResizable(false);
        initComponents();
    }

    private void initComponents() {
        JPanel hauptPanel = new JPanel();
        hauptPanel.setLayout(new BoxLayout(hauptPanel, BoxLayout.Y_AXIS));

        JPanel headerPanel = new JPanel(new GridLayout(1, 2));
        headerPanel.add(erstelleLabel("Rundenergebnis:", HEADER_FONT, false));
        headerPanel.add(erstelleLabel("Gesamtpunkte:", HEADER_FONT, false));


        JPanel ergebnisPanel = new JPanel(new GridLayout(1, 2));
        rundenErgebnisLabel = erstelleLabel("Tippe eine Zahl von 1 bis 9", ERGEBNIS_FONT, true);
        gesamtPunkteLabel = erstelleLabel("Gesamtpunkte: 30", ERGEBNIS_FONT, true);
        ergebnisPanel.add(rundenErgebnisLabel);
        ergebnisPanel.add(gesamtPunkteLabel);


        JPanel eingabeHeaderPanel = new JPanel(new GridLayout(1, 2));
        eingabeHeaderPanel.add(erstelleLabel("Deine Zahl:", HEADER_FONT, false));
        eingabeHeaderPanel.add(erstelleLabel("Computer:", HEADER_FONT, false));


        JPanel feldPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        feldPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        spielerZahlFeld = new JTextField();
        spielerZahlFeld.setFont(ZAHLEN_FONT);
        spielerZahlFeld.setHorizontalAlignment(SwingConstants.CENTER);

        computerZahlFeld = new JTextField();
        computerZahlFeld.setFont(ZAHLEN_FONT);
        computerZahlFeld.setHorizontalAlignment(SwingConstants.CENTER);
        computerZahlFeld.setEditable(false);
        computerZahlFeld.setBackground(Color.WHITE);

        feldPanel.add(spielerZahlFeld);
        feldPanel.add(computerZahlFeld);

        spielerZahlFeld.setPreferredSize(new Dimension(200, 120));
        computerZahlFeld.setPreferredSize(new Dimension(200, 120));

        hauptPanel.add(headerPanel);
        hauptPanel.add(ergebnisPanel);
        hauptPanel.add(eingabeHeaderPanel);
        hauptPanel.add(feldPanel);


        nochEinmalButton = new JButton("Noch einmal!");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(nochEinmalButton);

        setLayout(new BorderLayout());
        add(hauptPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private JLabel erstelleLabel(String text, Font font, boolean weisserHintergrund) {
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(font);
        if (weisserHintergrund) {
            label.setOpaque(true);
            label.setBackground(Color.WHITE);
            label.setBorder(BorderFactory.createEmptyBorder(8, 5, 8, 5));
        }
        return label;
    }

    public JLabel getRundenErgebnisLabel() {
        return rundenErgebnisLabel;
    }

    public JLabel getGesamtPunkteLabel() {
        return gesamtPunkteLabel;
    }

    public JTextField getSpielerZahlFeld() {
        return spielerZahlFeld;
    }

    public JTextField getComputerZahlFeld() {
        return computerZahlFeld;
    }

    public JButton getNochEinmalButton() {
        return nochEinmalButton;
    }
}