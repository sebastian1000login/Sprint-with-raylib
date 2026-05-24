package com.mycompany.sprintproject.Controllers;

import com.mycompany.sprintproject.Model.Scene;

/**
 *
 * @author alexis
 */
public abstract class SceneController {

    protected Scene sceneManager;

    public SceneController(Scene sceneManager) {
        this.sceneManager = sceneManager;
    }

    public abstract void init();

    public abstract void update();

    public abstract void draw();

    public void cleanup() {

    }

}
