package com.paint.fenetre;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorDialog extends JDialog implements ActionListener, ChangeListener {

    public static final int APPLY = 0;
    public static final int CANCEL = 1;
    int userResponse;

    private JTextField colorLook;
    private JButton ok;
    private JButton cancel;
    private JLabel labelColorRGB;
    private JLabel labelColorHEXA;

    private Color currentColor;
    private JSlider red;
    private JSlider green;
    private JSlider blue;

    public ColorDialog(Frame owner, Color c) {
        super(owner, "Customize Color", true);
        this.setResizable(false);
        this.setBackground(Color.white);

        colorLook = new JTextField("");
        colorLook.setHorizontalAlignment(SwingConstants.CENTER);
        colorLook.setPreferredSize(new Dimension(150,100));
        colorLook.setFont(new Font("sanserif", Font.PLAIN, 28));
        colorLook.setEditable(false);

        labelColorRGB = new JLabel("RGB ( "+c.getRed()+" , "+c.getGreen()+" , "+c.getBlue()+" )");
        labelColorRGB.setFont(new Font("SansSerif",Font.PLAIN,15));

        labelColorHEXA = new JLabel( String.format("#%02x%02x%02x",c.getRed(),c.getGreen(),c.getBlue()));
        labelColorHEXA.setFont(new Font("SansSerif",Font.PLAIN,15));


        ok = new JButton("Apply");
        cancel = new JButton("Cancel");
        ok.setPreferredSize(cancel.getPreferredSize());

        currentColor = c;

        red = new JSlider(0, 255, currentColor.getRed());
        red.setBackground(Color.white);
        blue = new JSlider(0, 255, currentColor.getBlue());
        blue.setBackground(Color.white);
        green = new JSlider(0, 255, currentColor.getGreen());
        green.setBackground(Color.white);

        // -------------
        // add listeners
        // -------------

        ok.addActionListener(this);
        cancel.addActionListener(this);

        red.addChangeListener(this);
        blue.addChangeListener(this);
        green.addChangeListener(this);

        // -----------------
        // layout components
        // -----------------

        JPanel panelParent = new JPanel();
        panelParent.setBackground(Color.white);
        panelParent.setLayout(new BorderLayout());
        panelParent.setBorder(new EmptyBorder(20, 20, 20, 20 ));

        JPanel colorPanel = new JPanel();
        colorPanel.setBackground(Color.white);
        colorPanel.setLayout(new BoxLayout(colorPanel,BoxLayout.PAGE_AXIS));
        JLabel labelred = new JLabel("Red");
        labelred.setFont(new Font("SansSerif",Font.PLAIN,13));
        JLabel labelgreen = new JLabel("Green");
        labelgreen.setFont(new Font("SansSerif",Font.PLAIN,13));
        JLabel labelBlue = new JLabel("Blue");
        labelBlue.setFont(new Font("SansSerif",Font.PLAIN,13));
        colorPanel.add(labelred);
        colorPanel.add(Box.createVerticalStrut(20));
        colorPanel.add(labelgreen);
        colorPanel.add(Box.createVerticalStrut(20));
        colorPanel.add(labelBlue);

        JPanel sliderPanel = new JPanel();
        sliderPanel.setBackground(Color.white);
        sliderPanel.setLayout(new BoxLayout(sliderPanel,BoxLayout.PAGE_AXIS));
        sliderPanel.add(red);
        sliderPanel.add(Box.createVerticalStrut(20));
        sliderPanel.add(green);
        sliderPanel.add(Box.createVerticalStrut(20));
        sliderPanel.add(blue);

        JPanel panelColor = new JPanel();
        panelColor.setLayout(new BoxLayout(panelColor,BoxLayout.LINE_AXIS));
        panelColor.setBackground(Color.white);
        panelColor.add(colorPanel);
        panelColor.add(Box.createHorizontalStrut(20));
        panelColor.add(sliderPanel);

        panelParent.add(panelColor,BorderLayout.EAST);
        colorPanel.add(Box.createHorizontalStrut(40));

        JPanel panelLook = new JPanel();
        panelLook.setLayout(new BoxLayout(panelLook,BoxLayout.PAGE_AXIS));
        panelLook.setBackground(Color.white);
        panelLook.add(labelColorRGB);
        panelLook.add(Box.createVerticalStrut(10));
        panelLook.add(labelColorHEXA);
        panelLook.add(Box.createVerticalStrut(10));

        JPanel paneButton = new JPanel();
        paneButton.setLayout(new BoxLayout(paneButton,BoxLayout.LINE_AXIS));
        paneButton.setBackground(Color.white);
        paneButton.setBorder(new EmptyBorder(20,0,0,0));
        paneButton.add(ok);
        paneButton.add(Box.createHorizontalStrut(10));
        paneButton.add(cancel);


        panelParent.add(colorLook,BorderLayout.CENTER);
        panelParent.add(panelLook,BorderLayout.NORTH);
        panelParent.add(paneButton,BorderLayout.SOUTH);

        this.setContentPane(panelParent);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if (source == ok) {
            userResponse = APPLY;
            this.setVisible(false);
        }

        else if (source == cancel) {
            userResponse = CANCEL;
            this.setVisible(false);
        }

    }

    public void updateColor() {
        currentColor = new Color(red.getValue(), green.getValue(), blue.getValue());
        labelColorRGB.setText("RGB ( "+red.getValue()+" , "+green.getValue()+" , "+blue.getValue()+" )");
        labelColorHEXA.setText( String.format("#%02x%02x%02x", red.getValue(), green.getValue(), blue.getValue()));
        colorLook.setBackground(currentColor);
    }

    public Color getColor() {
        return colorLook.getBackground();
    }

    public int showCustomDialog(Frame f, Color c) {
        this.setLocationRelativeTo(f);


        red.setValue(c.getRed());
        green.setValue(c.getGreen());
        blue.setValue(c.getBlue());
        updateColor();

        this.setVisible(true);


        return userResponse;
    }

    @Override
    public void stateChanged(ChangeEvent arg0) {
        // TODO Auto-generated method stub
        updateColor();
    }
}
