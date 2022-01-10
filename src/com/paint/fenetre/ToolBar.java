package com.paint.fenetre;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.Component.TOP_ALIGNMENT;

public class ToolBar implements MouseListener {

    private JToolBar jToolBar;
    private MaFenetre frame;

    private JButton buttonPencil;
    private JButton buttonBucket;
    private JButton buttonLettres;
    private  JButton buttonEarser;

    private JPanel panelOutils;
    private JPanel panelFormes;
    private JPanel panelCangeColors;
    private JPanel panelColors;
    private  JPanel panelActionInPanel;

    private JButton colorBlack ;
    private JButton colorWhite ;
    private JButton colorGrey ;
    private JButton colorRougeBrique ;
    private JButton colorRouge ;
    private JButton colorTurquoise;
    private JButton colorMarron ;
    private JButton colorPink ;
    private JButton colorPurple ;
    private JButton colorBleu ;
    private JButton colorGreen ;
    private JButton colorYellow ;
    private JButton colorOrange ;
    private JButton colorNew1;
    private JButton colorNew2;
    private JButton colorNew3;
    private JButton changeColor;
    private JButton currentColor;
    private  ColorDialog colorDialog;


    private JButton buttonRectangle ;
    private JButton buttonTriangle ;
    private JButton buttonCircle ;
    private JButton buttonline ;

    private JButton buttonUndo;
    private JButton buttonRedo;
    private JButton buttonClear;

    public ToolBar()
    {

    }

    public ToolBar(MaFenetre frame){
        this.frame = frame;

        jToolBar = new JToolBar();
        jToolBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        jToolBar.setBackground(Color.WHITE);
        jToolBar.setPreferredSize(new Dimension(100,100));
        jToolBar.setFloatable(false);
        jToolBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
        jToolBar.setAlignmentY(TOP_ALIGNMENT);

        jToolBar.add(createPanelOutils());

        JSeparator sep = new JSeparator(SwingConstants.VERTICAL);
        sep.setForeground(new Color(229, 229, 229));
        sep.setPreferredSize(new Dimension(1,85));
        jToolBar.add(sep);
        jToolBar.add(this.createPanelColors());

        JSeparator sep3 = new JSeparator(SwingConstants.VERTICAL);
        sep3.setForeground(new Color(229, 229, 229));
        sep3.setPreferredSize(new Dimension(1,85));
        jToolBar.add(sep3);
        jToolBar.add(this.createPanelChangeColor());

        JSeparator sep2 = new JSeparator(SwingConstants.VERTICAL);
        sep2.setForeground(new Color(229, 229, 229));
        sep2.setPreferredSize(new Dimension(1,85));
        jToolBar.add(sep2);
        jToolBar.add(this.createPanelFormes());

        colorDialog = new ColorDialog(frame,currentColor.getBackground());

        JSeparator sep4 = new JSeparator(SwingConstants.VERTICAL);
        sep4.setForeground(new Color(229, 229, 229));
        sep4.setPreferredSize(new Dimension(1,85));
        jToolBar.add(sep4);
        jToolBar.add(this.createPanelActionInPanel());

    }

