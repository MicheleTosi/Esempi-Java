package view;

import javax.swing.*;

public class NetworkView extends JFrame {

    public final JTextArea interfaceListArea = new JTextArea();
    public final JTextArea interfaceDetailArea = new JTextArea();
    public final JButton refreshButton = new JButton("Aggiorna");

    public NetworkView() {
        setTitle("Interfacce di Rete");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);
        setLayout(null); // layout assoluto

        // Scroll per la lista interfacce
        JScrollPane interfaceListScroll = new JScrollPane(interfaceListArea);
        interfaceListScroll.setBounds(20, 20, 250, 350);
        add(interfaceListScroll);

        // Scroll per i dettagli
        JScrollPane detailScroll = new JScrollPane(interfaceDetailArea);
        detailScroll.setBounds(290, 20, 480, 350);
        add(detailScroll);

        // Pulsante "Aggiorna"
        refreshButton.setBounds(20, 390, 250, 30);
        add(refreshButton);

        // Impostazioni area testo
        interfaceListArea.setEditable(false);
        interfaceDetailArea.setEditable(false);
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Errore", JOptionPane.ERROR_MESSAGE);
    }
}
