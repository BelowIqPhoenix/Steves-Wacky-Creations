package wacky.steve.Utils;

import net.minecraft.util.ChatComponentText;
import org.apache.commons.lang3.Validate;
import wacky.steve.Main;

import java.text.NumberFormat;
import java.util.Locale;

public class ChatUtils {

    public static final char COLOUR_CHAR = '\u00A7';

    public static String translateAlternativeColourCode(char alternateColourCode, String string) {
        Validate.notNull(string, "Cannot translate null text");

        char[] b = string.toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            if (b[i] == alternateColourCode && "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx".indexOf(b[i + 1]) > -1) {
                b[i] = ChatUtils.COLOUR_CHAR;
                b[i + 1] = Character.toLowerCase(b[i + 1]);

            }
        }
        return new String(b);
    }
    public static String chat(String string) {
        return ChatUtils.translateAlternativeColourCode('&', string);
    }

    public static void log(String message) {
        Main.mc.thePlayer.addChatMessage(new ChatComponentText(chat("&8[&cConsole&8] &f" + message)));
    }

    public static void command(String message) {
        Main.mc.thePlayer.sendChatMessage(message);
    }

    public static String separateWithCommas(long number) {
        Locale locale = Locale.getDefault();
        NumberFormat formatter = NumberFormat.getInstance(locale);
        return formatter.format(number);
    }
}