    public JPanel createPanelOutils()
    {
        panelOutils = new JPanel();
        panelOutils.setBorder(new EmptyBorder(5, 5, 5, 5 ));
        panelOutils.setLayout(new BorderLayout());
        panelOutils.setBackground(Color.WHITE);

        JPanel panelIcons = new JPanel();
        GridLayout gridLayout = new GridLayout(2,3);
        gridLayout.setHgap(15);gridLayout.setVgap(15);
        panelIcons.setLayout(gridLayout);

        this.buttonPencil = new JButton(new ImageIcon("src/icons/pencil.png"));
        buttonPencil.setToolTipText("Crayon");
        buttonPencil.setBorder(BorderFactory.createEmptyBorder());
        buttonPencil.setBackground(Color.WHITE);
        buttonPencil.addMouseListener(this);
        panelIcons.add(buttonPencil);

        this.buttonLettres = new JButton(new ImageIcon("src/icons/letter-a.png"));
        buttonLettres.setToolTipText("Texte");
        buttonLettres.setBorder(BorderFactory.createEmptyBorder());
        buttonLettres.setBackground(Color.WHITE);
        buttonLettres.addMouseListener(this);
//        panelIcons.add(buttonLettres);

        this.buttonEarser = new JButton(new ImageIcon("src/icons/eraser.png"));
        buttonEarser.setToolTipText("earser");
        buttonEarser.setBorder(BorderFactory.createEmptyBorder());
        buttonEarser.setBackground(Color.WHITE);
        buttonEarser.addMouseListener(this);
        panelIcons.add(buttonEarser);

        this.buttonBucket = new JButton(new ImageIcon("src/icons/paint-bucket.png"));
        buttonBucket.setToolTipText("Bucket");
        buttonBucket.setBorder(BorderFactory.createEmptyBorder());
        buttonBucket.setBackground(Color.WHITE);
        buttonBucket.addMouseListener(this);
        panelIcons.add(buttonBucket);

        panelIcons.setBackground(Color.WHITE);
        panelOutils.add(panelIcons,BorderLayout.CENTER);
        JLabel label = new JLabel("Outils");
        label.setFont(new Font("SansSerif",Font.PLAIN,13));
        label.setBorder(new EmptyBorder(10, 0, 0, 0 ));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panelOutils.add(label,BorderLayout.SOUTH);

        return this.panelOutils;

    }

    public JToolBar getjToolBar()
    {
        return this.jToolBar;
    }


