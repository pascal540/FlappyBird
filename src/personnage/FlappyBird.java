package personnage;

import javax.swing.ImageIcon;
import java.awt.*;

public class FlappyBird implements Runnable {

    // VARIABLES

    private int _largeur;
    private int _hauteur;
    private int _x;
    private int _y;
    private int _dy; // deplacement oiseau
    private String _strImage;
    private ImageIcon _iconOiseau;
    private Image _imgOiseau;
    private final int _PAUSE = 10;

    public FlappyBird(int x, int y, String strImage) {
        this._largeur = 34;
        this._hauteur = 24;
        this._x = x;
        this._y = y;
        this._strImage = strImage;
        this._iconOiseau = new ImageIcon(getClass().getResource(this._strImage));
        this._imgOiseau = this._iconOiseau.getImage();
        Thread chronoOiseau = new Thread(this);
        chronoOiseau.start();
    }

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
     * @return ImageIcon return the _iconOiseau
     */
    public ImageIcon get_iconOiseau() {
        return _iconOiseau;
    }

    /**
     * @return String return the _strImage
     */
    public String get_strImage() {
        return _strImage;
    }

    /**
     * @return Image return the _imgOiseau
     */
    public Image get_imgOiseau() {
        return _imgOiseau;
    }

    /**
     * @param _largeur the _largeur to set
     */
    public void set_largeur(int _largeur) {
        this._largeur = _largeur;
    }

    /**
     * @param _hauteur the _hauteur to set
     */
    public void set_hauteur(int _hauteur) {
        this._hauteur = _hauteur;
    }

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
     * @param _strImage the _strImage to set
     */
    public void set_strImage(String _strImage) {
        this._strImage = _strImage;
    }

    /**
     * @param _iconOiseau the _iconOiseau to set
     */
    public void set_iconOiseau(ImageIcon _iconOiseau) {
        this._iconOiseau = _iconOiseau;
    }

    /**
     * @param _imgOiseau the _imgOiseau to set
     */
    public void set_imgOiseau(Image _imgOiseau) {
        this._imgOiseau = _imgOiseau;
    }

    public void monte() {
        this._dy = 50;

    }

    private void batDesAiles(int dy) {
        if (dy > 10) {
            this._iconOiseau = new ImageIcon(getClass().getResource("/images/oiseau2.png"));
            this._imgOiseau = this._iconOiseau.getImage();

            this._y -= 3;
        } else {
            if (this._dy > 5) {
                this._y -= 2;
            } else if (this._dy > 1) {
                this._y -= 1;
            } else if (this._dy == 1) {
                this._iconOiseau = new ImageIcon(getClass().getResource("/images/oiseau1.png"));
                this._imgOiseau = this._iconOiseau.getImage();

            }
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                this._dy--;
                this.batDesAiles(_dy);
                Thread.sleep(_PAUSE);
            } catch (InterruptedException e) {

                // e.printStackTrace();
            }

        }
    }
}