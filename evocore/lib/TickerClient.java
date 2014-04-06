package evocore.lib;

import java.util.EnumSet;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiScreen;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class TickerClient implements ITickHandler {
	
	@Override
	public void tickStart(EnumSet type, Object... tickData)
	{}
	@Override
	public void tickEnd(EnumSet type, Object... tickData)
	{
	if(type.equals(EnumSet.of(TickType.RENDER)))
	{
	onRenderTick();
	}else if(type.equals(EnumSet.of(TickType.CLIENT)))
	{
	GuiScreen curScreen = Minecraft.getMinecraft().currentScreen;
	if(curScreen != null)
	{
	onTickInGui(FMLClientHandler.instance().getClient(), curScreen);
	}else
	{
	onTickInGame(FMLClientHandler.instance().getClient());
	}
	}
	}
	private void onTickInGame(Minecraft mc){}
	private void onTickInGui(Minecraft mc, GuiScreen gui){}
	private void onRenderTick()
	{
	GuiIngame gig = new GuiIngame(minecraft);GL11.glBindTexture(GL11.GL_TEXTURE_2D, minecraft.renderEngine.getTexture(mc.mcMetaDir + "/filepath/to/image.png"));gig.drawTexturedModalRect(5, 5, 0, 0, 5, 102);
	Minecraft mc = FMLClientHandler.instance().getClient();
	if(mc.currentScreen == null){}
	}
	@Override
	public EnumSet ticks()
	{
	return EnumSet.of(TickType.CLIENT, TickType.RENDER);
	}@Override
	public String getLabel(){
	return "TickHandler.CLIENT";
	}
	}
