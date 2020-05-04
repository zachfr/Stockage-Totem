package TotemStocks;

import TotemStocks.GUI.MainGUI;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        MainGUI gui = new MainGUI(this);
        Bukkit.getServer().getPluginManager().registerEvents( this, this);
    }
}
