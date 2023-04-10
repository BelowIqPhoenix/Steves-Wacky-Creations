package wacky.steve.Commands.Party;

import wacky.steve.Utils.ChatUtils;

public class PartyCommands {

    public static void allInvite() {
        ChatUtils.command("/p settings allinvite");
    }

    public static void kickOffline() {
        ChatUtils.command("/p kickoffline");
    }

    public static void invite(String playerName) {
        ChatUtils.command("/p " + playerName);
    }

    public static void warp() {
        new Thread(() -> {
            try {
                ChatUtils.command("/pc Warping in 3");
                Thread.sleep(1000);
                ChatUtils.command("/pc Warping in 2");
                Thread.sleep(1000);
                ChatUtils.command("/pc Warping in 1");
                Thread.sleep(1000);
                ChatUtils.command("/p warp");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void partyKick(String playerName) {
        ChatUtils.command("/p kick " + playerName);
    }

    public static void partyMute() {
        ChatUtils.command("/p mute");
    }
}
