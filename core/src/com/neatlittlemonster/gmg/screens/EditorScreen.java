package com.neatlittlemonster.gmg.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.neatlittlemonster.gmg.world.Editor;
import com.neatlittlemonster.gmg.world.Renderer;

public class EditorScreen implements Screen {

    private static final String TAG = "EditorScreen";

    private Editor editor;
    private Renderer renderer;

    public EditorScreen() {
        Gdx.app.log(TAG, "created.");

        editor = new Editor();
        renderer = new Renderer(editor);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float _dt) {
        editor.update(_dt);
        renderer.render(_dt);
    }

    @Override
    public void resize(int _width, int _height) {
        renderer.resize(_width, _height);

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