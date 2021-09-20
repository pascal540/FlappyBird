package com;

public class Chrono implements Runnable {

    private final int PAUSE = 5;

    @Override
    public void run() {
        while (true) {
            Main.scene.xFond--; // o ndeplace le fond
            Main.scene.repaint(); // Appel paintComponent dans scene pour repeindre l'ecran
            try {
                Thread.sleep(this.PAUSE);// pause de 5 ms sur le thread d'affichage
            } catch (InterruptedException e) {
                // e.printStackTrace();
            }

        }

    }

}