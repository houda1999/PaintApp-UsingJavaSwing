package com.paint.fenetre;

import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Test1{

        public static void main(String[] argv) {
            MyChooserPanel chooser = new MyChooserPanel();
            JFrame f = new JFrame();
            f.add(chooser);
            f.pack();
            f.setVisible(true);
        }
    }

    class MyChooserPanel extends AbstractColorChooserPanel {
        public void buildChooser() {
            setLayout(new GridLayout(0, 3));
            makeAddButton("Red", Color.red);
            makeAddButton("Green", Color.green);
            makeAddButton("Blue", Color.blue);
        }

        public void updateChooser() {
        }

        public String getDisplayName() {
            return "MyChooserPanel";
        }

        public Icon getSmallDisplayIcon() {
            return null;
        }
        public Icon getLargeDisplayIcon() {
            return null;
        }
        private void makeAddButton(String name, Color color) {
            JButton button = new JButton(name);
            button.setBackground(color);
            button.setAction(setColorAction);
            add(button);
        }

        Action setColorAction = new AbstractAction() {
            public void actionPerformed(ActionEvent evt) {
                JButton button = (JButton) evt.getSource();

                getColorSelectionModel().setSelectedColor(button.getBackground());
            }
        };
    }