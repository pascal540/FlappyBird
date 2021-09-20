package com;

import javax.swing.JFrame;

public class Main {

    public static JFrame fenetre; // une seule copie de cette variable elle sera partagee entre tous les objets de
                                  // cette classe ! partagee par toutes les instances de la classe
    public static Scene Scene;

    public static void main(String[] args) throws Exception {
        fenetre = new JFrame("Flappy Bird");

        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // permet de fermer le programme en cliquant sur la
                                                                // croix rouge
        fenetre.setSize(300, 425);
        fenetre.setLocationRelativeTo(null);// au centre

        fenetre.setResizable(false); // pas de redimensioinement
        fenetre.setAlwaysOnTop(true); // tjs au dessu des autres fenetres

        Scene scene = new Scene();
        fenetre.setContentPane(scene);
        fenetre.setVisible(true);

        // il faut un panneau pour metrte une image sur une fenetre

    }
}
