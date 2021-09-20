package com;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.objet.Tuyau;

import java.awt.*;

public class Scene extends JPanel {

    // VARIABLES
    private ImageIcon _icoBandeFond;
    private Image _ImgBandeFond;

    private final int LARGEUR_BANDE_FOND = 140; // tailel de l'image du fond
    private final int DISTANCE_TUYAUX = 250;
    private final int ECART_TUYAUX = 120;

    public int xFond; // determiantion abcsicce de la gauche de bande fond a defiler
    private int _dxTuyaux;
    private int _xTuyaux;

    ///
    public Tuyau tuyauHaut1;
    public Tuyau tuyauBas1;

    public Tuyau tuyauHaut2;
    public Tuyau tuyauBas2;

    public Tuyau tuyauHaut3;
    public Tuyau tuyauBas3;

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
        this._xTuyaux = 100;
        this._dxTuyaux = 0;

        this.tuyauHaut1 = new Tuyau(this._xTuyaux, -150, "/images/tuyauhaut.png");
        this.tuyauBas1 = new Tuyau(this._xTuyaux, -250, "/images/tuyaubas.png");

        this.tuyauHaut2 = new Tuyau(this._xTuyaux + this.tuyauBas1.get_largeur() + this.ECART_TUYAUX, -150,
                "/images/tuyauhaut.png");
        this.tuyauBas2 = new Tuyau(this._xTuyaux + this.tuyauHaut1.get_largeur() + this.ECART_TUYAUX, -150,
                "/images/tuyaubas.png");

        this.tuyauHaut3 = new Tuyau(this._xTuyaux + (this.tuyauBas1.get_largeur() + this.ECART_TUYAUX * 2), -150,
                "/images/tuyauhaut.png");
        this.tuyauBas3 = new Tuyau(this._xTuyaux + (this.tuyauHaut1.get_largeur() + this.ECART_TUYAUX * 2), -250,
                "/images/tuyaubas.png");

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