package fr.unice.polytech.nuit_de_linfo_2017.questions;

import android.content.Context;
import android.content.res.AssetManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.Scanner;

/**
 * @author Gaetan Vialon
 *         Created the 07/12/2017.
 */

public class LeSaviezVousParser {

    private static String FILE_NAME = "json/questions.json";
    private JSONArray json;
    public LeSaviezVousParser(Context context) {
        try {
            Scanner scan = new Scanner(context.getAssets().open(FILE_NAME));
            scan.useDelimiter("\\Z");
            String content = scan.next();
            json = new JSONObject(content).getJSONArray("questions");
            System.out.println(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public LeSaviezVous getRandonLeSaviezVous(){
        System.out.println("value : " + json.length());
        int randomNumber = new Random().nextInt(json.length());
        try {
            JSONObject jsonObject = json.getJSONObject(randomNumber);
            return new LeSaviezVous(jsonObject.getString("question"),jsonObject.getString("anecdote"),jsonObject.getBoolean("reponse"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
