package com.neatlittlemonster.gmg.world;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.neatlittlemonster.gmg.GMG;
import com.neatlittlemonster.gmg.ui.Cell;

public class Editor {

    private static final String TAG = "Editor";
    private Array<Cell> cells;

    public Editor() {

        cells = new Array<Cell>();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                Vector2 pos = new Vector2(GMG.tileHeight * i, GMG.tileWidth * j);
                Cell cell = new Cell(pos);
                cells.add(cell);
            }
        }
    }

    public void update(float _dt) {

    }

    public Array<Cell> getCells() {
        return cells;
    }
}
