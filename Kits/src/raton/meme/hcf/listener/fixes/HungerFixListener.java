package raton.meme.hcf.listener.fixes;

import net.minecraft.server.v1_7_R4.EntityPlayer;
import raton.meme.hcf.HCF;

import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * xInspect Is Fucking Babe
 */
public class HungerFixListener implements Listener{
    /*    */   @EventHandler(ignoreCancelled=true, priority= EventPriority.MONITOR)
/*    */   public void onPlayerJoin(PlayerJoinEvent event)
/*    */   {
/* 77 */     EntityPlayer entityPlayer = ((CraftPlayer)event.getPlayer()).getHandle();
/* 78 */     entityPlayer.knockbackReductionX = 0.6F;
/* 79 */     entityPlayer.knockbackReductionY = 0.55F;
/* 80 */     entityPlayer.knockbackReductionZ = 0.6F;
/*    */   }

    @EventHandler
    public void onMove(PlayerMoveEvent e){
        if(HCF.getPlugin().getFactionManager().getFactionAt(e.getPlayer().getLocation()).isSafezone()) {
            if(e.getPlayer().getFoodLevel() < 20) {
                e.getPlayer().setFoodLevel(20);
                e.getPlayer().setSaturation(20);
            }
        }
    }
    @EventHandler
    public void onHungerChange(FoodLevelChangeEvent e){
        if(e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
                p.setSaturation(1000);
                p.setFoodLevel(20);

        }
    }
}
