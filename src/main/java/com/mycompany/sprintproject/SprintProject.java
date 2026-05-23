/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sprintproject;

import static com.raylib.Raylib.*;
import static com.raylib.Colors.*;

/**
 *
 * @author sebastian
 */
public class SprintProject
{
    public static void main(String[] args)
    {
        int screenWidth = 720;
        int screenHeight = 960;
        InitWindow(screenWidth, screenHeight, "Sprint project");
        SetTargetFPS(60);
        Player player = new Player(350, 800, 80, 50, 6, 10, SKYBLUE, GREEN);
        Enemy boss = new Enemy(310, 50, 10, 5, 100, 100, GRAY);
        while(!WindowShouldClose())
        {
            // Aqui va toda la logica del game loop
            player.move();
            player.keepOnBounds(screenWidth, screenHeight);
            player.hitboxFollow();
            boss.move();
            boss.keepOnBounds(screenWidth, screenHeight);
            BeginDrawing();
            ClearBackground(RAYWHITE);
            boss.draw();
            player.draw();
            EndDrawing();
        }
        CloseWindow();
    }
}
