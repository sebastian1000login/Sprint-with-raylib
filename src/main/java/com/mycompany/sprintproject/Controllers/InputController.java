package com.mycompany.sprintproject.Controllers;

import static com.raylib.Raylib.*;
import com.mycompany.sprintproject.Model.Input;

public class InputController {

    private Input inputModel;

    public InputController(Input inputModel) {
        this.inputModel = inputModel;
    }

    public void switchActionMap(Input.ActionMap newMap) {
        if (inputModel != null) {
            inputModel.setCurrentActionMap(newMap);
        }
    }

    // Actualiza los estados de entrada en cada frame consultando a Raylib
    public void update() {
        if (inputModel == null) return;

        // Limpiar todas las entradas antes de actualizar las nuevas
        inputModel.resetInputs();

        // Registrar las teclas según el mapa activo
        switch (inputModel.getCurrentActionMap()) {
            case UI -> updateUIInput();
            case GAMEPLAY -> updateGameplayInput();
            case EDITOR -> updateEditorInput();
        }
    }

    private void updateUIInput() {
        inputModel.setUiUp(IsKeyDown(KEY_W) || IsKeyDown(KEY_UP));
        inputModel.setUiDown(IsKeyDown(KEY_S) || IsKeyDown(KEY_DOWN));
        inputModel.setUiLeft(IsKeyDown(KEY_A) || IsKeyDown(KEY_LEFT));
        inputModel.setUiRight(IsKeyDown(KEY_D) || IsKeyDown(KEY_RIGHT));
        inputModel.setUiSelect(IsKeyPressed(KEY_ENTER) || IsKeyPressed(KEY_SPACE));
        inputModel.setUiBack(IsKeyPressed(KEY_ESCAPE) || IsKeyPressed(KEY_BACKSPACE));
    }

    private void updateGameplayInput() {
        inputModel.setGpUp(IsKeyDown(KEY_W) || IsKeyDown(KEY_UP));
        inputModel.setGpDown(IsKeyDown(KEY_S) || IsKeyDown(KEY_DOWN));
        inputModel.setGpLeft(IsKeyDown(KEY_A) || IsKeyDown(KEY_LEFT));
        inputModel.setGpRight(IsKeyDown(KEY_D) || IsKeyDown(KEY_RIGHT));
        inputModel.setGpFire(IsKeyDown(KEY_J) || IsKeyDown(KEY_SPACE) || IsMouseButtonDown(MOUSE_BUTTON_LEFT));
        inputModel.setGpDash(IsKeyPressed(KEY_LEFT_SHIFT) || IsKeyPressed(KEY_K));
    }

    private void updateEditorInput() {
        inputModel.setEdUp(IsKeyDown(KEY_UP));
        inputModel.setEdDown(IsKeyDown(KEY_DOWN));
        inputModel.setEdLeft(IsKeyDown(KEY_LEFT));
        inputModel.setEdRight(IsKeyDown(KEY_RIGHT));
        inputModel.setEdSelect(IsMouseButtonPressed(MOUSE_BUTTON_LEFT));
        inputModel.setEdBack(IsKeyPressed(KEY_ESCAPE));
    }
}