    public JPanel createPanelColors()
    {
            final int heightCarreau = 20;
            final int widthCarreau = 25;

            panelColors = new JPanel();
            panelColors.setBorder(new EmptyBorder(5, 5, 5, 5 ));
            panelColors.setLayout(new BorderLayout());
            panelColors.setBackground(Color.WHITE);

            JPanel panelCarreaux = new JPanel();
            GridLayout gridLayout = new GridLayout(2,7);
            gridLayout.setHgap(3);gridLayout.setVgap(3);
            panelCarreaux.setLayout(gridLayout);
            panelCarreaux.setBackground(Color.WHITE);

            colorBlack = new JButton();
            colorBlack.setBackground(Color.black);colorBlack.setPreferredSize(new Dimension(widthCarreau,heightCarreau));
            panelCarreaux.add(colorBlack);
            colorBlack.addMouseListener(this);

            colorWhite= new JButton();
            colorWhite.setBackground(Color.WHITE);colorWhite.setPreferredSize(new Dimension(widthCarreau,heightCarreau));
            panelCarreaux.add(colorWhite);
            colorWhite.addMouseListener(this);

            colorGrey= new JButton();
            colorGrey.setBackground(Color.GRAY);colorGrey.setPreferredSize(new Dimension(widthCarreau,heightCarreau));
            panelCarreaux.add(colorGrey);
            colorGrey.addMouseListener(this);

            colorRougeBrique = new JButton();
            colorRougeBrique.setBackground(new Color(136,0,21));colorRougeBrique.setPreferredSize(new Dimension(widthCarreau,heightCarreau));
            panelCarreaux.add(colorRougeBrique);
            colorRougeBrique.addMouseListener(this);

            colorRouge = new JButton();
            colorRouge.setBackground(new Color(237,28,36));colorRouge.setPreferredSize(new Dimension(widthCarreau,heightCarreau));
            panelCarreaux.add(colorRouge);
            colorRouge.addMouseListener(this);

            colorOrange= new JButton();
            colorOrange.setBackground(new Color(255,127,39));colorOrange.setPreferredSize(new Dimension(widthCarreau,heightCarreau));
            panelCarreaux.add(colorOrange);
            colorOrange.addMouseListener(this);

            colorYellow = new JButton();
            colorYellow.setBackground(new Color(255,255,0));colorYellow.setPreferredSize(new Dimension(widthCarreau,heightCarreau));
            panelCarreaux.add(colorYellow);
            colorYellow.addMouseListener(this);

            colorGreen = new JButton();
            colorGreen.setBackground(new Color(0,128,0));colorGreen.setPreferredSize(new Dimension(widthCarreau,heightCarreau));
            panelCarreaux.add(colorGreen);
            colorGreen.addMouseListener(this);

            colorBleu = new JButton();
            colorBleu.setBackground(new Color(0,64,128));colorBleu.setPreferredSize(new Dimension(widthCarreau,heightCarreau));
            panelCarreaux.add(colorBleu);
            colorBleu.addMouseListener(this);

            colorPurple = new JButton();
            colorPurple.setBackground(new Color(128,0,128));colorPurple.setPreferredSize(new Dimension(widthCarreau,heightCarreau));
            panelCarreaux.add(colorPurple);
            colorPurple.addMouseListener(this);

            colorPink = new JButton();
            colorPink.setBackground(new Color(255,128,192));colorPink.setPreferredSize(new Dimension(widthCarreau,heightCarreau));
            panelCarreaux.add(colorPink);
            colorPink.addMouseListener(this);

            colorMarron = new JButton();
            colorMarron.setBackground(new Color(185,122,87));colorMarron.setPreferredSize(new Dimension(widthCarreau,heightCarreau));
            panelCarreaux.add(colorMarron);
            colorMarron.addMouseListener(this);

            colorTurquoise = new JButton();
            colorTurquoise.setBackground(new Color(153,217,235));colorTurquoise.setPreferredSize(new Dimension(widthCarreau,heightCarreau));
            panelCarreaux.add(colorTurquoise);
            colorTurquoise.addMouseListener(this);


            JPanel panelCurrentColor = new JPanel();
            panelCurrentColor.setBorder(new EmptyBorder(1, 0, 3, 10));
            panelCurrentColor.setLayout(new BorderLayout());
            panelCurrentColor.setBackground(Color.white);

            currentColor = new JButton();
            currentColor.setBackground(Color.BLACK);
            currentColor.setFocusPainted( false );
            currentColor.setEnabled(false);
            panelCurrentColor.add(currentColor,BorderLayout.CENTER);

            JLabel labelCurrent = new JLabel("<HTML><p style='text-align: center;'>Current<br>Color</p></HTML>");
            labelCurrent.setFont(new Font("SansSerif",Font.PLAIN,11));
            labelCurrent.setBorder(new EmptyBorder(0, 0,0,0));

            JLabel label = new JLabel("Couleurs");
            label.setFont(new Font("SansSerif",Font.PLAIN,13));
            label.setBorder(new EmptyBorder(15, 0,0,0));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());
            panel.setBackground(Color.WHITE);
            panel.add(labelCurrent,BorderLayout.WEST);
            panel.add(label);

            panelColors.add(panelCarreaux,BorderLayout.CENTER);
            panelColors.add(panel,BorderLayout.SOUTH);
            panelColors.add(panelCurrentColor,BorderLayout.WEST);

