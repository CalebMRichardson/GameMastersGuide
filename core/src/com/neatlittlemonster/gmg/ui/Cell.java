package com.neatlittlemonster.gmg.ui;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.neatlittlemonster.gmg.GMG;

public class Cell {

    private static final String TAG = "Cell";

    private Vector2 position;


    public Cell(Vector2 pos) {
        position = new Vector2(pos.x, pos.y);

    }

    public void render(ShapeRenderer shapeRenderer) {

        // top left corner to right
        shapeRenderer.line(position.x, position.y, position.x + 10.0f, position.y);
        // top left corner to down
        shapeRenderer.line(position.x, position.y, position.x, position.y - 10.0f);

        // bottom left corner to right
        shapeRenderer.line(position.x, position.y - GMG.tileHeight, position.x + 10.0f, position.y - GMG.tileHeight);
        // bottom left corner to up
        shapeRenderer.line(position.x, position.y - GMG.tileHeight, position.x, (position.y - GMG.tileHeight) + 10.0f);

        // top right corner to left
        shapeRenderer.line(position.x + GMG.tileWidth, position.y, position.x + GMG.tileWidth - 10.0f, position.y);
        // top right corner to down
        shapeRenderer.line(position.x + GMG.tileWidth, position.y, position.x + GMG.tileWidth, position.y - 10.0f);

        // bottom right corner to left
        shapeRenderer.line(position.x + GMG.tileWidth, position.y - GMG.tileHeight, position.x + GMG.tileWidth - 10.0f, position.y - GMG.tileWidth);
        // bottom right corner to up
        shapeRenderer.line(position.x + GMG.tileWidth, position.y - GMG.tileHeight, position.x + GMG.tileWidth, position.y - GMG.tileHeight + 10.0f);

    }

}
