package com.paint.fenetre;

import java.io.IOException;

public class MainClass {
    public static void main(String args[]) throws IOException {
        MaFenetre fenetre = new MaFenetre();
        fenetre.setVisible(true);
        System.out.println(Thread.currentThread());
    }

}
