package com.neatlittlemonster.gmg;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.neatlittlemonster.gmg.gmghelpers.GMGHelper;
import com.neatlittlemonster.gmg.screens.EditorScreen;

public class GMG extends Game {

	private static final String TAG = "GameMastersGuide";
	public static final int camWidth = 900;
	public static final int camHeight = 800;
	public static final int tileWidth = 32;
	public static final int tileHeight = 32;
	
	@Override
	public void create () {

		GMGHelper.debug = true;

		GMGHelper.log(TAG, "created.");

		setScreen(new EditorScreen());
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		super.dispose();
	}
}