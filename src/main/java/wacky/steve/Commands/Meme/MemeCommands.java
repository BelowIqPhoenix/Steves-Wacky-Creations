package wacky.steve.Commands.Meme;

import com.fasterxml.jackson.databind.node.ObjectNode;
import wacky.steve.Config.Config;
import wacky.steve.Main;
import wacky.steve.Utils.ChatUtils;
import wacky.steve.Utils.TimeUtils;

import java.io.IOException;

public class MemeCommands {

    public static void Chilling() {
        ChatUtils.command("/pc Zǎoshang hǎo zhōngguó xiànzài wǒ yǒu BING CHILLING  wǒ hěn xǐhuān BING CHILLING");
    }

    public static void Dt() {
        ChatUtils.command("/pc Please refrain from causing downtime, I have a wife and kids to feed as well as it decreases my catacombs experience per hour efficiency. Thanks for understanding.");
    }

    public static void racismCheck() {
        String[] responses = {"strong", "weak", "potent", "big", "small", "very strong", "not very strong", "ask again later", "extreme"};
        ChatUtils.command("/pc racism is " + responses[(int) (Math.random() * responses.length)] + " today");
    }

    public static void unbanWhen() {
        final long dateOfUnban = 1708323600000L;
        ChatUtils.command("/pc Unbanned in: " + TimeUtils.formatTime(dateOfUnban - System.currentTimeMillis()));
    }

    public static void onRNG() {
        try {
            ObjectNode object = (ObjectNode) Config.readConfig();
            object.put("onRNG", !Config.onRNG());
            Main.om.writeValue(Main.whitelist, object);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ChatUtils.log("onRNG has been set to " + Config.onRNG());
    }

    public static void eightBall() {
        String[] responses = { "It is certain", "Without a doubt", "You may rely on it", "Yes definitely", "It is decidedly so", "As I see it, yes", "Most likely", "Yes", "Outlook good", "Signs point to yes", "Reply hazy try again", "Better not tell you now", "Ask again later", "Cannot predict now", "Concentrate and ask again", "Don’t count on it", "Outlook not so good", "My sources say no", "Very doubtful", "My reply is no", "SusPhoenix is always right", "Your Mum", "Im tired", "Ive  been doing this for 26hrs straight", "Send help" };
        ChatUtils.command("/pc " + responses[(int) (Math.random() * responses.length)]);
    }

    public static void coinFlip() {
        new Thread(() -> {
            try {
                String[] responses  = { "And its heads!", "And its tails!" };
                ChatUtils.command("/pc Coin tossed...");
                Thread.sleep(1000);
                ChatUtils.command("/pc " + responses[(int) (Math.random() * responses.length)]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
