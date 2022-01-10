package com.paint.fenetre;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

public class BottomBar extends JToolBar {

    public BottomBar()
    {
        this.setBackground(Color.WHITE);
        this.setFloatable(false);
        this.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        this.setAlignmentY(BOTTOM_ALIGNMENT);
    }



}
