package com.paint.fenetre;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Stack;

public class PanelPaint extends JPanel implements MouseListener, MouseMotionListener{

    private  final Dimension sizeScreen = Toolkit.getDefaultToolkit().getScreenSize();
    private int widthPanel;
    private int heightPanel;
    private  PanelCentred panelCentred;

    private final int PENCIL_TOOL = 1;
    private final int TEXT_TOOL = 2;
    private final int ERASER_TOOL = 3;
    private final int BUCKET_TOOL = 4;


    private final int LINE = 8;
    private final int RECTANGLE = 5;
    private final int CIRCLE = 6;
    private final int TRIANGLE = 7;

    int x1,x2,y1,y2;

    private BasicStroke stroke = new BasicStroke((float) 2);
    BufferedImage canvas;
    Graphics2D graphics2D;

    private ArrayList<Elements> elements;
    private Stack<Elements> removed;

    private int group;

    private boolean dragged = false;
    private Color currentColor;
    private boolean abstarct ;

    public PanelPaint(PanelCentred parent)
    {
        this.setBackground(Color.WHITE);
        this.setBorder(new EmptyBorder(0,0,0,0));
        this.widthPanel = (int)sizeScreen.getWidth()-100;
        this.heightPanel = (int)sizeScreen.height-230;
        this.setPreferredSize(new Dimension(widthPanel,heightPanel ));
        this.panelCentred = parent;
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.initialize();
    }

    private void initialize()
    {
        this.elements = new ArrayList<Elements>();
        this.removed = new Stack<Elements>();
        this.group = 1;
        this.currentColor = Color.black;
    }
    public void setSizePanel(int widthPanel,int heightPanel){this.setPreferredSize(new Dimension(widthPanel,heightPanel));}

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        if(canvas == null){
            canvas = new BufferedImage(sizeScreen.width-100, sizeScreen.height-230,BufferedImage.TYPE_INT_ARGB);
            graphics2D = canvas.createGraphics();
            graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        }
        g.drawImage(canvas, 0, 0, this.getBackground(),null);
        Graphics2D g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for(Elements f : elements) {
            if(f.getShape() != BUCKET_TOOL)
            {
                g.setColor(f.getColor());
                g2.setStroke(f.getStroke());
            }

            if (f.getShape() == PENCIL_TOOL) {
                g.drawLine(f.getx1(), f.gety1(), f.getx2(), f.gety2());

            }
            else if (f.getShape() == LINE) {
                g.drawLine(f.getx1(), f.gety1(), f.getx2(), f.gety2());

            }
            else if(f.getShape() == RECTANGLE)
            {
                g.drawRect(f.getx1(),f.gety1(),f.getx2(),f.gety2());
            }
            else if(f.getShape() == CIRCLE)
            {
                g.drawOval(f.getx1(),f.gety1(),f.getx2(),f.gety2());
            }
            else if(f.getShape() == BUCKET_TOOL)
            {
                this.setBackground(f.getfillColor());
            }
            else if(f.getShape() == TRIANGLE)
            {
                int[] x = { f.getx1(),f.getx2(),f.getx3()};
                int[] y = {f.gety1(),f.gety2(),f.gety3() };
                Polygon p = new Polygon(x, y, 3);
                g.drawPolygon(p);
            }
        }


