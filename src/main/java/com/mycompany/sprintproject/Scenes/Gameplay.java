package com.mycompany.sprintproject.Scenes;

import com.mycompany.sprintproject.Controllers.BossController;
import com.mycompany.sprintproject.Controllers.PlayerController;
import static com.raylib.Colors.GREEN;
import static com.raylib.Colors.LIGHTGRAY;
import static com.raylib.Colors.RAYWHITE;
import static com.raylib.Colors.SKYBLUE;
import static com.raylib.Raylib.*;

import com.mycompany.sprintproject.Controllers.SceneController;
import com.mycompany.sprintproject.Model.Scene;
import static com.raylib.Colors.GRAY;
import com.raylib.Raylib.Sound;

public class Gameplay extends SceneController {

    private PlayerController playerController;
    private BossController bossController;

    Sound bgm = LoadSound("Utils/Sounds/BGM/Stage1.wav");

    public Gameplay(Scene sceneManager) {
        super(sceneManager);
    }

    @Override
    public void init()
    {
        playerController = new PlayerController();
        bossController = new BossController();
        playerController.createPlayer(350, 800, 80, 50, 6, 10, SKYBLUE, GREEN);
        bossController.createBoss(310, -150, 15, 10, 100, 100, 100, GRAY);
        PlaySound(bgm);
    }

    @Override
    public void update() {
        playerController.movePlayer();
        bossController.bossCycle();
    }

    @Override
    public void draw() {
        ClearBackground(RAYWHITE);
        bossController.drawBoss();
        playerController.drawPlayer();
    }

    @Override
    public void cleanup() {
        StopSound(bgm);
        UnloadSound(bgm);
    }
}
