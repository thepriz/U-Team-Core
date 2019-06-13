package info.u_team.u_team_test.init;

import info.u_team.u_team_core.item.armor.*;
import info.u_team.u_team_core.util.registry.ArmorSetRegistry;
import info.u_team.u_team_test.TestMod;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.crafting.Ingredient;

public class TestArmorSets {
	
	public static final IArmorMaterial basic = new UArmorMaterialVanilla(20, new int[] { 5, 6, 8, 2 }, 20, TestSounds.better_enderpearl_use, 1, () -> Ingredient.fromItems(TestItems.basic));
	
	public static final ArmorSet basicarmor = ArmorSetCreator.create("basicarmor", TestItemGroups.group, new Properties(), basic);
	
	public static void construct() {
		ArmorSetRegistry.register(TestMod.modid, TestArmorSets.class);
	}
}
