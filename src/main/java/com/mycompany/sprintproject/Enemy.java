/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sprintproject;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

/**
 *
 * @author sebastian
 */
public class Enemy implements Shape
{
    Rectangle enm;
    float speedx;
    float speedy;
    int hp = 1000;
    Color color;
    float lastUpdate = (float) GetTime();
    float pattern1Timer = (float) .8;
    boolean collisiones = false;
    public Enemy(float x, float y, float speedx, float speedy, int width, int height, Color color)
    {
        this.enm = new Rectangle().x(x).y(y).height(height).width(width);
        this.speedx = speedx;
        this.speedy = speedy;
        this.color = color;
    }
    
    @Override
    public void move()
    {
        double delta = GetFrameTime() * 6.0;
        this.enm = this.enm.x((float) (this.enm.x() + (delta * this.speedx)));
        this.enm = this.enm.y((float) (this.enm.y() + (delta * this.speedy)));
    }
    
    @Override
    public void draw()
    {
        DrawRectangleRec(this.enm, this.color);
    }
    
    public void keepOnBounds(int screenWidth, int screenHeight)
    {
        if (this.enm.x() < 0 || this.enm.x() > screenWidth - this.enm.width())
        {
            this.speedx = -this.speedx;
        }
        if (this.enm.y() < 0 || this.enm.y() > (screenHeight * 0.25) - this.enm.height())
        {
            this.speedy = -this.speedy;
        }
    }
}
