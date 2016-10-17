package r3qu13m.mc.client;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import r3qu13m.mc.CommonProxy;

public class ClientProxy extends CommonProxy {
	public void registerTexture(String par1Path) {
		MinecraftForgeClient.preloadTexture(par1Path);
	}

	@Override
	public void registerTickHandler(String par1Class, Side par2Side) {
		try {
			TickRegistry.registerTickHandler((ITickHandler) Class.forName(par1Class).newInstance(), par2Side);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void registerTileEntity(Class<? extends TileEntity> par1TileEntity, String par2Id,
			String par3SpecialRenderer) {
		try {
			ClientRegistry.registerTileEntity(par1TileEntity, par2Id,
					(TileEntitySpecialRenderer) Class.forName(par3SpecialRenderer).newInstance());
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void registerItemRenderer(int itemID, IItemRenderer renderer) {
		MinecraftForgeClient.registerItemRenderer(itemID, renderer);
	}
}
