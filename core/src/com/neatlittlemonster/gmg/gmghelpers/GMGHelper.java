package com.neatlittlemonster.gmg.gmghelpers;

import com.badlogic.gdx.Gdx;

public class GMGHelper {

    public static boolean debug = false;

    public static void log(String _tag, String _msg) {
        if (debug) Gdx.app.log(_tag, _msg);
    }
}
