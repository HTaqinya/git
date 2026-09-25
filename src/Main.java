
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GewinnModel model = new GewinnModel();
            GewinnModelGUI view = new GewinnModelGUI();
            new GewinnController(model, view);
        });
    }
}

