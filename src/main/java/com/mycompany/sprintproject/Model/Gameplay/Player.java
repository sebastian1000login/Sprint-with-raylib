package com.mycompany.sprintproject.Model.Gameplay;

import static com.raylib.Raylib.*;
import com.mycompany.sprintproject.Model.Input;

/**
 *
 * @author sebastian
 */
public class Player implements Shape {
    private Input input;
    float x;
    float y;
    float speed;
    int size;
    Rectangle hit;
    int hitboxWidth;
    int hitboxHeight;
    Color playerColor;
    Color hitboxColor;
    float lastUpdate = (float) GetTime();
    float fireTimer = (float) .1f;
    float invisUpdate = (float) GetTime();
    float invisTime = 5;
    int lives = 3;
    boolean invis = false;

    public Player(float x, float y, float speed, int size, int hitboxWidth, int hitboxHeight, Color playerColor,
            Color hitboxColor, Input input) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.size = size;
        this.hitboxWidth = hitboxWidth;
        this.hitboxHeight = hitboxHeight;
        this.playerColor = playerColor;
        this.hitboxColor = hitboxColor;
        this.input = input;
        this.hit = new Rectangle()
                .x((this.x + (this.size / 2)) - (this.hitboxWidth / 2))
                .y((this.y + (this.size / 2)) - (this.hitboxHeight / 2))
                .width((float) (hitboxWidth))
                .height((float) (hitboxHeight));
    }

    @Override
    public void move() {
        double delta = GetFrameTime() * 6.0 * this.speed;
        if (input.isGpUp()) {
            this.y -= delta;
        }
        if (input.isGpDown()) {
            this.y += delta;
        }
        if (input.isGpRight()) {
            this.x += delta;
        }
        if (input.isGpLeft()) {
            this.x -= delta;
        }
    }

    public void keepOnBounds(int screenWidth, int screenHeight) {
        if (this.x < 0) {
            this.x = 0;
        }
        if (this.x > screenWidth - this.size) {
            this.x = screenWidth - this.size;
        }
        if (this.y < 0) {
            this.y = 0;
        }
        if (this.y > screenHeight - this.size) {
            this.y = screenHeight - this.size;
        }
    }

    public void hitboxFollow() {
        hit.x((this.x + (this.size / 2)) - (this.hitboxWidth / 2));
        hit.y((this.y + (this.size / 2)) - (this.hitboxHeight / 2));
    }

    @Override
    public void draw() {
        DrawRectangle((int) (this.x), (int) (this.y), this.size, this.size, playerColor);
        DrawRectangleRec(this.hit, hitboxColor);
    }
}