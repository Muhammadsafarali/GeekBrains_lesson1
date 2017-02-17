package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
<<<<<<< HEAD
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private final String bullet = "bullet.png";

=======
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
>>>>>>> ea9e0533e24bd14542e07c30e7a9e2e7531c1e39
	SpriteBatch batch;
	Background background;
	Hero hero;
	Asteroid[] asteroids;
<<<<<<< HEAD
	public static Bullet[] bullets;
	Texture textureBullet;
	BitmapFont fnt;
=======
>>>>>>> ea9e0533e24bd14542e07c30e7a9e2e7531c1e39

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		hero = new Hero();
<<<<<<< HEAD
		asteroids = new Asteroid[40];
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i] = new Asteroid();
		}
		bullets = new Bullet[200];
		for (int i = 0; i < bullets.length; i++) {
			bullets[i] = new Bullet();
		}
		textureBullet = new Texture(bullet);
		fnt = new BitmapFont();
=======
		asteroids = new Asteroid[20];
		for (int i = 0; i < 20; i++) {
			asteroids[i] = new Asteroid();
		}
>>>>>>> ea9e0533e24bd14542e07c30e7a9e2e7531c1e39
	}

	@Override
	public void render () {
<<<<<<< HEAD
		update();
=======
>>>>>>> ea9e0533e24bd14542e07c30e7a9e2e7531c1e39
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		hero.render(batch);
<<<<<<< HEAD
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i].render(batch);
		}
		for (int i = 0; i < bullets.length; i++) {
			if (bullets[i].isActive()) {
				batch.draw(textureBullet, bullets[i].getPosition().x, bullets[i].getPosition().y);
			}
		}
		fnt.draw(batch, "StarCommXIV: - The Game", 50, 50);
		batch.end();
	}

	public void update() {
		background.update();
		hero.update();
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i].update();
		}

		for (int i = 0; i < asteroids.length; i++) {
			if (hero.getRect().overlaps(asteroids[i].getRect())) {
				asteroids[i].takeDamage(1);
			}
		}

		for (int i = 0; i < bullets.length; i++) {
			if (bullets[i].isActive()) {
				bullets[i].update();
				for (int j = 0; j < asteroids.length; j++) {
					if (asteroids[j].getRect().contains(bullets[i].getPosition())) {
						bullets[i].disable();
						asteroids[j].takeDamage(1);
					}
				}
			}
		}
	}
=======
		for (int i = 0; i < 20; i++) {
			asteroids[i].render(batch);
		}
		batch.end();
	}
>>>>>>> ea9e0533e24bd14542e07c30e7a9e2e7531c1e39
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
