package com;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import objet.Tuyau;
import personnage.FlappyBird;

import java.awt.*;
import java.util.Random;

public class Scene extends JPanel {

    // VARIABLES
    private ImageIcon _icoBandeFond;
    private Image _ImgBandeFond;
    public FlappyBird flappyBird;
    private final int LARGEUR_BANDE_FOND = 140; // tailel de l'image du fond
    private final int DISTANCE_TUYAUX = 250;
    private final int ECART_TUYAUX = 120;

    public int xFond; // determiantion abcsicce de la gauche de bande fond a defiler

    private int _xTuyaux;

    ///
    public Tuyau tuyauHaut1;
    public Tuyau tuyauBas1;

    public Tuyau tuyauHaut2;
    public Tuyau tuyauBas2;

    public Tuyau tuyauHaut3;
    public Tuyau tuyauBas3;
    public boolean finDuJeu;
    private Random hasard;

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
        this._xTuyaux = 400;
        this.finDuJeu = false;

        this.tuyauHaut1 = new Tuyau(this._xTuyaux, -150, "/images/tuyauhaut.png");
        this.tuyauBas1 = new Tuyau(this._xTuyaux, 250, "/images/tuyauBas.png");

        this.tuyauHaut2 = new Tuyau(this._xTuyaux + this.DISTANCE_TUYAUX, -100, "/images/tuyauhaut.png");
        this.tuyauBas2 = new Tuyau(this._xTuyaux + this.DISTANCE_TUYAUX, 300, "/images/tuyaubas.png");

        this.tuyauHaut3 = new Tuyau(this._xTuyaux + this.DISTANCE_TUYAUX * 2, -120, "/images/tuyauhaut.png");
        this.tuyauBas3 = new Tuyau(this._xTuyaux + this.DISTANCE_TUYAUX * 2, 280, "/images/tuyaubas.png");
        this.flappyBird = new FlappyBird(100, 150, "/images/oiseau1.png");

        hasard = new Random();

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Clavier());

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

    private void deplacementTuyaux(Graphics g) {
        // tuyau1
        this.tuyauHaut1.set_x(this.tuyauHaut1.get_x() - 1);
        this.tuyauBas1.set_x(this.tuyauHaut1.get_x());

        if (this.tuyauHaut1.get_x() == -100) {
            this.tuyauHaut1.set_x(this.tuyauHaut3.get_x() + this.DISTANCE_TUYAUX);
            this.tuyauHaut1.set_y(-100 - (10 * this.hasard.nextInt(18)));
            this.tuyauBas1.set_y(this.tuyauHaut1.get_y() + this.tuyauHaut1.get_hauteur() + this.ECART_TUYAUX);
        }
        g.drawImage(this.tuyauHaut1.get_imgTuyau(), this.tuyauHaut1.get_x(), this.tuyauHaut1.get_y(), null);
        g.drawImage(this.tuyauBas1.get_imgTuyau(), this.tuyauBas1.get_x(), this.tuyauBas1.get_y(), null);

        // tuyau2
        this.tuyauHaut2.set_x(this.tuyauHaut2.get_x() - 1);
        this.tuyauBas2.set_x(this.tuyauHaut2.get_x());

        if (this.tuyauHaut2.get_x() == -100) {
            this.tuyauHaut2.set_x(this.tuyauHaut1.get_x() + this.DISTANCE_TUYAUX);
            this.tuyauHaut2.set_y(-100 - (10 * this.hasard.nextInt(18)));
            this.tuyauBas2.set_y(this.tuyauHaut2.get_y() + this.tuyauHaut2.get_hauteur() + this.ECART_TUYAUX);
        }
        g.drawImage(this.tuyauHaut2.get_imgTuyau(), this.tuyauHaut2.get_x(), this.tuyauHaut2.get_y(), null);
        g.drawImage(this.tuyauBas2.get_imgTuyau(), this.tuyauBas2.get_x(), this.tuyauBas2.get_y(), null);

        // // tuyau3
        this.tuyauHaut3.set_x(this.tuyauHaut3.get_x() - 1);
        this.tuyauBas3.set_x(this.tuyauHaut3.get_x());

        if (this.tuyauHaut3.get_x() == -100) {
            this.tuyauHaut3.set_x(this.tuyauHaut2.get_x() + this.DISTANCE_TUYAUX);
            this.tuyauHaut3.set_y(-100 - (10 * this.hasard.nextInt(18)));
            this.tuyauBas3.set_y(this.tuyauHaut3.get_y() + this.tuyauHaut3.get_hauteur() + this.ECART_TUYAUX);
        }
        g.drawImage(this.tuyauHaut3.get_imgTuyau(), this.tuyauHaut3.get_x(), this.tuyauHaut3.get_y(), null);
        g.drawImage(this.tuyauBas3.get_imgTuyau(), this.tuyauBas3.get_x(), this.tuyauBas3.get_y(), null);

    }

    private boolean collisionFlappy() {
        boolean finDuJeu = false;
        // proche du tuyau1 ?
        if (this.flappyBird.get_x() + this.flappyBird.get_largeur() > this.tuyauBas1.get_x() - 20
                && this.flappyBird.get_x() < tuyauBas1.get_x() + this.tuyauBas1.get_largeur() + 20) {
            finDuJeu = this.flappyBird.collision(this.tuyauBas1);
            if (finDuJeu == false) {
                finDuJeu = this.flappyBird.collision(this.tuyauHaut1);
            }
        } else { // proche tuyau2 ?
            if (this.flappyBird.get_x() + this.flappyBird.get_largeur() > this.tuyauBas2.get_x() - 20
                    && this.flappyBird.get_x() < tuyauBas2.get_x() + this.tuyauBas2.get_largeur() + 20) {
                finDuJeu = this.flappyBird.collision(this.tuyauBas2);
                if (finDuJeu == false) {
                    finDuJeu = this.flappyBird.collision(this.tuyauHaut2);
                }
            } else { // proche tuyau3 ?
                if (this.flappyBird.get_x() + this.flappyBird.get_largeur() > this.tuyauBas3.get_x() - 20
                        && this.flappyBird.get_x() < tuyauBas3.get_x() + this.tuyauBas3.get_largeur() + 20) {
                    finDuJeu = this.flappyBird.collision(this.tuyauBas3);
                    if (finDuJeu == false) {
                        finDuJeu = this.flappyBird.collision(this.tuyauHaut3);
                    }
                } else { // contact avec le plafond ou le sol
                    if (this.flappyBird.get_y() < 0 || this.flappyBird.get_y() + this.flappyBird.get_hauteur() > 355) {
                        finDuJeu = true;
                    } else {
                        finDuJeu = false;
                    }
                }
            }
        }
        return finDuJeu;
    }

    public void paintComponent(Graphics g) {
        this.deplacementFond(g);
        this.deplacementTuyaux(g);
        this.finDuJeu = this.collisionFlappy(); // a chaque rafraicchissement ecran on teste
        this.flappyBird.set_y(this.flappyBird.get_y() + 1);
        g.drawImage(this.flappyBird.get_imgOiseau(), this.flappyBird.get_x(), this.flappyBird.get_y(), null);

    }
}