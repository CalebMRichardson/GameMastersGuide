package com.neatlittlemonster.gmg.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.neatlittlemonster.gmg.gmghelpers.GMGHelper;

public class CameraController implements InputProcessor{

    private static final String TAG = "CameraController";
    private float zoomSpeed = .1f;
    private float moveSpeed = 20f;
    private float xMovement, yMovement;
    private static final int A_KEY = Input.Keys.A;
    private static final int D_KEY = Input.Keys.D;
    private static final int S_KEY = Input.Keys.S;
    private static final int W_KEY = Input.Keys.W;

    private OrthographicCamera camera;

    public CameraController(OrthographicCamera _camera) {

        camera = _camera;

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(this);

        Gdx.input.setInputProcessor(inputMultiplexer);

    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == Input.Keys.A) xMovement = -1f;
        else if (keycode == Input.Keys.D) xMovement = 1f;
        if (keycode == Input.Keys.S) yMovement = -1f;
        else if (keycode == Input.Keys.W) yMovement = 1;

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

        if (keycode == Input.Keys.A) xMovement = 0;
        if (keycode == Input.Keys.D) xMovement = 0;
        if (keycode == Input.Keys.S) yMovement = 0;
        if (keycode == Input.Keys.W) yMovement = 0;

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

        if (amount == -1) {
            Vector3 mouseToWorld = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            camera.position.x = mouseToWorld.x;
            camera.position.y = mouseToWorld.y;
        }

        camera.zoom = camera.zoom + (amount * zoomSpeed);

        return false;
    }

    public void update(float _dt) {

        // Interpolate the camera from its current position
        // to the position of the direction its moving

    }
}
