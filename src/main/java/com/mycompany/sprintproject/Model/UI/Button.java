package com.mycompany.sprintproject.Model.UI;

import static com.raylib.Raylib.*;
import static com.raylib.Colors.*;

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

    private boolean hovered = false;

    public boolean isHovered() {
        return this.hovered;
    }

    public void setHovered(boolean hovered) {
        this.hovered = hovered;
    }

    public void init() {
        this.button = new Rectangle().x(x).y(y).width(width).height(height);
    }

    public void draw() {
        if (this.button == null) {
            init();
        }

        // Draw background
        Color drawBgColor = this.background;
        if (this.cornerRadius > 0) {
            DrawRectangleRounded(this.button, this.cornerRadius, 8, drawBgColor);
        } else {
            DrawRectangleRec(this.button, drawBgColor);
        }

        // Draw outline / border
        if (this.stroke > 0) {
            if (this.cornerRadius > 0) {
                DrawRectangleRoundedLines(this.button, this.cornerRadius, 8, this.foreground);
            } else {
                DrawRectangleLinesEx(this.button, this.stroke, this.foreground);
            }
        }

        // Draw premium hover outline effect
        if (this.hovered) {
            Rectangle hoverRect = new Rectangle()
                .x(this.button.x() - 3)
                .y(this.button.y() - 3)
                .width(this.button.width() + 6)
                .height(this.button.height() + 6);
            if (this.cornerRadius > 0) {
                DrawRectangleRoundedLines(hoverRect, this.cornerRadius, 8, this.foreground);
            } else {
                DrawRectangleLinesEx(hoverRect, 2, this.foreground);
            }
        }

        // Draw centered text
        if (this.text != null) {
            int textWidth = MeasureText(this.text.getText(), this.text.getFontSize());
            int textX = this.x + (this.width - textWidth) / 2;
            int textY = this.y + (this.height - this.text.getFontSize()) / 2;
            this.text.setX(textX);
            this.text.setY(textY);
            this.text.draw();
        }
    }

}
