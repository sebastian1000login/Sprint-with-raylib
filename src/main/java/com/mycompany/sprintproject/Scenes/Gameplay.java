package com.mycompany.sprintproject.Scenes;

import static com.raylib.Colors.GREEN;
import static com.raylib.Colors.LIGHTGRAY;
import static com.raylib.Colors.RAYWHITE;
import static com.raylib.Colors.SKYBLUE;
import static com.raylib.Raylib.*;

import com.mycompany.sprintproject.Controllers.SceneController;
import com.mycompany.sprintproject.Model.Scene;
import com.mycompany.sprintproject.Model.Gameplay.Player;

public class Gameplay extends SceneController {

    private Player player;

    public Gameplay(Scene sceneManager) {
        super(sceneManager);
    }

    @Override
    public void init() {
        this.player = new Player(350, 800, 80, 50, 6, 10, SKYBLUE, GREEN);
    }

    @Override
    public void update() {
        player.move();
        player.hitboxFollow();
        player.keepOnBounds(GetScreenWidth(), GetScreenHeight());
    }

    @Override
    public void draw() {
        ClearBackground(RAYWHITE);
        DrawText("Aqui va todo relacionado al drawing", 50, 500, 36, LIGHTGRAY);
        player.draw();
    }
}
