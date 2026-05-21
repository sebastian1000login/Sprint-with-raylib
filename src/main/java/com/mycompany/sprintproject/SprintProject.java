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
        while(!WindowShouldClose())
        {
            // Aqui va toda la logica del game loop
            player.move();
            player.keepOnBounds();
            player.hitboxFollow();
            BeginDrawing();
            ClearBackground(RAYWHITE);
            DrawText("Aqui va todo relacionado al drawing", 100, 500, 36, LIGHTGRAY);
            player.draw();
            EndDrawing();
        }
        CloseWindow();
    }
}
