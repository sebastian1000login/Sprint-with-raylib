/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<<< HEAD:src/main/java/com/mycompany/sprintproject/Model/Gameplay/NormalEnm.java
package com.mycompany.sprintproject.Model.Gameplay;
========
package com.mycompany.sprintproject.Model;
>>>>>>>> main:src/main/java/com/mycompany/sprintproject/Model/NormalEnm.java

import com.raylib.Raylib;

/**
 *
 * @author sebastian
 */
public class NormalEnm extends Enemy {

    public NormalEnm(float x, float y, float speedx, float speedy, int width, int height, int hp, Raylib.Color color) {
        super(x, y, speedx, speedy, width, height, hp, color);
    }
}
