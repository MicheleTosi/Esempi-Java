import controller.NetworkController;
import model.NetworkModel;
import view.NetworkView;

public class App {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            NetworkModel model = new NetworkModel();
            NetworkView view = new NetworkView();
            new NetworkController(model, view);
            view.setVisible(true);
        });
    }
}