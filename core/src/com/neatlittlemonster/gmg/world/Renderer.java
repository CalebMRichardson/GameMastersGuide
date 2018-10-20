package com.neatlittlemonster.gmg.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.neatlittlemonster.gmg.GMG;
import com.neatlittlemonster.gmg.ui.Cell;

public class Renderer {

    private static final String TAG = "Renderer";

    private Editor editor;
    private final Color bgColor;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private ShapeRenderer shapeRenderer;

    public Renderer(Editor _editor) {
        editor = _editor;
        bgColor = new Color(222/255.0f, 227/255.0f, 233/255.0f, 1);
        batch = new SpriteBatch();

        camera = new OrthographicCamera(GMG.camWidth, GMG.camHeight);
        camera.setToOrtho(true, GMG.camWidth, GMG.camHeight);

        batch.setProjectionMatrix(camera.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.setProjectionMatrix(camera.combined);

        centerCamera();
    }

    private void centerCamera() {
        float lastXPos, lastYPos;

        Cell lastCell = editor.getCells().get(editor.getCells().size - 1);
        lastXPos = lastCell.getPosition().x;
        lastYPos = lastCell.getPosition().y;

        camera.position.x = lastXPos / 2 + (camera.viewportWidth / 2);
        camera.position.y = lastYPos / 2 + (camera.viewportHeight / 2);
        camera.update();
    }

    public void render(float _dt) {

        Gdx.gl.glClearColor(bgColor.r, bgColor.g, bgColor.b, bgColor.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.begin();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        for (Cell cell : editor.getCells()) {
            cell.render(shapeRenderer);
        }

        shapeRenderer.end();

        batch.end();

    }

    public void resize(int _width, int _height) {
        camera.viewportWidth = _width;
        camera.viewportHeight = _height;
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        shapeRenderer.setProjectionMatrix(camera.combined);
    }

    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
    }

}
