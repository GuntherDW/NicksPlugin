package be.guntherdw.NicksPlugin;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;

import java.io.File;

import static cpw.mods.fml.common.Mod.EventHandler;

/**
 * @author GuntherDW
 */
@Mod(
    modid = "NicksMod",
    name = "NicksMod",
    version = NicksMod.VERSION,
    dependencies = "required-after:Forge@[6.0.1.347,]"
)
@NetworkMod(
    clientSideRequired = false,
    serverSideRequired = false,
    versionBounds = "(0,]"
)
public class NicksMod {
    public static final String VERSION = "1.0 alpha";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        File path = event.getSuggestedConfigurationFile();
        ConfigNicks.setPath(path);
        ConfigNicks.reloadNicks();
    }


    @EventHandler
    public void registerCommands(FMLServerStartingEvent event) {
        event.registerServerCommand(new CommandNicks(this));
    }

}
