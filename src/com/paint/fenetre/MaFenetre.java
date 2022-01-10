package com.paint.fenetre;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MaFenetre extends JFrame {


    private JScrollPane sp;
    private Menu menuBar ;
    private  ToolBar toolBar ;
    private PanelCentred paintPanel ;
    private final int FRAME_WIDTH = 1300;
    private final int FRAME_HEIGHT = 700;

    public MaFenetre() throws IOException {

            menuBar = new Menu(this);
            toolBar = new ToolBar(this);
            paintPanel = new PanelCentred(this);

            setJMenuBar(menuBar.getBarMenu());
            setBackground(Color.WHITE);

            add(toolBar.getjToolBar(), BorderLayout.NORTH);
            sp = new JScrollPane();
            sp.setLocation(10, 10);
            sp.setViewportView(paintPanel);
            sp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            add(new JPanel().add(sp),BorderLayout.CENTER);
            add(new BottomBar(),BorderLayout.SOUTH);

            this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
            this.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));

    }

    public PanelCentred getPaintPanel() {
        return paintPanel;
    }



}
