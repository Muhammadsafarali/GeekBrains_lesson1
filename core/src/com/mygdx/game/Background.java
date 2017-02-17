package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by safarali.alisultanov on 13.02.2017.
 */
public class Background {

    private final String space = "space1.png";
<<<<<<< HEAD
    private static Texture texture;
    private Vector2 position;
=======
    Texture texture;
    Vector2 position;
>>>>>>> ea9e0533e24bd14542e07c30e7a9e2e7531c1e39

    public Background() {
        texture = new Texture(space);
        position = new Vector2(0, 0);
    }

    public void render(SpriteBatch batch) {
<<<<<<< HEAD
=======
        update();
>>>>>>> ea9e0533e24bd14542e07c30e7a9e2e7531c1e39
        batch.draw(texture, position.x, position.y);
        batch.draw(texture, 900+position.x, position.y);
    }

    public void update() {
        position.x -= 1.0f;
        if (position.x+900 < 0) {
            position.x = 0;
        }
    }

}
