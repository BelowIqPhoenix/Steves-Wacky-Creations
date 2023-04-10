package wacky.steve;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.json.JSONArray;
import org.json.JSONObject;
import wacky.steve.Commands.CommandBase;
import wacky.steve.Commands.Meme.onRNG;
import wacky.steve.Commands.Whitelist.Whitelist;
import wacky.steve.Config.Config;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Mod(name = Main.MODNAME, modid = Main.MODID, version = Main.VERSION, acceptedMinecraftVersions = "[1.8.9]", clientSideOnly = true)
public class Main {

    public static final String MODNAME = "Steve's Wacky Creations";
    public static final String MODID = "steveswackycreations";
    public static final String VERSION = "1.0";
    public static final Minecraft mc = Minecraft.getMinecraft();

    public static File modDir = new File(new File(mc.mcDataDir, "config"), "steveswackycreations");
    public static File whitelist = new File(modDir + "/" + "wackywhitelist.json");
    public static Config config = new Config();

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) throws IOException {
        if(!modDir.exists()) modDir.mkdir();

        if (!whitelist.exists()) {
            whitelist.createNewFile();
            JSONObject obj = new JSONObject();
            JSONArray whitelist = new JSONArray();
            obj.put("players", whitelist);
            FileWriter writer = new FileWriter(Main.whitelist);
            writer.write(obj.toString());
            writer.close();
        }
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        config.preload();
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new CommandBase());
        MinecraftForge.EVENT_BUS.register(new onRNG());
        ClientCommandHandler.instance.registerCommand(new Whitelist());
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}

/*
--------------------FEATURES--------------------
Help - Displays a list of cmds.
BingChilling - "/pc Zǎoshang hǎo zhōngguó xiànzài wǒ yǒu BING CHILLING  wǒ hěn xǐhuān BING CHILLING"
Dt - "/pc Please refrain from causing downtime, I have a wife and kids to feed as well as it decreases my catacombs experience per hour efficiency. Thanks for understanding."
onRNG - Displays a message on "CRAZY RARE DROP!".
racism - Racism Strength Check.
unbanwhen - Displays when bozo gets unbanned.
AllInvite - Toggles allinvite.
KickOffline - Runs kick offline cmd.
Invite - Invites a player to the party.
Warp - Warps party into lobby.
Party Kick - Kicks a specified player from the party.
Party Mute - Mutes the party.
8 Ball - Magic black ball
Coinflip - Just a regular coinflip
f7 m4 m6 m7 - warps into dungeon
------------------------------------------------
*/
