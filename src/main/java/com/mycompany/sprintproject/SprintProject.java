/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sprintproject;

import static com.raylib.Raylib.*;

import com.mycompany.sprintproject.Controllers.InputController;
import com.mycompany.sprintproject.Model.Input;
import com.mycompany.sprintproject.Model.Scene;
import com.mycompany.sprintproject.Scenes.Gameplay;

/**
 *
 * @author sebastian
 */
public class SprintProject {
    public static void main(String[] args) {
        Input input = new Input();

        InputController inputController = new InputController(input);

        int screenWidth = 720;
        int screenHeight = 960;

        InitWindow(screenWidth, screenHeight, "Sprint project");
        InitAudioDevice();
        SetTargetFPS(60);

        Scene sceneManager = new Scene(input);
        sceneManager.init();
        while (!WindowShouldClose()) {
            // Aqui va toda la logica del game loop
            inputController.update();
            sceneManager.update();
            BeginDrawing();
            sceneManager.draw();
            EndDrawing();
        }

        CloseAudioDevice();
        CloseWindow();
    }
}
