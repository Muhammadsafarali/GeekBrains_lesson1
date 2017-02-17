package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import org.w3c.dom.css.Rect;

import java.util.Vector;

/**
 * Created by safarali.alisultanov on 13.02.2017.
 */
public class Hero {

    private final String ship = "ship.png";
    private static Texture texture;
    private float speed;
    private Vector2 position;
    private int fireRate;
    private int fireCounter;
    private Rectangle rect;

    public Hero() {
        texture = new Texture(ship);
        speed = 10.0f;
        position = new Vector2(100, 100);
        fireRate = 6;
        fireCounter = 0;
        rect = new Rectangle(position.x, position.y, 80, 60);
    }

    public Rectangle getRect(){
        return rect;
    }

    public void render(SpriteBatch batch) {
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
        if (Gdx.input.isKeyPressed(Input.Keys.P)) {
            fireCounter++;
            if (fireCounter > fireRate) {
                fireCounter = 0;
                fire();
            }
        }
        rect.x = position.x;
        rect.y = position.y;
    }

    public void fire() {
        for (int i = 0; i < MyGdxGame.bullets.length; i++) {
            if (!MyGdxGame.bullets[i].isActive()) {
                MyGdxGame.bullets[i].setup(position.x+60, position.y+28 );
                break;
            }
        }
    }

}
