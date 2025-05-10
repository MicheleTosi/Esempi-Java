package controller;

import model.NetworkModel;
import view.NetworkView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.*;
import java.util.List;

public class NetworkController {

    private final NetworkModel model;
    private final NetworkView view;
    private List<NetworkInterface> interfaces;

    public NetworkController(NetworkModel model, NetworkView view) {
        this.model = model;
        this.view = view;

        loadInterfaces();

        view.interfaceListArea.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int caret = view.interfaceListArea.getCaretPosition();
                try {
                    int line = view.interfaceListArea.getLineOfOffset(caret);
                    if (line >= 0 && line < interfaces.size()) {
                        NetworkInterface netIf = interfaces.get(line);
                        view.interfaceDetailArea.setText(model.getInterfaceDetails(netIf));
                    }
                } catch (Exception ex) {
                    view.showError("Errore nel selezionare l'interfaccia: " + ex.getMessage());
                }
            }
        });

        view.refreshButton.addActionListener(e -> loadInterfaces());
    }

    private void loadInterfaces() {
        try {
            interfaces = model.getNetworkInterfaces();
            StringBuilder sb = new StringBuilder();
            for (NetworkInterface netIf : interfaces) {
                sb.append(netIf.getName()).append("\n");
            }
            view.interfaceListArea.setText(sb.toString());
            view.interfaceDetailArea.setText("");
        } catch (SocketException e) {
            view.showError("Errore nel caricamento delle interfacce: " + e.getMessage());
        }
    }
}
