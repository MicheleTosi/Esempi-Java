package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;

public class Pagina {

    JFrame frm;
    JButton btnAggiungi;
    JButton btnReset;
    JButton btnCalcola;
    JLabel lblNome, lblPrezzo, lblTotale;
    JTextField txtNome;
    JTextField txtPrezzo;
    JTextField txtTotale;
    JTable tbl;
    DefaultTableModel modello;

    // Lista prodotti
    ArrayList<Prodotto> listaProdotti = new ArrayList<>();

    public void pagina() {
        frm = new JFrame("Carrello della Spesa");
        frm.setSize(600, 500);
        frm.setLayout(null);

        // Etichette e campi testo
        lblNome = new JLabel("Nome Prodotto:");
        lblNome.setBounds(30, 30, 100, 30);
        txtNome = new JTextField();
        txtNome.setBounds(140, 30, 150, 30);

        lblPrezzo = new JLabel("Prezzo:");
        lblPrezzo.setBounds(320, 30, 60, 30);
        txtPrezzo = new JTextField();
        txtPrezzo.setBounds(380, 30, 100, 30);

        // Pulsanti
        btnAggiungi = new JButton("AGGIUNGI");
        btnAggiungi.setBounds(30, 80, 120, 30);

        btnReset = new JButton("RESET");
        btnReset.setBounds(170, 80, 100, 30);

        btnCalcola = new JButton("CALCOLA TOTALE");
        btnCalcola.setBounds(290, 80, 160, 30);

        // Tabella
        modello = new DefaultTableModel(new String[]{"Prodotto", "Prezzo"}, 0);
        tbl = new JTable(modello);
        JScrollPane scrollPane = new JScrollPane(tbl);
        scrollPane.setBounds(30, 130, 500, 200);

        // Totale
        lblTotale = new JLabel("Totale:");
        lblTotale.setBounds(350, 350, 60, 30);
        txtTotale = new JTextField();
        txtTotale.setBounds(410, 350, 120, 30);
        txtTotale.setEditable(false);

        // Azione AGGIUNGI
        btnAggiungi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = txtNome.getText().trim();
                String prezzoStr = txtPrezzo.getText().trim();
                if (!nome.isEmpty() && !prezzoStr.isEmpty()) {
                    try {
                        double prezzo = Double.parseDouble(prezzoStr);
                        Prodotto prodotto = new Prodotto(nome, prezzo);
                        listaProdotti.add(prodotto);
                        modello.addRow(new Object[]{nome, prezzo});
                        txtNome.setText("");
                        txtPrezzo.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(frm, "Inserisci un prezzo valido.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frm, "Inserisci entrambi i campi.");
                }
            }
        });

        // Azione RESET
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtNome.setText("");
                txtPrezzo.setText("");
            }
        });

        // Azione CALCOLA TOTALE
        btnCalcola.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double totale = 0;
                for (Prodotto p : listaProdotti) {
                    totale += p.getPrezzo();
                }
                txtTotale.setText(String.format("€ %.2f", totale));
            }
        });

        // Aggiunta componenti
        frm.add(lblNome);
        frm.add(txtNome);
        frm.add(lblPrezzo);
        frm.add(txtPrezzo);
        frm.add(btnAggiungi);
        frm.add(btnReset);
        frm.add(btnCalcola);
        frm.add(scrollPane);
        frm.add(lblTotale);
        frm.add(txtTotale);

        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frm.setVisible(true);
    }
}
