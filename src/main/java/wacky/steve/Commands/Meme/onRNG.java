package wacky.steve.Commands.Meme;

import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import wacky.steve.Config.Config;
import wacky.steve.Utils.ChatUtils;

public class onRNG {

    @SubscribeEvent
    public void onDrop(ClientChatReceivedEvent event) {
        if (event.message.getFormattedText().contains("CRAZY RARE DROP!") && Config.onRNG) {
            ChatUtils.command("/pc JÆVLA SJELDENT DROPP! ingen bryr seg!");
        }
    }
}