        if(abstarct == true)
        {
            if(panelCentred.getActivatedTool() == LINE)
            {
                g.setColor(this.getCurrentColor());
                g.drawLine(x1,y1,x2,y2);
            }
            else if(panelCentred.getActivatedTool() == RECTANGLE)
            {
                int px = Math.min(x1,x2);
                int py = Math.min(y1,y2);
                int pw=Math.abs(x1-x2);
                int ph=Math.abs(y1-y2);
                g.setColor(this.getCurrentColor());
                g.drawRect(px, py, pw, ph);
            }
            else if(panelCentred.getActivatedTool() == CIRCLE)
            {
                int px = Math.min(x1,x2);
                int py = Math.min(y1,y2);
                int pw=Math.abs(x1-x2);
                int ph=Math.abs(y1-y2);
                g.setColor(this.getCurrentColor());
                g.drawOval(px, py, pw, ph);
            }
            else if(panelCentred.getActivatedTool() == TRIANGLE)
            {
                int x3 = x2;
                int y3 = y2;
                int xx1 = Math.abs((x1+x2)/2);
                g.setColor(this.getCurrentColor());
                Polygon p = new Polygon(new int[] { x1,xx1,x3 }, new int[] {y2,y1,y3}, 3);
                g.drawPolygon(p);

            }
        }

    }

    public void setCurrentColor(Color newColor) { this.currentColor = newColor;
        graphics2D.setColor(newColor);}

    public Color getCurrentColor(){return this.currentColor;}

    @Override
    public void mouseDragged(MouseEvent e) {

        Color primary = this.getCurrentColor();

        x2 = e.getX();
        y2 = e.getY();
        dragged = true;

        if (panelCentred.getActivatedTool() == PENCIL_TOOL) {
            repaint();
            elements.add(new Elements(x1, y1, x2, y2,primary,stroke,1,group));
            repaint();
            x1 = x2;
            y1 = y2;
        }
        if (panelCentred.getActivatedTool() == ERASER_TOOL){
            elements.add(new Elements(x1, y1, x2, y2,Color.white,new BasicStroke((float) 10),1,group));
            repaint();
            x1 = x2;
            y1 = y2;
        }
        else if (panelCentred.getActivatedTool()== LINE) {
            abstarct = true;
            repaint();
        }
        if (panelCentred.getActivatedTool() == RECTANGLE) {
            abstarct = true;
            repaint();
        }
        if (panelCentred.getActivatedTool() == CIRCLE) {
            abstarct = true;
            repaint();
        }
        if (panelCentred.getActivatedTool() == TRIANGLE) {
            abstarct = true;
            repaint();
        }
    }


    @Override
    public void mouseMoved(MouseEvent e) {


    }

    @Override
    public void mouseClicked(MouseEvent e) {



        Color primary = this.getCurrentColor();

        if (panelCentred.getActivatedTool() == BUCKET_TOOL) {
            repaint();
        }


    }

    @Override
    public void mouseEntered(MouseEvent e) {


    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {


        x1 = x2 = e.getX();
        y1 = y2 = e.getY();

        Color primary = this.getCurrentColor();

        if (panelCentred.getActivatedTool() == BUCKET_TOOL) {
            elements.add(new Elements(primary,4));
            this.setBackground(primary);
            repaint();
        }
        else if (panelCentred.getActivatedTool()== LINE) {
            abstarct = true;
            repaint();
        }
        else if (panelCentred.getActivatedTool() == RECTANGLE) {
            abstarct = true;
            repaint();
        }
        else if (panelCentred.getActivatedTool() == CIRCLE) {
            abstarct = true;
            repaint();
        }
        else if (panelCentred.getActivatedTool() == TRIANGLE) {
            abstarct = true;
            repaint();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

        group++;
        Color primary = this.getCurrentColor();
        abstarct = false;


        if (panelCentred.getActivatedTool() == RECTANGLE && dragged) {

           draw_Rectangle(x1, y1, x2, y2,primary,stroke,5);
        }
      if (panelCentred.getActivatedTool() == CIRCLE && dragged) {

            draw_Circle(x1,y1,x2,y2,primary,stroke,6);
        }
       else if (panelCentred.getActivatedTool() == TRIANGLE && dragged) {
           draw_Triangel(x1,y1,x2,y2,primary,stroke,7);
       }
        else if (panelCentred.getActivatedTool() == LINE && dragged) {

            x2 = e.getX();
            y2 = e.getY();
            draw_line(x1, y1, x2, y2,primary,stroke,8);

        }
        dragged = false;

    }

    public void draw_line(int x1,int y1,int x2,int y2,Color color,BasicStroke stroke,int shape)
    {
        elements.add(new Elements(x1, y1, x2, y2,color,stroke,shape));
        repaint();
    }
    public void draw_Rectangle(int x1,int y1,int x2,int y2,Color color,BasicStroke stroke,int shape)
    {
        int px = Math.min(x1,x2);
        int py = Math.min(y1,y2);
        int pw=Math.abs(x1-x2);
        int ph=Math.abs(y1-y2);
        elements.add(new Elements(px, py, pw, ph,color,stroke,shape));
        repaint();
    }
    public void draw_Circle(int x1,int y1,int x2,int y2,Color color,BasicStroke stroke,int shape)
    {
        int px = Math.min(x1,x2);
        int py = Math.min(y1,y2);
        int pw=Math.abs(x1-x2);
        int ph=Math.abs(y1-y2);
        elements.add(new Elements(px, py, pw, ph,color,stroke,shape));
        repaint();
    }
    public void draw_Triangel(int x1,int y1,int x2,int y2,Color color,BasicStroke stroke,int shape)
    {
        int x3 = x2;
        int y3 = y2;
        int xx1 = Math.abs((x1+x2)/2);
        elements.add(new Elements(x1,y2,xx1,y1,x3,y3,color,stroke,shape));
        repaint();
    }
    public void setImage(BufferedImage image) {
        graphics2D.dispose();
        this.setSizePanel(image.getWidth(),image.getHeight());
        canvas = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
        graphics2D = canvas.createGraphics();
        graphics2D.drawImage(image, 0, 0, null);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    public void undo()
    {
        int position =  elements.size()-1;
        if(position > 0){
        this.removed.add(elements.get(position));
        this.elements.remove(elements.get(position));
        repaint();}
    }
    public void redo()
    {
        if(removed.size() != 0)
        {
            int position =  removed.size()-1;
            this.elements.add(removed.get(position));
            this.removed.remove(removed.get(position));
            repaint();
        }
    }
    public void clearPanel(){
        this.setBackground(Color.white);
        elements.removeAll(elements);
        removed.removeAllElements();
        repaint();
    }
}
