package com.objet;

import javax.swing.ImageIcon;
import java.awt.*;

public class Tuyau {
    // VARIABLES
    private int _largeur;
    private int _hauteur;
    private int _x;
    private int _y;
    private String _strimage;
    private ImageIcon _iconTuyau;
    private Image _imgTuyau;

    // CONSTRUCTEUR
    public Tuyau(int x, int y, String strImage) {
        this._largeur = 50;
        this._hauteur = 300;
        this._x = x;
        this._y = y;
        this._strimage = strImage;

        this._iconTuyau = new ImageIcon(getClass().getResource(this._strimage)); // on relie iconTuyau a strimage
        this._imgTuyau = this._iconTuyau.getImage(); // On associe l'iamge a iconTuyau !

    }

    // METHODES
    // getters accessers
    /**
     * @return int return the _largeur
     */
    public int get_largeur() {
        return _largeur;
    }

    /**
     * @return int return the _hauteur
     */
    public int get_hauteur() {
        return _hauteur;
    }

    /**
     * @return int return the _x
     */
    public int get_x() {
        return _x;
    }

    /**
     * @return int return the _y
     */
    public int get_y() {
        return _y;
    }

    /**
     * @return ImageIcon return the _iconTuyau
     */
    public ImageIcon get_iconTuyau() {
        return _iconTuyau;
    }

    /**
     * @return Image return the _imgTuyau
     */
    public Image get_imgTuyau() {
        return _imgTuyau;
    }

    // setters mutaters
    /**
     * @param _x the _x to set
     */
    public void set_x(int _x) {
        this._x = _x;
    }

    /**
     * @param _y the _y to set
     */
    public void set_y(int _y) {
        this._y = _y;
    }

    /**
     * @param _largeur the _largeur to set
     */
    public void set_largeur(int _largeur) {
        this._largeur = _largeur;
    }

    /**
     * @param _iconTuyau the _iconTuyau to set
     */
    public void set_iconTuyau(ImageIcon _iconTuyau) {
        this._iconTuyau = _iconTuyau;
    }

}