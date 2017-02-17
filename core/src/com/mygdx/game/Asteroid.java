package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import org.w3c.dom.css.Rect;

/**
 * Created by safarali.alisultanov on 13.02.2017.
 */
public class Asteroid {

    private final String asteroid = "asteroid.png";
    private static Texture texture;
    private Vector2 position;
    private float speed;
    private Rectangle rect;
    private float angle;
    private int hp;

    public Rectangle getRect() {
        return rect;
    }

    public Asteroid() {
        if (texture == null) {
            texture = new Texture(asteroid);
        }
        speed = 2.0f + (float)Math.random()*10.0f;
        position = new Vector2(900 +(float)Math.random()*900, (float)Math.random()*640);
        rect = new Rectangle(position.x, position.y, 32, 32);
        angle = (float)Math.random() * 360;
        hp = 1 + (int)(Math.random() + 10);
    }

    public void render(SpriteBatch batch) {
//        batch.draw(texture, position.x, position.y);
        float m = 0.4f + hp/10.0f;
        batch.draw(texture, position.x, position.y, 16, 16, 16, 16, m, m, angle, 0, 0, 16, 14 , false, false);
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        if (hp < 0) {
            recreate();
        }
    }

    public void recreate() {
        hp = 1 + (int)(Math.random() + 10);
        speed = 4.0f + (float)Math.random()*6;
        position.x = 900 + (float)Math.random()*900;
        position.y = (float)Math.random()*640;
    }

    public void update() {
        position.x -= speed;
        angle += speed/2;
        if (position.x < 0) {
            recreate();
        }
        rect.x = position.x;
        rect.y = position.y;
    }

}
