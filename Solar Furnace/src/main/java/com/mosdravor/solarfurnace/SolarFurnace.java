package com.mosdravor.solarfurnace;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.mosdravor.solarfurnace.init.itemInit;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("solarfurnace")
public class SolarFurnace
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public  static final String MOD_ID = "solarfurnace";
    public  static SolarFurnace instance; 

    public SolarFurnace() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        instance = this; 
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
       
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) 
    {
       
    }

    public static class solarfurnaceItemGroup extends ItemGroup{
    	
    	public static final solarfurnaceItemGroup instance = new solarfurnaceItemGroup(ItemGroup.GROUPS.length,"Solar-Furnace" ); 
    	private solarfurnaceItemGroup(int index, String label) {
    		super(index, label); 
    	}

		@Override
		public ItemStack createIcon() {
			
			return new ItemStack(itemInit.soft_stone); 
		}
    	
    }
}
