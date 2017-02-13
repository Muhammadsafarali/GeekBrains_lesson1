package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by safarali.alisultanov on 13.02.2017.
 */
public class Background {

    private final String space = "space1.png";
    Texture texture;
    Vector2 position;

    public Background() {
        texture = new Texture(space);
        position = new Vector2(0, 0);
    }

    public void render(SpriteBatch batch) {
        update();
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
