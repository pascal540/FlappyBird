package com;

import java.awt.event.*;

public class Clavier implements KeyListener {

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {

        if (e.getKeyCode() == 32) {
            Main.scene.flappyBird.monte();

        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) { // si on relache la touche on doit arreter le vaisseau !

    }
}