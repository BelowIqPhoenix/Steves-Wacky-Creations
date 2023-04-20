package wacky.steve.Commands.Whitelist;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import wacky.steve.Config.Config;
import wacky.steve.Main;
import wacky.steve.Utils.ChatUtils;
import wacky.steve.Utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Whitelist extends CommandBase {
    @Override
    public String getCommandName() {
        return "wl";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/" + getCommandName();
    }

    @Override
    public List<String> getCommandAliases() {
        return new ArrayList<>(Arrays.asList(new String[] {}));
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {

        try {

            if (args.length < 2) {
                ChatUtils.log("Usage: /wl add <playername>, /wl remove <playername>");
                return;
            }

            String playername = args[1];

            if (args[0].equals("add")) {

                if (Utils.isWhitelisted(playername)) {
                    ChatUtils.log(playername + " is already whitelisted");
                    return;
                }

                JsonNode config = Config.readConfig();
                ArrayNode players = (ArrayNode) config.get("players");
                players.add(playername);
                Main.om.writeValue(Main.whitelist, config);

                ChatUtils.log(playername + " is now whitelisted");
            } else if (args[0].equals("remove")) {

                if (!Utils.isWhitelisted(playername)) {
                    ChatUtils.log(playername + " is not whitelisted");
                    return;
                }

                JsonNode config = Config.readConfig();
                ArrayNode players = (ArrayNode) config.get("players");
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).asText().equals(playername)) {
                        players.remove(i);
                        break;
                    }
                }
                Main.om.writeValue(Main.whitelist, config);

                ChatUtils.log(playername + " has been removed from the whitelist");
            } else {
                ChatUtils.log("Usage: /wl add <playername>, /wl remove <playername>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
