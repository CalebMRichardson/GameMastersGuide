package com.neatlittlemonster.gmg.gmghelpers;

import com.badlogic.gdx.Gdx;

public class GMGHelper {

    public static boolean debug = false;

    public static void log(String tag, String msg) {
        if (debug) Gdx.app.log(tag, msg);
    }

}
