package info.u_team.u_team_core.container;

import net.minecraft.inventory.container.*;

public abstract class FluidContainer extends Container {
	
	protected FluidContainer(ContainerType<?> type, int id) {
		super(type, id);
	}
}
