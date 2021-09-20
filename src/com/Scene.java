package com;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;

public class Scene extends JPanel {

    // VARIABLES
    private ImageIcon _icoBandeFond;
    private Image _ImgBandeFond;

    private final int LARGEUR_BANDE_FOND = 140; // tailel de l'image du fond
    public int xFond; // determiantion abcsicce de la gauche de bande fond a defiler

    /**
     * CONSTRUCTEUR
     */
    public Scene() {

        super(); // constructeur super classe ici JPanel
        // Instanciations
        this._icoBandeFond = new ImageIcon(getClass().getResource("/images/bandeFondEcran.png")); // assocaition a
                                                                                                  // iconbandefond
                                                                                                  // l'iamge stockee
                                                                                                  // dans image
        this._ImgBandeFond = this._icoBandeFond.getImage(); // association à l'imagebandefond de cette image
        this.xFond = 0;
        Thread chronoEcran = new Thread(new Chrono());
        chronoEcran.start(); // depart chrono et affichage ecran
    }

    /**
     * Methodes
     */

    private void deplacementFond(Graphics g) {
        if (this.xFond == -this.LARGEUR_BANDE_FOND) {
            this.xFond = 0;
        }
        g.drawImage(this._ImgBandeFond, this.xFond, 0, null);
        g.drawImage(this._ImgBandeFond, this.xFond + LARGEUR_BANDE_FOND, 0, null);
        g.drawImage(this._ImgBandeFond, this.xFond + LARGEUR_BANDE_FOND * 2, 0, null);
        g.drawImage(this._ImgBandeFond, this.xFond + LARGEUR_BANDE_FOND * 3, 0, null);

    }

    public void paintComponent(Graphics g) {
        this.deplacementFond(g);

    }
}