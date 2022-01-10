package com.paint.fenetre;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Menu extends JMenuBar{
    private  JMenuBar barMenu;
    private JMenu fichier;
    private JMenuItem newFile;
    private JMenuItem openFile;
    private JMenuItem saveFile;
    private JMenuItem exit;

    private MaFenetre fenetre ;
    private  JFileChooser fileChooser;
    private File file;
    private  Dimension newDimensions;

    public Menu(MaFenetre fenetre) throws IOException {
        this.fenetre = fenetre;
        this.setBackground(Color.white);
        fileChooser = new JFileChooser(new File("."));
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image Files", "jpg", "png"));

        fichier = new JMenu("Fichier");

        ImageIcon iconNew=new ImageIcon("src/icons/new-file.png");
        newFile = new JMenuItem("New file",iconNew);
        newFile.setPreferredSize(new Dimension(200,50));
        newFile.setBackground(Color.WHITE);
        newFile.addActionListener(new MenuEvents());

        ImageIcon iconFolder=new ImageIcon("src/icons/folder.png");
        openFile = new JMenuItem("open file",iconFolder);
        openFile.setPreferredSize(new Dimension(200,50));
        openFile.setBackground(Color.WHITE);
        openFile.addActionListener(new MenuEvents());

        ImageIcon iconSave=new ImageIcon("src/icons/save-file.png");
        saveFile = new JMenuItem("save file",iconSave);
        saveFile.setPreferredSize(new Dimension(200,50));
        saveFile.setBackground(Color.WHITE);
        saveFile.addActionListener(new MenuEvents());

        ImageIcon iconExit=new ImageIcon("src/icons/logout.png");
        exit = new JMenuItem("Exit",iconExit);
        exit.setPreferredSize(new Dimension(200,50));
        exit.setBackground(Color.WHITE);
        exit.addActionListener(new MenuEvents());

        fichier.add(newFile);
        fichier.add(openFile);
        fichier.add(saveFile);
        fichier.addSeparator();
        fichier.add(exit);
        barMenu = new JMenuBar();
        barMenu.add(fichier);

    }
    public JMenuBar getBarMenu()
    {
        return this.barMenu ;
    }
    private void setDimensionsPanel(int width, int height)
    {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        if(height > dim.height - 160 && width > dim.width - 150)
        {
            fenetre.getPaintPanel().getPanelWhite().setSize(dim.width - 150, dim.height - 160);
        }
        else if(width > dim.width - 150)
        {
            fenetre.getPaintPanel().getPanelWhite().setSize(dim.width - 150, height);
        }
        else if(height > dim.height - 160)
        {
            fenetre.getPaintPanel().getPanelWhite().setSize(width, dim.height - 160);
        }
        else
        {
            fenetre.getPaintPanel().getPanelWhite().setSize(width, height);
        }
    }

    private BufferedImage makePanel(JPanel panel)
    {
        int w = panel.getWidth();
        int h = panel.getHeight();
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        panel.print(g);
        return bi;
    }

    class MenuEvents  implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == openFile) {
                if (fileChooser.showOpenDialog(fenetre) == JFileChooser.APPROVE_OPTION) {
                    file = fileChooser.getSelectedFile();
                    try {
                        fenetre.getPaintPanel().getPanelWhite().setImage(ImageIO.read(file));
                        newDimensions = new Dimension(ImageIO.read(file).getWidth(), ImageIO.read(file).getHeight());
                        setDimensionsPanel(newDimensions.width, newDimensions.height);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            else if (e.getSource() == saveFile) {
                if (fileChooser.showSaveDialog(fenetre) == JFileChooser.APPROVE_OPTION) {
                    file = new File(fileChooser.getSelectedFile() + ".png");
                    BufferedImage im = makePanel(fenetre.getPaintPanel().getPanelWhite());
                    try {
                        ImageIO.write(im, "png", file);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }
            else if (e.getSource() == exit) {
                fenetre.dispose();
            }
            else if (e.getSource() == newFile) {
                fenetre.getPaintPanel().getPanelWhite().clearPanel();
            }
        }

    }


}
