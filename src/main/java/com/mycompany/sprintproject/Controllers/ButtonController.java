package com.mycompany.sprintproject.Controllers;

import com.mycompany.sprintproject.Model.UI.Button;

public abstract class ButtonController
{
    private Button button;

    public ButtonController(Button button)
    {
        this.button = button;
    }

    public abstract boolean onClick();

    public abstract boolean onHover();

    public abstract boolean onLeave();

}
