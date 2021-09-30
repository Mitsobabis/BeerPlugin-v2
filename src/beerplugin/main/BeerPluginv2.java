package beerplugin.main;

import com.mitsobabis.beerpluginv2.commands.*;
import com.mitsobabis.beerpluginv2.commands.warncommands.CheatWarn;
import com.mitsobabis.beerpluginv2.commands.warncommands.GriefWarn;
import com.mitsobabis.beerpluginv2.commands.warncommands.Warn;
import com.mitsobabis.beerpluginv2.commands.warncommands.WarnList;
import com.mitsobabis.beerpluginv2.listeners.BlockBreakListener;
import com.mitsobabis.beerpluginv2.listeners.DeathListener;
import com.mitsobabis.beerpluginv2.listeners.Welcome;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public final class BeerPluginv2 extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Beer Toggled");
        Bukkit.getPluginManager().registerEvents(new Welcome(), this);
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
        Bukkit.getPluginManager().registerEvents(new DeathListener(), this);
        getCommand("uuid").setExecutor(new UUIDCommand());
        getCommand("rules").setExecutor(new RulesCommand());
        getCommand("selfxp").setExecutor(new SelfxpCommand());
        getCommand("sendxp").setExecutor(new sendxp());
        getCommand("discord").setExecutor(new DiscordCommand());
        getCommand("antibot").setExecutor(new AntiBot());
        getCommand("cheatwarn").setExecutor(new CheatWarn());
        getCommand("griefwarn").setExecutor(new GriefWarn());
        getCommand("warn").setExecutor(new Warn());
        getCommand("warnlist").setExecutor(new WarnList());
        getCommand("track").setExecutor(new track());
        // Plugin startup logic
    }


    @Override
    public void onDisable() {
        this.getLogger().info("Beer goes to sleep...");
    }

}
