package wacky.steve.Utils;

import org.json.JSONArray;
import org.json.JSONObject;
import wacky.steve.Main;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {

    public static boolean isWhitelisted(String playerName) {
        boolean whitelisted = false;
        try {
            String str = new String(Files.readAllBytes(Paths.get(Main.modDir.toString(), "wackywhitelist.json")));
            JSONObject obj = new JSONObject(str);

            JSONArray whitelist = obj.getJSONArray("players");

            for (int i = 0; i < whitelist.length(); i++) {
                if (whitelist.getString(i).equalsIgnoreCase(playerName)) {
                    whitelisted = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  whitelisted;
    }
}
