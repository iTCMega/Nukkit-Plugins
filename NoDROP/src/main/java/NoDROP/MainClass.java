package NoDROP;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDropItemEvent;
import cn.nukkit.event.entity.ItemSpawnEvent;
import cn.nukkit.utils.TextFormat;

public class MainClass extends PluginBase implements Listener {
	
	public void onLoad(){
	}
	
	public void onEnable(){
		this.getServer().getPluginManager().registerEvents(new this, this);
		this.getLogger().info(TextFormat.GREEN + "Enable!");
	}
	
	public void onDrop(PlayerDropItemEvent event){
	    event.getPlayer().sendTip(TextFormat.RED + "You can\'t drop item!");
		event.setCanclled(true);
	}
	
	public void onItemSpawn(ItemSpawnEvent event){
		event.getEntity().getLevel().removeEntity(event.getEntity());
	}
}
