package info.u_team.u_team_test.dimension;

import info.u_team.u_team_test.init.TestBiomes;
import net.minecraft.world.biome.provider.*;
import net.minecraft.world.dimension.*;
import net.minecraft.world.gen.*;

public class DimensionBasic extends OverworldDimension {
	
	public DimensionBasic(DimensionType type) {
		super(type);
	}
	
	@Override
	public IChunkGenerator<? extends IChunkGenSettings> createChunkGenerator() {
		ChunkGeneratorType<OverworldGenSettings, ChunkGeneratorOverworld> chunkgenerator = ChunkGeneratorType.SURFACE;
		BiomeProviderType<SingleBiomeProviderSettings, SingleBiomeProvider> biomeprovidertype = BiomeProviderType.FIXED;
		
		OverworldGenSettings overworldgensettings = chunkgenerator.createSettings();
		SingleBiomeProviderSettings overworldbiomeprovidersettings = biomeprovidertype.createSettings().setBiome(TestBiomes.basic);
		return chunkgenerator.create(this.world, biomeprovidertype.create(overworldbiomeprovidersettings), overworldgensettings);
	}
	
}