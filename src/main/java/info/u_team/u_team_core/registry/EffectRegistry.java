package info.u_team.u_team_core.registry;

import java.util.*;

import info.u_team.u_team_core.UCoreMain;
import info.u_team.u_team_core.util.RegistryUtil;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.IForgeRegistry;

@EventBusSubscriber(modid = UCoreMain.modid, bus = Bus.MOD)
public class EffectRegistry {
	
	static List<Effect> effects = new ArrayList<>();
	
	public static void register(String modid, Effect effect) {
		BaseRegistry.register(modid, effect, effects);
	}
	
	public static void register(String modid, Collection<Effect> list) {
		list.forEach(potiontype -> register(modid, potiontype));
	}
	
	public static void register(String modid, Class<?> clazz) {
		register(modid, RegistryUtil.getRegistryEntries(Effect.class, clazz));
	}
	
	@SubscribeEvent
	public static void event(RegistryEvent.Register<Effect> event) {
		IForgeRegistry<Effect> registry = event.getRegistry();
		effects.forEach(registry::register);
	}
}