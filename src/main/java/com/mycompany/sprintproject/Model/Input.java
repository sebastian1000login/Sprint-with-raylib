package com.mycompany.sprintproject.Model;

public class Input {

    public enum ActionMap {
        UI,
        GAMEPLAY,
        EDITOR
    }

    private ActionMap currentActionMap = ActionMap.UI;

    // Acciones del mapeo UI
    private boolean ui_up;
    private boolean ui_down;
    private boolean ui_left;
    private boolean ui_right;
    private boolean ui_select;
    private boolean ui_back;

    // Acciones del mapeo GAMEPLAY
    private boolean gp_up;
    private boolean gp_down;
    private boolean gp_left;
    private boolean gp_right;
    private boolean gp_fire;
    private boolean gp_dash;

    // Acciones del mapeo EDITOR
    private boolean ed_up;
    private boolean ed_down;
    private boolean ed_left;
    private boolean ed_right;
    private boolean ed_select;
    private boolean ed_back;

    public ActionMap getCurrentActionMap() {
        return currentActionMap;
    }

    public void setCurrentActionMap(ActionMap currentActionMap) {
        this.currentActionMap = currentActionMap;
        resetInputs();
    }

    public void resetInputs() {
        this.ui_up = false;
        this.ui_down = false;
        this.ui_left = false;
        this.ui_right = false;
        this.ui_select = false;
        this.ui_back = false;

        this.gp_up = false;
        this.gp_down = false;
        this.gp_left = false;
        this.gp_right = false;
        this.gp_fire = false;
        this.gp_dash = false;

        this.ed_up = false;
        this.ed_down = false;
        this.ed_left = false;
        this.ed_right = false;
        this.ed_select = false;
        this.ed_back = false;
    }

    // Getters y Setters para UI
    public boolean isUiUp() { return ui_up; }
    public void setUiUp(boolean ui_up) { this.ui_up = ui_up; }

    public boolean isUiDown() { return ui_down; }
    public void setUiDown(boolean ui_down) { this.ui_down = ui_down; }

    public boolean isUiLeft() { return ui_left; }
    public void setUiLeft(boolean ui_left) { this.ui_left = ui_left; }

    public boolean isUiRight() { return ui_right; }
    public void setUiRight(boolean ui_right) { this.ui_right = ui_right; }

    public boolean isUiSelect() { return ui_select; }
    public void setUiSelect(boolean ui_select) { this.ui_select = ui_select; }

    public boolean isUiBack() { return ui_back; }
    public void setUiBack(boolean ui_back) { this.ui_back = ui_back; }

    // Getters y Setters para GAMEPLAY
    public boolean isGpUp() { return gp_up; }
    public void setGpUp(boolean gp_up) { this.gp_up = gp_up; }

    public boolean isGpDown() { return gp_down; }
    public void setGpDown(boolean gp_down) { this.gp_down = gp_down; }

    public boolean isGpLeft() { return gp_left; }
    public void setGpLeft(boolean gp_left) { this.gp_left = gp_left; }

    public boolean isGpRight() { return gp_right; }
    public void setGpRight(boolean gp_right) { this.gp_right = gp_right; }

    public boolean isGpFire() { return gp_fire; }
    public void setGpFire(boolean gp_fire) { this.gp_fire = gp_fire; }

    public boolean isGpDash() { return gp_dash; }
    public void setGpDash(boolean gp_dash) { this.gp_dash = gp_dash; }

    // Getters y Setters para EDITOR
    public boolean isEdUp() { return ed_up; }
    public void setEdUp(boolean ed_up) { this.ed_up = ed_up; }

    public boolean isEdDown() { return ed_down; }
    public void setEdDown(boolean ed_down) { this.ed_down = ed_down; }

    public boolean isEdLeft() { return ed_left; }
    public void setEdLeft(boolean ed_left) { this.ed_left = ed_left; }

    public boolean isEdRight() { return ed_right; }
    public void setEdRight(boolean ed_right) { this.ed_right = ed_right; }

    public boolean isEdSelect() { return ed_select; }
    public void setEdSelect(boolean ed_select) { this.ed_select = ed_select; }

    public boolean isEdBack() { return ed_back; }
    public void setEdBack(boolean ed_back) { this.ed_back = ed_back; }
}
