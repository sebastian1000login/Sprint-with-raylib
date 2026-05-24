/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<<< HEAD:src/main/java/com/mycompany/sprintproject/Model/Gameplay/Boss.java
package com.mycompany.sprintproject.Model.Gameplay;
========
package com.mycompany.sprintproject.Model;
>>>>>>>> main:src/main/java/com/mycompany/sprintproject/Model/Boss.java

import com.raylib.Raylib;

/**
 *
 * @author sebastian
 */
public class Boss extends Enemy {

    public Boss(float x, float y, float speedx, float speedy, int width, int height, int hp, Raylib.Color color) {
        super(x, y, speedx, speedy, width, height, hp, color);
    }

    public void keepOnBounds(int screenWidth, int screenHeight) {
        if (this.enm.x() < 0 || this.enm.x() > screenWidth - this.enm.width()) {
            this.speedx = -this.speedx;
        }
        if (this.enm.y() < 0 || this.enm.y() > (screenHeight * 0.25) - this.enm.height()) {
            this.speedy = -this.speedy;
        }
    }
}
