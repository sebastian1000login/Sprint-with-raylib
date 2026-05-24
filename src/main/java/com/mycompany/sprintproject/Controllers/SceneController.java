package com.mycompany.sprintproject.Controllers;

import com.mycompany.sprintproject.Model.Input;
import com.mycompany.sprintproject.Model.Scene;

/**
 *
 * @author alexis
 */
public abstract class SceneController {

    protected Scene sceneManager;

    protected Input input;

    public SceneController(Scene sceneManager, Input input) {
        this.sceneManager = sceneManager;
        this.input = input;
    }

    public abstract void init();

    public abstract void update();

    public abstract void draw();

    public abstract void cleanup();

}
