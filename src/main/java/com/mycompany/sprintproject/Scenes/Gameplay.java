package com.mycompany.sprintproject.Scenes;

import static com.raylib.Colors.GREEN;
import static com.raylib.Colors.LIGHTGRAY;
import static com.raylib.Colors.RAYWHITE;
import static com.raylib.Colors.SKYBLUE;
import static com.raylib.Raylib.*;

import com.mycompany.sprintproject.Controllers.SceneController;
import com.mycompany.sprintproject.Model.Player;
import com.mycompany.sprintproject.Model.Scene;

public class Gameplay extends SceneController {

    Player player = new Player(350, 800, 80, 50, 6, 10, SKYBLUE, GREEN);
    int screenWidth;
    int screenHeight;

    public Gameplay(Scene sceneManager, int screenWidth, int screenHeight) {
        super(sceneManager);
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    @Override
    public void init() {

    }

    @Override
    public void upd() {
        player.move();
        player.hitboxFollow();
        player.keepOnBounds(screenWidth, screenHeight);
    }

    @Override
    public void drw() {
        ClearBackground(RAYWHITE);
        DrawText("Aqui va todo relacionado al drawing", 50, 500, 36, LIGHTGRAY);
        player.draw();
    }
}
