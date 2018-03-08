package com.demo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class ViewportTest extends ApplicationAdapter implements InputProcessor {
    SpriteBatch batch;
    OrthographicCamera camera;
    TiledMap tiledMap;
    TiledMapRenderer tiledMapRenderer;

    Viewport viewport;

    Stage stage;
    Texture texture;

    ScreenViewport screenViewport;

    OrthographicCamera camera2;

    @Override
    public void create() {
        int tilesWide = 9;
        int tilesHigh = 14;

        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, tilesWide, tilesHigh);

        tiledMap = new TmxMapLoader().load("data/icy_shore.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1.0f / 32, batch);

        viewport = new ScreenViewport();
        viewport.setScreenBounds(0, 183/3, Gdx.graphics.getWidth(), Gdx.graphics.getWidth() * tilesHigh / tilesWide);

        camera2 = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera2.setToOrtho(false,Gdx.graphics.getWidth(), Gdx.graphics.getHeight() );
        screenViewport = new ScreenViewport(camera2);
        stage = new Stage(screenViewport);
        texture = new Texture("data/buttons.png");

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {
        clearScreen();

        camera2.update();
        screenViewport.apply();
        batch.begin();
        batch.draw(texture,0,0, 9, 1);
        batch.end();

        camera.update();
        viewport.apply();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
    }

    private void clearScreen() {
        Gdx.gl.glClearColor(0, 0.5f, 0.5f, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        if (keycode == Input.Keys.LEFT)
            camera.translate(-1, 0);
        if (keycode == Input.Keys.RIGHT)
            camera.translate(1, 0);
        if (keycode == Input.Keys.DOWN)
            camera.translate(0, -1);
        if (keycode == Input.Keys.UP)
            camera.translate(0, 1);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}