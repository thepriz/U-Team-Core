package info.u_team.u_team_core.item;

import info.u_team.u_team_core.creativetab.UCreativeTab;
import info.u_team.u_team_core.sub.USub;
import net.minecraft.item.ItemFood;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Item API<br>
 * -> Basic Food Item
 * 
 * @date 27.12.17
 * @author HyCraftHD
 *
 */

public class UItemFood extends ItemFood {
	
	private String name, modid;
	
	public UItemFood(String name, int amount) {
		this(name, null, amount);
	}
	
	public UItemFood(String name, UCreativeTab tab, int amount) {
		this(name, tab, amount, 0.6F);
	}
	
	public UItemFood(String name, int amount, float saturation) {
		this(name, null, amount, saturation);
	}
	
	public UItemFood(String name, UCreativeTab tab, int amount, float saturation) {
		super(amount, saturation, false);
		
		this.modid = USub.getID();
		this.name = name;
		setUnlocalizedName(name);
		
		if (tab != null) {
			setCreativeTab(tab);
		}
		
		register();
	}
	
	private final void register() {
		GameRegistry.registerItem(this, name);
	}
	
	public ResourceLocation getRegistryName() {
		return new ResourceLocation(modid, name);
	}
}