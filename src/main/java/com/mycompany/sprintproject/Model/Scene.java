package com.mycompany.sprintproject.Model;

import com.mycompany.sprintproject.Controllers.SceneController;
import com.mycompany.sprintproject.Scenes.MainMenu;

/**
 *
 * @author alexis
 */

public class Scene {

    private SceneController currentScene;
    private SceneController prevScene;

    private Input input;

    public Scene(Input input) {
        this.input = input;
    }

    // Getters tradicionales en Java
    public SceneController getCurrentScene() {
        return this.currentScene;
    }

    public SceneController getPrevScene() {
        return this.prevScene;
    }

    public void init() {
        this.currentScene = new MainMenu(this, input);
        this.currentScene.init();
    }

    // Cambia la escena activa e inicializa la nueva escena
    public void switchScene(SceneController newScene) {

        if (this.currentScene != null) {
            this.currentScene.cleanup();
        }

        this.prevScene = this.currentScene;
        this.currentScene = newScene;

        if (this.currentScene != null) {
            this.currentScene.init();
        }
    }

    // Delega la actualización a la escena activa
    public void update() {
        if (currentScene != null) {
            currentScene.update();
        }
    }

    // Delega el dibujo a la escena activa
    public void draw() {
        if (currentScene != null) {
            currentScene.draw();
        }
    }
}
