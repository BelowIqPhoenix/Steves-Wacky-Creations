package wacky.steve.Config;

import gg.essential.vigilance.Vigilant;
import gg.essential.vigilance.data.JVMAnnotationPropertyCollector;

import java.io.File;

public class Config extends Vigilant {
    public static final File CONFIG_FILE = new File("config/steveswackycreations/wackyconfig.toml");

    public static boolean onRNG = true;

    public Config() {
        super(CONFIG_FILE, "Steve's Wacky Creations Config", new JVMAnnotationPropertyCollector());
        initialize();
    }
}
