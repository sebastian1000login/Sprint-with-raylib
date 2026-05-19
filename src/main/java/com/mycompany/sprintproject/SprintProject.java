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
        int screenWidth = 750;
        int screenHeight = 1000;
        InitWindow(screenWidth, screenHeight, "Sprint project");
        SetTargetFPS(60);
        while(!WindowShouldClose())
        {
            // Aqui va toda la logica del game loop
            BeginDrawing();
            ClearBackground(RAYWHITE);
            DrawText("Aqui va todo relacionado al drawing", 100, 500, 36, LIGHTGRAY);
            EndDrawing();
        }
    }
}
