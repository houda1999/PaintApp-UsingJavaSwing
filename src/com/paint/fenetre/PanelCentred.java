package com.paint.fenetre;


import javax.swing.*;
import java.awt.*;

public class PanelCentred extends JPanel{


    private PanelPaint panelWhite;
    private int activatedTool = 0;
    public   MaFenetre fenetre ;


    public PanelCentred(MaFenetre frame)
    {
        this.setBackground(Color.lightGray);

        this.fenetre = frame;

        panelWhite = new PanelPaint(this);

        this.add(panelWhite,BorderLayout.CENTER);

    }

    public void setIndiceTool(int newIndice) { activatedTool = newIndice;}

    public int getActivatedTool(){return activatedTool;}

    public PanelPaint getPanelWhite(){ return this.panelWhite; }



}
