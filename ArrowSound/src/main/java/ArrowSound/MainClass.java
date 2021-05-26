package ArrowSound;

import cn.nukkit.event.Listener;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.event.entity.ProjectileHitEvent;
import cn.nukkit.entity.Arrow;
import cn.nukkit.Player;
import cn.nukkit.level.sound.AnvilFallSound;
import cn.nukkit.event.entity.EntityDamageEvent;
import cn.nukkit.event.entity.EntityDamageByEntityEvent;
import cn.nukkit.event.entity.EntityDamageByChildEntityEvent;
import cn.nukkit.utils.TextFormat;

public class MainClass extends PluginBase implements Listener {
	
	@Override
	public void onEnable(){
		this.getServer().getPluginManager().registerEvents(new this), this);
		this.getLogger().info(TextFormat.GREEN + "[ArrowSound] has been enable!");
	}
	
	@Override
	public void onDisable(){
		this.getLogger().info(TextFormat.RED + "[ArrowSound] has been disable!");
	}
	
	@Override
	public void onHit(EntityDamageByEntityEvent ev){
		if(ev instanceof EntityDamageByChildEntityEvent){
			ev.getEntity().getLevel().addSound(new AnvilFallSound(ev.getEntity().getLocation()));
			
			ev.getDamager().getLevel().addSound(new AnvilFallSound(ev.getDamager().getLocation()));
			ev.getDamager().senTip(TextFormat.GREEN + "HIT!");
		}
	}
}
