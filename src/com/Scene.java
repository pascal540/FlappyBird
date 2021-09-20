package com;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;

public class Scene extends JPanel {

    // VARIABLES
    private ImageIcon _icoBandeFond;
    private Image _ImgBandeFond;

    private final int LARGEUR_BANDE_FOND = 140; // tailel de l'image du fond

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

    }

    /**
     * Methodes
     */
    public void paintComponent(Graphics g) {

        g.drawImage(this._ImgBandeFond, 0, 0, null);
        g.drawImage(this._ImgBandeFond, this.LARGEUR_BANDE_FOND, 0, null);

    }
}