package com.mycompany.sprintproject.Scenes;

import static com.raylib.Colors.*;
import static com.raylib.Raylib.*;

import com.mycompany.sprintproject.Controllers.ButtonController;
import com.mycompany.sprintproject.Controllers.SceneController;
import com.mycompany.sprintproject.Model.Scene;
import com.mycompany.sprintproject.Model.UI.Button;
import com.mycompany.sprintproject.Model.UI.Label;
import com.raylib.Raylib.Sound;

public class MainMenu extends SceneController {

    private ButtonController playController;
    private ButtonController exitController;

    Sound bgm = LoadSound("Utils/Sounds/BGM/noOfficialMain.mp3");

    public MainMenu(Scene sceneManager) {
        super(sceneManager);
    }

    @Override
    public void init() {
        int screenWidth = 720;
        int btnWidth = 260;
        int btnHeight = 60;
        int btnX = (screenWidth - btnWidth) / 2;

        PlaySound(bgm);
        // --- PLAY BUTTON ---
        Button playBtn = new Button(btnWidth, btnHeight, btnX, 400, DARKGRAY, WHITE);
        playBtn.setStroke(3);
        playBtn.setCornerRadius(0.12f);

        Label playLbl = new Label();
        playLbl.setText("PLAY");
        playLbl.setFontSize(28);
        playLbl.setTextColor(WHITE);
        playBtn.setText(playLbl);
        playBtn.init();

        this.playController = new ButtonController(playBtn) {
            @Override
            public boolean onClick() {
                StopSound(bgm);
                UnloadSound(bgm);
                sceneManager.switchScene(new Gameplay(sceneManager));
                return true;
            }

            @Override
            public boolean onHover() {
                getButton().setBackground(SKYBLUE);
                getButton().getText().setTextColor(BLACK);
                return true;
            }

            @Override
            public boolean onLeave() {
                getButton().setBackground(DARKGRAY);
                getButton().getText().setTextColor(WHITE);
                return true;
            }
        };

        // --- EXIT BUTTON ---
        Button exitBtn = new Button(btnWidth, btnHeight, btnX, 500, DARKGRAY, WHITE);
        exitBtn.setStroke(3);
        exitBtn.setCornerRadius(0.12f);

        Label exitLbl = new Label();
        exitLbl.setText("EXIT");
        exitLbl.setFontSize(28);
        exitLbl.setTextColor(WHITE);
        exitBtn.setText(exitLbl);
        exitBtn.init();

        this.exitController = new ButtonController(exitBtn) {
            @Override
            public boolean onClick() {
                System.exit(0);
                UnloadSound(bgm);
                return true;
            }

            @Override
            public boolean onHover() {
                getButton().setBackground(RED);
                getButton().getText().setTextColor(WHITE);
                return true;
            }

            @Override
            public boolean onLeave() {
                getButton().setBackground(DARKGRAY);
                getButton().getText().setTextColor(WHITE);
                return true;
            }
        };
    }

    @Override
    public void update() {
        if (playController != null) {
            playController.update();
        }
        if (exitController != null) {
            exitController.update();
        }
    }

    @Override
    public void draw() {
        ClearBackground(BLACK);

        // Draw Main Title
        int titleWidth = MeasureText("SPRINT PROJECT", 54);
        DrawText("SPRINT PROJECT", (720 - titleWidth) / 2, 200, 54, SKYBLUE);

        // Draw Buttons
        if (playController != null && playController.getButton() != null) {
            playController.getButton().draw();
        }
        if (exitController != null && exitController.getButton() != null) {
            exitController.getButton().draw();
        }
    }
}
