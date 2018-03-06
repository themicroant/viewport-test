package com.demo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

public class ViewportTest extends ApplicationAdapter {
	OrthographicCamera camera;

	private TiledMap tiledMap;
	private TiledMapRenderer tiledMapRenderer;

	OrthographicCamera camera2;
	private TiledMap tiledMap2;
	private TiledMapRenderer tiledMapRenderer2;
	@Override
	public void create () {

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 5,16 );

		tiledMap = new TmxMapLoader().load("data/icy_shore.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1.0f / 32);

		float width = camera.viewportWidth;
		float height = camera.viewportHeight;
		tiledMapRenderer.setView(camera.combined, 1, 1, 3, 4);

		tiledMap2 = new TmxMapLoader().load("data/grassy_shore.tmx");
		tiledMapRenderer2 = new OrthogonalTiledMapRenderer(tiledMap, 1.0f / 32);
		tiledMapRenderer2.setView(camera.combined, 1, 8, 3, 4);
	}

	@Override
	public void render () {
		camera.update();
		//camera2.update();
		Gdx.gl.glClearColor(0, 0, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		tiledMapRenderer.render();
		tiledMapRenderer2.render();
	}
}