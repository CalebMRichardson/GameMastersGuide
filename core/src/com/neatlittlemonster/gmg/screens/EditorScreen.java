package com.neatlittlemonster.gmg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.neatlittlemonster.gmg.gmghelpers.GMGHelper;
import com.neatlittlemonster.gmg.world.Renderer;
import com.neatlittlemonster.gmg.world.World;

public class EditorScreen implements Screen {

    private static final String TAG = "EditorScreen";

    private World world;
    private Renderer renderer;

    public EditorScreen() {
        Gdx.app.log(TAG, "created.");

        world = new World();
        renderer = new Renderer();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float dt) {
        world.update(dt);
        renderer.render(dt);
    }

    @Override
    public void resize(int width, int height) {
        renderer.resize(width, height);

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        renderer.dispose();
    }
}