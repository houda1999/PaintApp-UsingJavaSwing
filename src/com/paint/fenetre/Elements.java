package com.paint.fenetre;

import java.awt.*;

public class Elements {

    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int x3;
    private int y3;

    private Color color;
    private Color fillColor;
    private BasicStroke stroke;
    private String message;


    public boolean transparent;

    private int shape;
    private Font font;

    public int group = 0;


    public Elements(int x1, int y1,int x2, int y2, Color color1,BasicStroke stroke, int shape,Color fill,boolean transparent){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color1;
        this.stroke = stroke;
        this.shape = shape;
        this.group = 0;
        this.fillColor = fill;
        this.transparent = transparent;
    }
    public Elements(int x1, int y1,int x2, int y2, Color color1,BasicStroke stroke, int shape,int group){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.color = color1;
        this.stroke = stroke;
        this.shape = shape;
        this.group = group;

    }
    public Elements(int x1, int y1, int x2, int y2, Color primary, BasicStroke stroke, int shape){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.stroke = stroke;
        this.shape = shape ;
        this.color = primary;

    }
    public Elements(int x1, int y1, int x2, int y2,int x3, int y3, Color primary, BasicStroke stroke, int shape){
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.stroke = stroke;
        this.shape = shape ;
        this.color = primary;

    }
    public Elements(Color fillColor, int shape)
    {
        this.fillColor = fillColor;
        this.shape = shape;
    }


    public int getShape(){
        return this.shape;
    }
    public String getMessage() {
        return this.message;
    }
    public Font getFont() {
        return this.font;
    }
    public int getx1(){
        return this.x1;
    }
    public int getx2(){
        return this.x2;
    }
    public int getx3(){
        return this.x3;
    }
    public int gety1(){
        return this.y1;
    }
    public int gety2(){
        return this.y2;
    }
    public int gety3(){
        return this.y3;
    }
    public Color getColor(){
        return this.color;
    }
    public void setColor(Color newColor){
        this.color = newColor;
    }
    public Color getfillColor(){
        return this.fillColor;
    }
    public BasicStroke getStroke(){
        return this.stroke;
    }
    public boolean getTransparency(){
        return this.transparent;
    }

    public int getGroup(){
        return this.group;
    }
}
