package info.u_team.u_team_core.data;

import net.minecraft.entity.EntityType;
import net.minecraft.util.registry.Registry;

public abstract class CommonEntityTypeTagsProvider extends CommonTagsProvider<EntityType<?>> {
	
	@SuppressWarnings("deprecation")
	public CommonEntityTypeTagsProvider(GenerationData data) {
		super(data, Registry.ENTITY_TYPE);
	}
	
	@Override
	protected String getTagFolder() {
		return "entity_types";
	}
	
	@Override
	public String getName() {
		return "Entity-Type-Tags";
	}
}
