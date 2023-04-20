package wacky.steve.Config;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import wacky.steve.Main;

public class Config {

    public static void init() {
        try {
            ObjectNode object = Main.om.createObjectNode();
            object.put("onRNG", true);
            object.putArray("players");
            Main.om.writeValue(Main.whitelist, object);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JsonNode readConfig() {
        try {
            return Main.om.readTree(Main.whitelist);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean onRNG() {
        try {
            return Config.readConfig().get("onRNG").asBoolean();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