            return this.panelColors;
        }


        public JPanel createPanelChangeColor()
        {
            this.panelCangeColors = new JPanel();
            panelCangeColors .add(Box.createHorizontalStrut(7));
            panelCangeColors.setBackground(Color.WHITE);
            panelCangeColors.setBorder(new EmptyBorder(5, 5, 5, 5 ));

            panelCangeColors .setLayout(new BorderLayout());
            changeColor = new JButton();changeColor.setBorder(BorderFactory.createEmptyBorder());
            changeColor.setBackground(Color.WHITE);
            changeColor.addMouseListener(this);
            changeColor.setIcon(new ImageIcon("src/icons/palette.png"));

            panelCangeColors .add(changeColor,BorderLayout.CENTER);

            JLabel label = new JLabel("Change Color");
            label.setFont(new Font("SansSerif",Font.PLAIN,13));
            label.setBorder(new EmptyBorder(18, 0,0,0));
            label.setHorizontalAlignment(SwingConstants.CENTER);

            panelCangeColors.add(label,BorderLayout.SOUTH);

            return  panelCangeColors;
        }


   public JPanel createPanelFormes()
    {
            JPanel panelIcons = new JPanel();

            panelFormes = new JPanel();
            panelFormes.setBorder(new EmptyBorder(5, 5, 5, 5 ));
            panelFormes.setLayout(new BorderLayout());
            panelFormes.setBackground(Color.WHITE);

            panelIcons.setLayout(new FlowLayout(FlowLayout.LEFT));
            panelIcons.setBackground(Color.WHITE);

            buttonline = new JButton(new ImageIcon("src/icons/line.png"));
            buttonline.setBackground(Color.WHITE);
            buttonline.setBorder((new EmptyBorder(0, 0, 0, 0 )));
            panelIcons.add(buttonline);
            panelIcons.add(Box.createHorizontalStrut(7));
            buttonline.addMouseListener(this);

            buttonCircle = new JButton(new ImageIcon("src/icons/circle.png"));
            buttonCircle.setBackground(Color.WHITE);
            buttonCircle.setBorder((new EmptyBorder(0, 0, 0, 0 )));
            panelIcons.add(buttonCircle);
            panelIcons.add(Box.createHorizontalStrut(7));
            buttonCircle.addMouseListener(this);

            buttonTriangle = new JButton(new ImageIcon("src/icons/triangle.png"));
            buttonTriangle.setBackground(Color.WHITE);
            buttonTriangle.setBorder((new EmptyBorder(0, 0, 0, 0 )));
            panelIcons.add(buttonTriangle);
            panelIcons.add(Box.createHorizontalStrut(7));
            buttonTriangle.addMouseListener(this);


            buttonRectangle = new JButton(new ImageIcon("src/icons/rectangle.png"));
            buttonRectangle.setBackground(Color.WHITE);
            buttonRectangle.setBorder((new EmptyBorder(0, 0, 0, 0 )));
            panelIcons.add(buttonRectangle);
            buttonRectangle.addMouseListener(this);

            panelFormes.add(panelIcons,BorderLayout.CENTER);

            JLabel label = new JLabel("Formes");
            label.setFont(new Font("SansSerif",Font.PLAIN,13));
            label.setBorder(new EmptyBorder(10, 0,0,0));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            panelFormes.add(label,BorderLayout.SOUTH);

            return  this.panelFormes;

    }

    public JPanel createPanelActionInPanel()
    {
        this.panelActionInPanel = new JPanel();
        panelActionInPanel.setBackground(Color.white);
        this.panelActionInPanel.setBorder(new EmptyBorder(0, 5, 0, 5 ));
        this.panelActionInPanel.setLayout(new BorderLayout());

        JPanel panelIcons = new JPanel();
        panelIcons.setBackground(Color.white);
        panelIcons.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.buttonUndo = new JButton(new ImageIcon("src/icons/undo.png"));
        buttonUndo.setBackground(Color.WHITE);
        buttonUndo.setBorder((new EmptyBorder(0, 0, 0, 0 )));
        panelIcons.add(buttonUndo);
        panelIcons.add(Box.createHorizontalStrut(10));
        buttonUndo.addMouseListener(this);

        this.buttonRedo = new JButton(new ImageIcon("src/icons/redo.png"));
        buttonRedo.setBackground(Color.WHITE);
        buttonRedo.setBorder((new EmptyBorder(0, 0, 0, 0 )));
        panelIcons.add(buttonRedo);
        panelIcons.add(Box.createHorizontalStrut(10));
        buttonRedo.addMouseListener(this);

        this.buttonClear = new JButton(new ImageIcon("src/icons/clear.png"));
        buttonClear.setBackground(Color.WHITE);
        buttonClear.setBorder((new EmptyBorder(0, 0, 0, 0 )));
        panelIcons.add(buttonClear);
        buttonClear.addMouseListener(this);

        panelActionInPanel.add(panelIcons,BorderLayout.CENTER);

        JLabel label = new JLabel("Editer");
        label.setFont(new Font("SansSerif",Font.PLAIN,13));
        label.setBorder(new EmptyBorder(17, 0,0,0));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panelActionInPanel.add(label,BorderLayout.SOUTH);

        return  this.panelActionInPanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();

        if (source == buttonPencil) {
            this.frame.getPaintPanel().getPanelWhite().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            this.frame.getPaintPanel().setIndiceTool(1);
        }
        else if (source == buttonLettres) {
            this.frame.getPaintPanel().setIndiceTool(2);
        }
        else if (source == buttonEarser) {
            this.frame.getPaintPanel().getPanelWhite().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            this.frame.getPaintPanel().setIndiceTool(3);
        }
        else if (source == buttonBucket) {
            this.frame.getPaintPanel().getPanelWhite().setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            this.frame.getPaintPanel().setIndiceTool(4);
        }
        else if(source == buttonline)
        {
            this.frame.getPaintPanel().setIndiceTool(8);
        }
        else if(source == buttonCircle)
        {
            this.frame.getPaintPanel().setIndiceTool(6);
        }
        else if(source == buttonRectangle)
        {
            this.frame.getPaintPanel().setIndiceTool(5);
        }
        else if(source == buttonTriangle)
        {
            this.frame.getPaintPanel().setIndiceTool(7);
        }
        else if(source == buttonUndo)
        {
            this.frame.getPaintPanel().getPanelWhite().undo();
        }
        else if(source == buttonRedo)
        {
            this.frame.getPaintPanel().getPanelWhite().redo();
        }
        else if(source == buttonClear)
        {
            this.frame.getPaintPanel().getPanelWhite().clearPanel();
        }
        else if(source == changeColor)
        {
            int i = colorDialog.showCustomDialog(frame,currentColor.getBackground());

            if (i == ColorDialog.APPLY) {
                this.currentColor.setBackground(colorDialog.getColor());
                this.frame.getPaintPanel().getPanelWhite().setCurrentColor(currentColor.getBackground());
            }
        }
        else
        {
            this.currentColor.setBackground(((JButton)source).getBackground());
            this.frame.getPaintPanel().getPanelWhite().setCurrentColor(currentColor.getBackground());
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        Object source = e.getSource();

        if (source == buttonPencil) {
            buttonPencil.setBackground(Color.lightGray);
        }
        else if (source == buttonLettres) {
            buttonLettres.setBackground(Color.lightGray);
        }
        else if (source == buttonEarser) {
            buttonEarser.setBackground(Color.lightGray);
        }
        else if (source == buttonBucket) {
            buttonBucket.setBackground(Color.lightGray);
        }
        else if(source == buttonline)
        {
            buttonline.setBackground(Color.lightGray);
        }
        else if(source == buttonCircle)
        {
            buttonCircle.setBackground(Color.lightGray);
        }
        else if(source == buttonRectangle)
        {
            buttonRectangle.setBackground(Color.lightGray);
        }
        else if(source == buttonTriangle)
        {
            buttonTriangle.setBackground(Color.lightGray);
        }

    }

    @Override
    public void mouseExited(MouseEvent e) {

        Object source = e.getSource();

        if (source == buttonPencil) {
            buttonPencil.setBackground(Color.WHITE);
        }
        else if (source == buttonLettres) {
            buttonLettres.setBackground(Color.WHITE);
        }
        else if (source == buttonEarser) {
            buttonEarser.setBackground(Color.WHITE);
        }
        else if (source == buttonBucket) {
            buttonBucket.setBackground(Color.WHITE);
        }
        else if(source == buttonline)
        {
            buttonline.setBackground(Color.WHITE);
        }
        else if(source == buttonCircle)
        {
            buttonCircle.setBackground(Color.WHITE);
        }
        else if(source == buttonRectangle)
        {
            buttonRectangle.setBackground(Color.WHITE);
        }
        else if(source == buttonTriangle)
        {
            buttonTriangle.setBackground(Color.WHITE);
        }

    }
}
