package TotemStocks.GUI;

import TotemStocks.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MainGUI implements CommandExecutor, Listener {

    private Main plugin;

    public MainGUI(Main plugin) {

        this.plugin = plugin;
        plugin.getCommand("setnpc").setExecutor(this);
        Bukkit.getPluginManager().registerEvents(this, plugin);

    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (p.hasPermission("totemstockage.setnpc")) {
            if (cmd.getName().equalsIgnoreCase("setnpc")) {
                Location loc5 = parseStringToLoc(args[0]);
                p.sendMessage(String.valueOf(loc5));
                //p.chat("/summon Villager ~ ~ ~ {Profession:1,NoAI:1b,CanPickUpLoot:0b,Silent:1,Invulnerable:1,Age:0}");
                p.chat("/summon Villager ~ ~ ~ {Profession:1,CustomName:\"§aStockage Totem\",CustomNameVisible:1,NoAI:1b,CanPickUpLoot:0b,Silent:1,Invulnerable:1,ActiveEffects:[{Id:6,Amplifier:50,Duration:2147483647,ShowParticles:0b},{Id:11,Amplifier:50,Duration:2147483647,ShowParticles:0b}]}");
                //p.chat("/summon ArmorStand ~ ~ ~ {Invisible:1,Invulnerable:1,CustomName:§aStockage Totem,CustomNameVisible:1}\n");
            }
        }else {
            p.sendMessage("You don't have permission!!!");
            return true;
        }

        return false;

    }

    public Location parseStringToLoc(String string) {
        String[] parsedLoc = string.split(",");
        double x = Double.valueOf(parsedLoc[0]);
        double y = Double.valueOf(parsedLoc[1]);
        double z = Double.valueOf(parsedLoc[2]);

        final Location loc5;
        loc5 = new Location(z, x, y);
        return loc5;
    }


    @EventHandler
    public void onEntityClick (PlayerInteractEntityEvent e) {
        Player p = e.getPlayer();

        if (e.getRightClicked() instanceof Villager) {
            Inventory gui = Bukkit.getServer().createInventory(p, 45, (ChatColor.translateAlternateColorCodes('&', "&8Stockage Totem")));

            gui.setItem(0, getItem(Material.GLASS));
            gui.setItem(1, getItem(Material.GLASS));
            gui.setItem(2, getItem(Material.GLASS));
            gui.setItem(3, getItem(Material.GLASS));

            gui.setItem(5, getItemlapis());
            gui.setItem(6, getItemlapis());
            gui.setItem(7, getItemlapis());
            gui.setItem(8, getItemlapis());

            gui.setItem(9, getItem(Material.SAND));
            gui.setItem(10, getItem(Material.SAND));
            gui.setItem(11, getItem(Material.SAND));
            gui.setItem(12, getItem(Material.SAND));

            gui.setItem(14, getItem(Material.LADDER));
            gui.setItem(15, getItem(Material.LADDER));
            gui.setItem(16, getItem(Material.LADDER));
            gui.setItem(17, getItem(Material.LADDER));

            gui.setItem(18, getItem(Material.BREAD));
            gui.setItem(19, getItem(Material.BREAD));
            gui.setItem(20, getItem(Material.BREAD));
            gui.setItem(21, getItem(Material.BREAD));

            gui.setItem(23, getItem(Material.COBBLESTONE));
            gui.setItem(24, getItem(Material.COBBLESTONE));
            gui.setItem(25, getItem(Material.COBBLESTONE));
            gui.setItem(26, getItem(Material.COBBLESTONE));

            gui.setItem(27, getItem(Material.GLOWSTONE));
            gui.setItem(28, getItem(Material.GLOWSTONE));
            gui.setItem(29, getItem(Material.GLOWSTONE));
            gui.setItem(30, getItem(Material.GLOWSTONE));

            gui.setItem(32, getItem(Material.WOOD));
            gui.setItem(33, getItem(Material.WOOD));
            gui.setItem(34, getItem(Material.WOOD));
            gui.setItem(35, getItem(Material.WOOD));

            gui.setItem(36, getItem2(Material.WATER_BUCKET));
            gui.setItem(37, getItem2(Material.WATER_BUCKET));
            gui.setItem(38, getItem2(Material.WATER_BUCKET));
            gui.setItem(39, getItem2(Material.WATER_BUCKET));

            gui.setItem(41, getItem3(Material.SNOW_BALL));
            gui.setItem(42, getItem3(Material.SNOW_BALL));
            gui.setItem(43, getItem3(Material.SNOW_BALL));
            gui.setItem(44, getItem3(Material.SNOW_BALL));

            p.openInventory(gui);

        }
    }

    public ItemStack getItem(Material material) {
        ItemStack it = new ItemStack(material, 64);
        ItemMeta itM = it.getItemMeta();
        //if(customName != null) itM.setDisplayName(customName);
        it.setItemMeta(itM);
        return it;
    }

    public ItemStack getItem2(Material material) {
        ItemStack it = new ItemStack(material, 1);
        ItemMeta itM = it.getItemMeta();
        //if(customName != null) itM.setDisplayName(customName);
        it.setItemMeta(itM);
        return it;
    }

    public ItemStack getItem3(Material material) {
        ItemStack it = new ItemStack(material, 16);
        ItemMeta itM = it.getItemMeta();
        //if(customName != null) itM.setDisplayName(customName);
        it.setItemMeta(itM);
        return it;
    }
    public ItemStack getItemlapis() {
        ItemStack it = new ItemStack(Material.INK_SACK, 64, (byte) 4);
        ItemMeta itM = it.getItemMeta();
        it.setItemMeta(itM);
        return it;
    }


    @EventHandler
    public void on(InventoryOpenEvent e){
        Player p = (Player)e.getPlayer();
        if(e.getInventory().getType() == InventoryType.MERCHANT){
            e.setCancelled(true);
        }
    }


}
