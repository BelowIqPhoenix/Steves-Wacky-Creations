package wacky.steve.Commands.Whitelist;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import org.json.JSONArray;
import org.json.JSONObject;
import wacky.steve.Main;
import wacky.steve.Utils.ChatUtils;

import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
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
                String str = new String(Files.readAllBytes(Paths.get(Main.modDir.toString(), "wackywhitelist.json")));
                JSONObject obj = new JSONObject(str);

                JSONArray whitelist = obj.getJSONArray("players");
                whitelist.put(playername);

                FileWriter writer = new FileWriter(Main.whitelist);
                writer.write(obj.toString());
                writer.close();

                ChatUtils.log(playername + " is now whitelisted");
            } else if (args[0].equals("remove")) {
                String str = new String(Files.readAllBytes(Paths.get(Main.modDir.toString(), "wackywhitelist.json")));
                JSONObject obj = new JSONObject(str);

                JSONArray whitelist = obj.getJSONArray("players");

                for (int i = 0; i < whitelist.length(); i++) {
                    if (whitelist.getString(i).equals(playername)) {
                        whitelist.remove(i);
                        break;
                    }
                }

                FileWriter writer = new FileWriter(Main.whitelist);
                writer.write(obj.toString());
                writer.close();

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
