package wacky.steve.Utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import wacky.steve.Config.Config;

public class Utils {

    public static boolean isWhitelisted(String player) {
        try {
            JsonNode config = Config.readConfig();
            ArrayNode players = (ArrayNode) config.get("players");
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).asText().equals(player)) return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
