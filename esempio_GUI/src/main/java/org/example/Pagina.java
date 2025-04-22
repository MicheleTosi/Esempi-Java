package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pagina {

    JFrame frm;
    JButton bt;
    JButton btnClear;
    JLabel lbl;
    JTextField txt;
    JScrollPane scr;
    JTextArea txtArea;

    public void pagina(){
        frm = new JFrame();

        frm.setSize(500,500);


        frm.setLayout(null);//non fa cambiare di posizione agli oggetti

        bt = new JButton("premi");
        btnClear = new JButton("Pulisci");
        lbl = new JLabel("Testo iniziale");
        txt= new JTextField();
        txtArea=new JTextArea();
        scr=new JScrollPane(txtArea);

        bt.setBounds(100, 100, 100, 30);
        btnClear.setBounds(200,100,100,30);
        lbl.setBounds(100, 150, 200, 30);
        txt.setBounds(100,200,200,30);
        scr.setBounds(100,250,300,200);




        bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Quando il bottone viene cliccato, esegue questa azione
                System.out.println("Bottone cliccato!");
                lbl.setText("Hai cliccato!");
                System.out.println(txt.getText());
            }
        });

        btnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtArea.setText(""); // svuota l'area di testo
            }
        });

        frm.add(bt);
        frm.add(btnClear);
        frm.add(lbl);
        frm.add(txt);
        frm.add(scr);

        frm.setVisible(true);

    }
}

