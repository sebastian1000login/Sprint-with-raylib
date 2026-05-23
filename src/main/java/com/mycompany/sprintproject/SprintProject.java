/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sprintproject;

import static com.raylib.Raylib.*;
import com.mycompany.sprintproject.Model.Scene;
import com.mycompany.sprintproject.Scenes.Gameplay;

/**
 *
 * @author sebastian
 */
public class SprintProject {
    public static void main(String[] args) {
        int screenWidth = 720;
        int screenHeight = 960;
        InitWindow(screenWidth, screenHeight, "Sprint project");
        SetTargetFPS(60);

        Scene sceneManager = new Scene();
        sceneManager.switchScene(new Gameplay(sceneManager, screenWidth, screenHeight));
        while (!WindowShouldClose()) {
            // Aqui va toda la logica del game loop
            sceneManager.update();
            sceneManager.draw();
            BeginDrawing();
            EndDrawing();
        }
        CloseWindow();
    }
}
