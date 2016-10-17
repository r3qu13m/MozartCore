package r3qu13m.mc;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(name="MozartCore", modid="mozart_core", version="1.0.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false, channels={"MozartCore"})
public class Mozart {
	
	@SidedProxy(clientSide="r3qu13m.mc.client.ClientProxy", serverSide="r3qu13m.mc.CommonProxy")
	public static CommonProxy proxy; 
	
	@Mod.Init
	public void init(FMLInitializationEvent event) {
		SidedLogger.log("Mozart has been Initialized.");
	}
	
	@Mod.PreInit
	public void preinit(FMLPreInitializationEvent event) {
		SidedLogger.setDebug();
	}
}
