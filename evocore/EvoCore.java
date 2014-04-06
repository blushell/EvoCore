package evocore;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import evocore.lib.ModInfo;
import evocore.lib.TickerClient;
import evocore.proxies.CommonProxy;

@Mod( modid = ModInfo.ID, name = ModInfo.NAME, version = ModInfo.VERSION )
@NetworkMod(clientSideRequired = true, serverSideRequired = true)

public class EvoCore {
	
	@SidedProxy( clientSide= ModInfo.PROXY_LOCATION + ".ClientProxy", serverSide= ModInfo.PROXY_LOCATION + ".CommonProxy")
	
	public static CommonProxy proxy;

	@EventHandler
	public void preInit ( FMLPreInitializationEvent event ) {
		
	}
	
	@EventHandler 
	public void load(FMLInitializationEvent event){		
	proxy.registerProxyThings();
	TickRegistry.registerTickHandler(new TickerClient(), Side.CLIENT);
	};
}