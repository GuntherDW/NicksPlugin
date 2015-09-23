package be.guntherdw.NicksPlugin;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatMessageComponent;

/**
 * @author GuntherDW
 */
public class CommandNicks extends CommandBase {

    private NicksMod modInstance;

    public CommandNicks(NicksMod modInstance) {
        this.modInstance = modInstance;
    }

    @Override
    public String getCommandName() {
        return "nicks";
    }

    @Override
    public String getCommandUsage(ICommandSender icommandsender) {
        return "nicks /reload";
    }

    @Override
    public void processCommand(ICommandSender var1, String[] var2) {
        if (var2.length > 0) {
            if (var2[0].equalsIgnoreCase("reload")) {
                var1.sendChatToPlayer(ChatMessageComponent.createFromText("Reloading config!"));
                ConfigNicks.reloadNicks();
            } else {
                var1.sendChatToPlayer(ChatMessageComponent.createFromText("Only the reload command is supported at the moment!"));
            }
        } else {
            var1.sendChatToPlayer(ChatMessageComponent.createFromText("§6Usage : /nicks reload"));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean canCommandSenderUseCommand(ICommandSender par1iCommandSender) {
        return Minecraft.getMinecraft().isSingleplayer() || super.canCommandSenderUseCommand(par1iCommandSender);
    }
}
