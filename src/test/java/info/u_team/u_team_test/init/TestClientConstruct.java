package info.u_team.u_team_test.init;

import info.u_team.u_team_core.api.construct.*;
import info.u_team.u_team_core.util.registry.BusRegister;
import info.u_team.u_team_test.TestMod;

@Construct(modid = TestMod.MODID, client = true)
public class TestClientConstruct implements IModConstruct {
	
	@Override
	public void construct() {
		BusRegister.registerMod(TestColors::registerMod);
		BusRegister.registerMod(TestKeys::registerMod);
		BusRegister.registerMod(TestModels::registerMod);
		BusRegister.registerMod(TestScreens::registerMod);
		
		BusRegister.registerForge(TestKeys::registerForge);
	}
	
}
