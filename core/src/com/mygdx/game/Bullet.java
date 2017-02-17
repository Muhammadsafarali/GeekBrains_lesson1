package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by root on 13.02.2017.
 */
public class Bullet {
    private Vector2 position;
    private float speed;
    private boolean active;

    public Vector2 getPosition() {
        return position;
    }

    public boolean isActive() {
        return active;
    }

    public Bullet() {
        this.position = new Vector2(0, 0);
        this.speed = 16.0f;
        this.active = false;
    }

    public void setup(float x, float y) {
        position.x = x;
        position.y = y;
        active = true;
    }

    public void disable() {
        active = false;
    }

    public void update() {
        position.x += speed;
        if (position.x > 900) {
            disable();
        }
    }

}

