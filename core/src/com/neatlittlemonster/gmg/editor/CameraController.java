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
    private float zoomDistance = 50f;
    private float moveSpeed = 20f;
    private static final int A_KEY = Input.Keys.A;
    private static final int D_KEY = Input.Keys.D;
    private static final int S_KEY = Input.Keys.S;
    private static final int W_KEY = Input.Keys.W;
    private static final int SPACE = Input.Keys.SPACE;
    private OrthographicCamera camera;
    private Vector3 startingCamPos;
    private float startingCamZoom;

    public CameraController(OrthographicCamera _camera) {

        camera = _camera;

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(this);

        Gdx.input.setInputProcessor(inputMultiplexer);

        startingCamPos = new Vector3(camera.position.x, camera.position.y, camera.position.z);
        startingCamZoom = camera.zoom;
    }

    @Override
    public boolean keyDown(int keycode) {

        if (keycode == SPACE) {
            resetCamera();
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {

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

            if (camera.zoom < 0.08) {
                camera.zoom = 0.08f;
                return false;
            }

            Vector3 mouseToWorld = camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
            Vector2 difference = new Vector2(mouseToWorld.x - camera.position.x, mouseToWorld.y - camera.position.y);


            camera.position.x += difference.nor().x * zoomDistance;
            camera.position.y += difference.nor().y * zoomDistance;
        }

        camera.zoom = camera.zoom + (amount * zoomSpeed);
        GMGHelper.log(TAG, Float.toString(camera.zoom));

        return false;
    }

    public void update(float _dt) {

        // Interpolate the camera from its current position
        // to the position of the direction its moving

    }

    private void resetCamera() {

        camera.position.set(startingCamPos);
        camera.zoom = startingCamZoom;
    }
}
