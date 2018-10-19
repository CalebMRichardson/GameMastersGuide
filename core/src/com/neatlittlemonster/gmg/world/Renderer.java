package com.neatlittlemonster.gmg.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.neatlittlemonster.gmg.GMG;
import com.neatlittlemonster.gmg.ui.Cell;

public class Renderer {

    private static final String TAG = "Renderer";

    private final Color bgColor;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Array<Cell> cells;
    private ShapeRenderer shapeRenderer;

    public Renderer() {
        bgColor = new Color(222/255.0f, 227/255.0f, 233/255.0f, 1);
        batch = new SpriteBatch();

        camera = new OrthographicCamera(GMG.camWidth, GMG.camHeight);
        camera.setToOrtho(true, GMG.camWidth, GMG.camHeight);

        batch.setProjectionMatrix(camera.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.setProjectionMatrix(camera.combined);

        cells = new Array<Cell>();

        float midX = camera.viewportWidth / 2 - (GMG.tileWidth / 2);
        float midY = camera.viewportHeight / 2 - (GMG.tileWidth / 2);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Vector2 pos = new Vector2(midX + (GMG.tileHeight * i), midY + (GMG.tileWidth * j));
                Cell cell = new Cell(pos);
                cells.add(cell);
            }
        }

    }

    public void render(float dt) {

        Gdx.gl.glClearColor(bgColor.r, bgColor.g, bgColor.b, bgColor.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.begin();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);

        for (Cell cell : cells) {
            cell.render(shapeRenderer);
        }

        shapeRenderer.end();

        batch.end();

    }

    public void resize(int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        shapeRenderer.setProjectionMatrix(camera.combined);
    }

    public void dispose() {
        batch.dispose();
        shapeRenderer.dispose();
    }

}
