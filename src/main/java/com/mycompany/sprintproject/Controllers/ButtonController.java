package com.mycompany.sprintproject.Controllers;

import static com.raylib.Raylib.*;
import com.mycompany.sprintproject.Model.UI.Button;

public abstract class ButtonController
{
    private Button button;
    private boolean isHovered = false;

    public ButtonController(Button button)
    {
        this.button = button;
    }

    public Button getButton() {
        return this.button;
    }

    public abstract boolean onClick();

    public abstract boolean onHover();

    public abstract boolean onLeave();

    public void update() {
        if (this.button == null) {
            return;
        }

        com.raylib.Raylib.Rectangle rect = this.button.getButton();
        if (rect == null) {
            this.button.init();
            rect = this.button.getButton();
        }

        float mouseX = GetMouseX();
        float mouseY = GetMouseY();

        boolean currentHover = (mouseX >= rect.x() && mouseX <= rect.x() + rect.width() &&
                                mouseY >= rect.y() && mouseY <= rect.y() + rect.height());

        this.button.setHovered(currentHover);

        if (currentHover) {
            if (!this.isHovered) {
                this.isHovered = true;
                onHover();
            }

            // Left mouse button is 0 in Raylib
            if (IsMouseButtonPressed(0)) {
                onClick();
            }
        } else {
            if (this.isHovered) {
                this.isHovered = false;
                onLeave();
            }
        }
    }
}
