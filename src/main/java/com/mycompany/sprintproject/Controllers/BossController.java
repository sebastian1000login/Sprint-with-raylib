/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sprintproject.Controllers;

import com.mycompany.sprintproject.Model.Gameplay.Boss;
import com.raylib.Raylib;
import static com.raylib.Raylib.GetScreenHeight;
import static com.raylib.Raylib.GetScreenWidth;

/**
 *
 * @author sebastian
 */
public class BossController
{
    protected Boss boss;
    protected boolean onPosition = false;
    
    public void createBoss(float x, float y, float speedx, float speedy, int width, int height, int hp, Raylib.Color color)
    {
        boss = new Boss(x, y, speedx, speedy, width, height, hp, color);
    }
    
    public void moveBoss()
    {
        boss.move();
        boss.keepOnBounds(GetScreenWidth(), GetScreenHeight());
    }
    
    public void bossAppearance()
    {
        if (boss.getBossY() < GetScreenHeight() * 0.1)
        {
            boss.appearanceMovement();
        }else
        {
            onPosition = true;
        }
    }
    
    public void bossCycle()
    {
        if (!onPosition)
        {
            bossAppearance();
        }else
        {
            moveBoss();
        }
    }
    
    public void drawBoss()
    {
        boss.draw();
    }
}
