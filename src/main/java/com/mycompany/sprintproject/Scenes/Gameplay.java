package com.mycompany.sprintproject.Scenes;

import static com.raylib.Colors.GREEN;
import static com.raylib.Colors.LIGHTGRAY;
import static com.raylib.Colors.RAYWHITE;
import static com.raylib.Colors.SKYBLUE;
import static com.raylib.Raylib.*;

import com.mycompany.sprintproject.Controllers.SceneController;
import com.mycompany.sprintproject.Model.Input;
import com.mycompany.sprintproject.Model.Scene;
import com.mycompany.sprintproject.Model.Gameplay.Player;
import com.mycompany.sprintproject.Utils.AssetLoader;
import com.raylib.Raylib.Sound;

public class Gameplay extends SceneController {

    private Player player;

    Sound bgm = LoadSound(AssetLoader.getAssetPath("Utils/Sounds/BGM/Stage1.wav"));

    public Gameplay(Scene sceneManager, Input input) {
        super(sceneManager, input);
    }

    @Override
    public void init() {
        this.input.setCurrentActionMap(Input.ActionMap.GAMEPLAY);
        this.player = new Player(350, 800, 80, 50, 6, 10, SKYBLUE, GREEN, this.input);
        PlaySound(bgm);
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

    @Override
    public void cleanup() {
        StopSound(bgm);
        UnloadSound(bgm);
    }
}
