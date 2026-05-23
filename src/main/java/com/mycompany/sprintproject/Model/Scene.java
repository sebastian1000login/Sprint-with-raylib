package com.mycompany.sprintproject.Model;

import com.mycompany.sprintproject.Controllers.SceneController;

/**
 *
 * @author alexis
 */

public class Scene {

    private SceneController currentScene;
    private SceneController prevScene;

    // Getters tradicionales en Java
    public SceneController getCurrentScene() {
        return this.currentScene;
    }

    public SceneController getPrevScene() {
        return this.prevScene;
    }

    // Cambia la escena activa e inicializa la nueva escena
    public void switchScene(SceneController newScene) {
        this.prevScene = this.currentScene;
        this.currentScene = newScene;

        if (this.currentScene != null) {
            this.currentScene.init();
        }
    }

    // Delega la actualización a la escena activa
    public void update() {
        if (currentScene != null) {
            currentScene.upd();
        }
    }

    // Delega el dibujo a la escena activa
    public void draw() {
        if (currentScene != null) {
            currentScene.drw();
        }
    }
}
