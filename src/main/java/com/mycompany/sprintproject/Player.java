/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sprintproject;

import static com.raylib.Raylib.*;

/**
 *
 * @author sebastian
 */
public class Player implements Shape
{
    float x;
    float y;
    float speed;
    int size;
    Rectangle hit;
    int hitboxWidth;
    int hitboxHeight;
    Color playerColor;
    Color hitboxColor;
    float lastUpdate = (float) GetTime();
    float fireTimer = (float) .1;
    float invisUpdate = (float) GetTime();
    float invisTime = 5;
    int lives = 3;
    boolean invis = false;

    public Player(float x, float y, float speed, int size, int hitboxWidth, int hitboxHeight, Color playerColor, Color hitboxColor)
    {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.size = size;
        this.hitboxWidth = hitboxWidth;
        this.hitboxHeight = hitboxHeight;
        this.playerColor = playerColor;
        this.hitboxColor = hitboxColor;
        this.hit = new Rectangle().x((this.x + (this.size / 2)) - (this.hitboxWidth / 2)).y((this.y + (this.size / 2)) - (this.hitboxHeight / 2)).width((float)(hitboxWidth)).height((float) (hitboxHeight));
    }
    
    @Override
    public void move()
    {
        double delta = GetFrameTime() * 6.0 * this.speed;
        if (IsKeyDown(KEY_W) || IsKeyDown(KEY_UP))
        {
            this.y -= delta;
        }
        if (IsKeyDown(KEY_S) || IsKeyDown(KEY_DOWN))
        {
            this.y += delta;
        }
        if (IsKeyDown(KEY_D) || IsKeyDown(KEY_RIGHT))
        {
            this.x += delta;
        }
        if (IsKeyDown(KEY_A) || IsKeyDown(KEY_LEFT))
        {
            this.x -=delta;
        }
    }
    
    public void keepOnBounds(int screenWidth, int screenHeight)
    {
        if (this.x < 0)
        {
            this.x = 0;
        }
        if (this.x > screenWidth - this.size)
        {
            this.x = screenWidth - this.size;
        }
        if (this.y < 0)
        {
            this.y = 0;
        }
        if (this.y > screenHeight - this.size)
        {
            this.y = screenHeight - this.size;
        }
    }
    
    public void hitboxFollow()
    {
        hit.x((this.x + (this.size / 2)) - (this.hitboxWidth / 2));
        hit.y((this.y + (this.size / 2)) - (this.hitboxHeight / 2));
    }
    
    @Override
    public void draw()
    {
        DrawRectangle((int)(this.x), (int)(this.y), this.size, this.size, playerColor);
        DrawRectangleRec(this.hit, hitboxColor);
    }
}
