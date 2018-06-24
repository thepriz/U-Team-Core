package test;

import info.u_team.u_team_core.block.*;
import info.u_team.u_team_core.container.UContainer;
import info.u_team.u_team_core.creativetab.UCreativeTab;
import info.u_team.u_team_core.gui.UGuiContainer;
import info.u_team.u_team_core.item.UItem;
import info.u_team.u_team_core.item.tool.UItemSword;
import info.u_team.u_team_core.sub.USubMod;
import net.minecraft.command.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.fml.common.network.*;

@Mod(modid = "test", name = "TestMod", version = "1.0.0", updateJSON = "http://files.minecraftforge.net/maven/net/minecraftforge/forge/promotions_slim.json")
public class TestMod extends USubMod implements IGuiHandler {
	
	public static UCreativeTab tab;
	
	public static UBlock block;
	public static UItem item;
	
	public static UItemSword sword;
	
	public static UBlockTileEntity blocktile;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		super.preinit(event);
		
		NetworkRegistry.INSTANCE.registerGuiHandler("test", this);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		super.init(event);
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event) {
		super.postinit(event);
	}
	
	@EventHandler
	public void server(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandBase() {
			
			@Override
			public String getUsage(ICommandSender sender) {
				return "Usage";
			}
			
			@Override
			public String getName() {
				return "test";
			}
			
			@Override
			public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
				
				// World world = server.worldServers[0];
				// EntityPlayer player = (EntityPlayer) sender.getCommandSenderEntity();
				// if (player == null) {
				// throw new CommandException("Only players can use this command!");
				// }
				//
				// BlockPos pos = player.getPosition();
				
				// world.markBlockRangeForRenderUpdate(pos.subtract(new BlockPos(30, 30, 30)),
				// pos.add(new BlockPos(30, 30, 30)));
				//
				// System.out.println("marked");
				
				// if (args.length == 1) {
				// int count = 0;
				// try {
				// count = Integer.valueOf(args[0]);
				// } catch (Exception ex) {
				// throw new CommandException("Arg 1 must be an int!", ex);
				// }
				// if (count == 0) {
				// throw new CommandException("Arg 1 must be > 0");
				// }
				//
				// BlockPos pos = player.getPosition();
				//
				// USchematicSaveRegion region = new USchematicSaveRegion(world, pos.add(-count,
				// 0, -count), pos.add(count, 0, count));
				// try {
				// USchematicWriter saver = new USchematicWriter(region, new
				// File("savefile.nbt"));
				// saver.finished((success, time) -> System.out.println("No error: " + success +
				// " - in " + time + " ms")).start();
				// } catch (IOException e) {
				// e.printStackTrace();
				// }
				//
				// } else if (args.length == 2) {
				// boolean center = false, rotate = false;
				// try {
				// center = Boolean.valueOf(args[0]);
				// rotate = Boolean.valueOf(args[1]);
				// } catch (Exception ex) {
				// throw new CommandException("Arg 1 and Arg 2 must be an boolean!", ex);
				// }
				//
				// BlockPos pos = player.getPosition();
				//
				// USchematicLoadRegion region = new USchematicLoadRegion(world,
				// pos).center().rotate(USchematicRotation.ROTATION_270);
				// try {
				// USchematicReader reader = new USchematicReader(region, new
				// File("savefile.nbt"));
				// reader.finished((success, time) -> System.out.println("No error: " + success
				// + " - in " + time + " ms")).start();
				// } catch (IOException e) {
				// e.printStackTrace();
				// }
				// }
				
			}
		});
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return new UContainer();
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return new UGuiContainer(new UContainer(), new ResourceLocation("textures/gui/container/furnace.png"));
	}
	
}
