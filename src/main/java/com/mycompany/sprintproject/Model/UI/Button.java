package com.mycompany.sprintproject.Model.UI;

import static com.raylib.Raylib.Color;

import com.raylib.Raylib.Rectangle;

public class Button {
    private int width;

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    private int height;

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    private int x;

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    private int y;

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    private Rectangle button;

    public Rectangle getButton() {
        return this.button;
    }

    public void setButton(Rectangle button) {
        this.button = button;
    }

    private Color background;

    public Color getBackground() {
        return this.background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    private Color foreground;

    public Color getForeground() {
        return this.foreground;
    }

    public void setForeground(Color foreground) {
        this.foreground = foreground;
    }

    private int stroke;

    public int getStroke() {
        return this.stroke;
    }

    public void setStroke(int stroke) {
        this.stroke = stroke;
    }

    private float cornerRadius;

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public void setCornerRadius(float cornerRadius) {
        this.cornerRadius = cornerRadius;
    }

    private Label text;

    public Label getText() {
        return this.text;
    }

    public void setText(Label text) {
        this.text = text;
    }

    public Button(int width, int height, int x, int y, Color background, Color foreground) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.background = background;
        this.foreground = foreground;
    }

    public void init() {
        this.button = new Rectangle().x(x).y(y).width(width).height(height);
    }

}
