package com.mycompany.sprintproject.Model.UI;

import static com.raylib.Colors.*;
import com.raylib.Raylib.Color;
import static com.raylib.Raylib.*;

public class Label {
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

    private String text;

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private int fontSize;

    public int getFontSize() {
        return this.fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    private Color textColor;

    public Color getTextColor() {
        return this.textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }

    private Color backgroundColor;

    public Color getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Label() {
        this.width = 0;
        this.height = 0;
        this.x = 0;
        this.y = 0;
        this.text = "";
        this.fontSize = 20;
        this.textColor = BLACK;
        this.backgroundColor = WHITE;
    }

    public void init() {
    }

    public void update() {
    }

    public void draw() {
        if (this.text != null && !this.text.isEmpty()) {
            DrawText(this.text, this.x, this.y, this.fontSize, this.textColor);
        }
    }

}
