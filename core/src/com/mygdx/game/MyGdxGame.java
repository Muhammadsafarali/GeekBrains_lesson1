package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private final String bullet = "bullet.png";
	SpriteBatch batch;
	Background background;
	Hero hero;
	Asteroid[] asteroids;
	public static Bullet[] bullets;
	Texture textureBullet;
	BitmapFont fnt;

	@Override
	public void create () {
		batch = new SpriteBatch();
		background = new Background();
		hero = new Hero();
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
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);
		hero.render(batch);
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
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
