package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by safarali.alisultanov on 13.02.2017.
 */
public class Asteroid {

    private final String asteroid = "asteroid.png";
    private Texture texture;
    private Vector2 position;
    private float speed;

    public Asteroid() {
        texture = new Texture(asteroid);
        speed = (float)(Math.random()*4 + Math.random()*6);
        position = new Vector2((float)Math.random()*900, (float)Math.random()*640);
    }

    public void render(SpriteBatch batch) {
        update();
        batch.draw(texture, position.x, position.y);
    }

    public void recreate() {
        speed = (float)(Math.random()*4 + Math.random()*6);
        position.x = (float)Math.random()*900;
        position.y = (float)Math.random()*640;
    }

    public void update() {
        position.x -= speed;
        if (position.x < 0) {
            recreate();
        }
    }

}
