package r3qu13m.mc;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.IItemRenderer;

public class CommonProxy {
	public void registerTexture(String par1Path) {

	}

	public void registerTickHandler(String par1Class, Side par2Side) {
		try {
			if (FMLCommonHandler.instance().getSide() == par2Side) {
				TickRegistry.registerTickHandler((ITickHandler) Class.forName(par1Class).newInstance(), par2Side);
			}
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void registerTileEntity(Class<? extends TileEntity> par1TileEntity, String par2Id) {
		GameRegistry.registerTileEntity(par1TileEntity, par2Id);
	}

	public void registerTileEntity(Class<? extends TileEntity> par1TileEntity, String par2Id,
			String par3SpecialRenderer) {
		GameRegistry.registerTileEntity(par1TileEntity, par2Id);
	}

	public void registerItemRenderer(int itemID, IItemRenderer renderer) {

	}
}
