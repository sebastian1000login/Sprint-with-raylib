/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sprintproject.Controllers;

import com.mycompany.sprintproject.Model.Gameplay.Player;
import com.mycompany.sprintproject.Model.Input;
import com.raylib.Raylib;
import static com.raylib.Raylib.GetScreenHeight;
import static com.raylib.Raylib.GetScreenWidth;

/**
 *
 * @author sebastian
 */
public class PlayerController
{
    protected Player player;
    
    public void createPlayer(float x, float y, float speed, int size, int hitboxWidth, int hitboxHeight, Raylib.Color playerColor,
            Raylib.Color hitboxColor, Input input)
    {
        this.player = new Player(x, y, speed, size, hitboxWidth, hitboxHeight, playerColor, hitboxColor, input);
    }
    
    public void movePlayer()
    {
        this.player.move();
        this.player.keepOnBounds(GetScreenWidth(), GetScreenHeight());
        this.player.hitboxFollow();
    }
    
    public void drawPlayer()
    {
        this.player.draw();
    }
}
