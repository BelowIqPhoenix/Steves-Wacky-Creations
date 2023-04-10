package wacky.steve.Commands.Dungeon;

import wacky.steve.Utils.ChatUtils;

public class DungeonCommands {

    public static void joinDungeon(int floor, boolean master) {
        new Thread(() -> {
            try {
                if (floor > 7 || floor < 1) {
                    ChatUtils.command("/pc Invalid Dungeon Floor");
                    return;
                }

                if (!master) {
                    ChatUtils.command("/pc Joining Dungeon in 3");
                    Thread.sleep(1000);
                    ChatUtils.command("/pc Joining Dungeon in 2");
                    Thread.sleep(1000);
                    ChatUtils.command("/pc Joining Dungeon in 1");
                    Thread.sleep(1000);
                    ChatUtils.command("/joindungeon catacombs " + floor);
                } else {
                    ChatUtils.command("/pc Joining Dungeon in 3");
                    Thread.sleep(1000);
                    ChatUtils.command("/pc Joining Dungeon in 2");
                    Thread.sleep(1000);
                    ChatUtils.command("/pc Joining Dungeon in 1");
                    Thread.sleep(1000);
                    ChatUtils.command("/joindungeon master_catacombs " + floor);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
