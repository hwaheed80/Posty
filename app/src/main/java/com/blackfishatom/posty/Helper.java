package com.blackfishatom.posty;

import com.google.gson.Gson;

/**
 * Created by hwaheed on 2/21/2016.
 */
public class Helper {

    public static <Input> String GetJson(Input obj)
    {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }
}
