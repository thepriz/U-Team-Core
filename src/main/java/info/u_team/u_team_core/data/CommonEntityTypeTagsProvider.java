package info.u_team.u_team_core.data;

import java.nio.file.Path;

import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

public abstract class CommonEntityTypeTagsProvider extends CommonTagsProvider<EntityType<?>> {
	
	@SuppressWarnings("deprecation")
	public CommonEntityTypeTagsProvider(GenerationData data) {
		super(data, Registry.ENTITY_TYPE);
	}
	
	@Override
	protected Path makePath(ResourceLocation location) {
		return resolveData(location).resolve("tags").resolve("entity_types").resolve(location.getPath() + ".json");
	}
	
	@Override
	public String getName() {
		return "Entity-Type-Tags";
	}
}