package info.u_team.u_team_core.intern.init;

import info.u_team.u_team_core.UCoreMod;
import info.u_team.u_team_core.intern.loot.SetTileEntityNBTLootFunction;
import net.minecraft.block.Block;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@EventBusSubscriber(modid = UCoreMod.MODID, bus = Bus.MOD)
public class UCoreLootTableRegistry {
	
	public static LootFunctionType SET_TILEENTITY_NBT;
	
	@SubscribeEvent
	public static void register(Register<Block> event) {
		SET_TILEENTITY_NBT = Registry.register(Registry.LOOT_FUNCTION_TYPE, new ResourceLocation(UCoreMod.MODID, "set_tileentity_nbt"), new LootFunctionType(new SetTileEntityNBTLootFunction.Serializer()));
	}
	
}
