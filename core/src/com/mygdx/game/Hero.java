package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

/**
 * Created by safarali.alisultanov on 13.02.2017.
 */
public class Hero {

    private final String ship = "ship.png";
    private Texture texture;
    private float speed;
    private Vector2 position;

    public Hero() {
        texture = new Texture(ship);
        speed = 10.0f;
        position = new Vector2(100, 100);
    }

    public void render(SpriteBatch batch) {
        update();
        batch.draw(texture, position.x, position.y);
    }

    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            position.y += speed;
            if (position.y > 640) {
                position.y = -64;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            position.y -= speed;
            if (position.y < -64) {
                position.y = 704;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            position.x -= speed;
            if (position.x < 0) {
                position.x = 0;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            position.x += speed;
            if (position.x > 836) {
                position.x = 836;
            }
        }
    }

}
