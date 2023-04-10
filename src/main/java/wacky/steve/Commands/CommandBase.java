package wacky.steve.Commands;

import net.minecraft.util.StringUtils;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wacky.steve.Commands.Dungeon.DungeonCommands;
import wacky.steve.Commands.Meme.MemeCommands;
import wacky.steve.Commands.Misc.MiscCommands;
import wacky.steve.Commands.Party.PartyCommands;
import wacky.steve.Utils.ChatUtils;
import wacky.steve.Utils.Utils;

public class CommandBase {

    public static final String PREFIX = "./$";

    @SubscribeEvent
    public void onchat(ClientChatReceivedEvent event) {

        String[] ranks = { "[VIP] ", "[VIP+] ", "[MVP] ", "[MVP+] ", "[MVP++] ", "[YOUTUBE] "};
        String[] prefixes = { "Party > ", "Guild > " };
        String[] split = StringUtils.stripControlCodes(event.message.getFormattedText()).split(": ", 2);

        if (split.length != 2) return;

        String playerName = split[0];
        String message = split[1];

        for (String prefix : prefixes) {
            if (playerName.contains(prefix)) {
                playerName = playerName.replace(prefix, "");
                break;
            }
        }

        for (String rank : ranks) {
            if (playerName.contains(rank)) {
                playerName = playerName.replace(rank, "");
                break;
            }
        }

        if (playerName.startsWith("From") || playerName.startsWith("To")) return;

        final String finalPlayerName = playerName;

        new Thread(() -> {
            try {
                if (message.startsWith(PREFIX) && Utils.isWhitelisted(finalPlayerName)) {
                    String command = message.substring(PREFIX.length()).toLowerCase();
                    System.out.println(finalPlayerName + " requested command: " + command);
                    String[] args = command.split(" ");

                    Thread.sleep(1000);
                    if (command.startsWith("help")) {
                        MiscCommands.Help();
                    } else if (command.startsWith("bingchilling")) {
                        MemeCommands.Chilling();
                    } else if (command.startsWith("dt")) {
                        MemeCommands.Dt();
                    } else if  (command.startsWith("onrng")) {
                        MemeCommands.onRNG();
                    } else if (command.startsWith("racism")) {
                        MemeCommands.racismCheck();
                    } else if (command.startsWith("unbanwhen")) {
                        MemeCommands.unbanWhen();
                    } else if (command.startsWith("allinvite")) {
                        PartyCommands.allInvite();
                    } else if (command.startsWith("kickoffline")) {
                        PartyCommands.kickOffline();
                    } else if (command.startsWith("invite")) {
                        PartyCommands.invite(args[1]);
                    } else if (command.startsWith("warp")) {
                        PartyCommands.warp();
                    } else if (command.startsWith("pkick")) {
                        PartyCommands.partyKick(args[1]);
                    } else if (command.startsWith("pmute")) {
                        PartyCommands.partyMute();
                    } else if (command.startsWith("8b")) {
                        MemeCommands.eightBall();
                    } else if (command.startsWith("cf")) {
                        MemeCommands.coinFlip();
                    } else if (command.startsWith("joindungeon") || command.startsWith("jd")) {
                        if (args[1].startsWith("f")) DungeonCommands.joinDungeon(Integer.parseInt(args[1].replace("f", "")), false);
                        else if (args[1].startsWith("m")) DungeonCommands.joinDungeon(Integer.parseInt(args[1].replace("m", "")), true);
                        else ChatUtils.command("/pc Invalid Dungeon floor");
                    } else {
                        ChatUtils.command("/pc Unknown Command");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
