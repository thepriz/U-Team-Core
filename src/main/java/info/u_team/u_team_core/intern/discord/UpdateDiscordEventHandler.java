package info.u_team.u_team_core.intern.discord;

import info.u_team.u_team_core.UCoreMod;
import info.u_team.u_team_core.intern.config.ClientConfig;
import info.u_team.u_team_core.intern.discord.DiscordRichPresence.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.screen.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.event.lifecycle.*;

public class UpdateDiscordEventHandler {
	
	public static void on(InitGuiEvent.Pre event) {
		if (!DiscordRichPresence.isEnabled()) {
			return;
		}
		if (event.getGui() instanceof MainMenuScreen || event.getGui() instanceof WorldSelectionScreen || event.getGui() instanceof MultiplayerScreen) {
			final State state = DiscordRichPresence.getCurrent();
			if (state == null || state.getState() != EnumState.MENU) {
				DiscordRichPresence.setIdling();
			}
		}
	}
	
	public static void on(EntityJoinWorldEvent event) {
		if (!DiscordRichPresence.isEnabled()) {
			return;
		}
		if (event.getEntity() instanceof ClientPlayerEntity) {
			final ClientPlayerEntity player = (ClientPlayerEntity) event.getEntity();
			if (player.getUniqueID().equals(Minecraft.getInstance().player.getUniqueID())) {
				DiscordRichPresence.setDimension(player.getEntityWorld());
			}
		}
	}
	
	private static void setup(FMLCommonSetupEvent event) {
		if (ClientConfig.getInstance().discordRichPresence.get()) {
			DiscordRichPresence.start();
		}
	}
	
	public static void registerMod(IEventBus bus) {
		bus.addListener(UpdateDiscordEventHandler::setup);
	}
	
	public static void registerForge(IEventBus bus) {
	}
}