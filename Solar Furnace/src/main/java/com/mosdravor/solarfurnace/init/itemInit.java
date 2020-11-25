package com.mosdravor.solarfurnace.init;

import java.util.function.Supplier;

import com.mosdravor.solarfurnace.SolarFurnace;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid =SolarFurnace.MOD_ID, bus =Bus.MOD  )
@ObjectHolder(SolarFurnace.MOD_ID)
public class itemInit {

	//basic items
	public static final Item soft_stone          = null; 
	
	//Tools
	public static final Item shapedstone_sword   = null; 
	public static final Item shapedstone_pickaxe = null; 
	public static final Item shapedstone_shovel  = null; 
	public static final Item shapedstone_axe     = null; 
	public static final Item shapedstone_hoe     = null; 
	
	
	
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event){
		
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("soft_stone")); 
		
		
		//Tools
		event.getRegistry().register(new SwordItem(ModItemTier.shapedstone, 3, 1.6f ,new Item.Properties().group(SolarFurnace.solarfurnaceItemGroup.instance)).setRegistryName("shapedstone_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.shapedstone, 3, 1.0f ,new Item.Properties().group(SolarFurnace.solarfurnaceItemGroup.instance)).setRegistryName("shapedstone_pickaxe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.shapedstone, 3, 1.0f ,new Item.Properties().group(SolarFurnace.solarfurnaceItemGroup.instance)).setRegistryName("shapedstone_shovel"));
		event.getRegistry().register(new AxeItem(ModItemTier.shapedstone, 3, 1.3f ,new Item.Properties().group(SolarFurnace.solarfurnaceItemGroup.instance)).setRegistryName("shapedstone_axe"));
		event.getRegistry().register(new HoeItem(ModItemTier.shapedstone,3, 0.8f, new Item.Properties().group(SolarFurnace.solarfurnaceItemGroup.instance)).setRegistryName("shapedstone_hoe"));
		
		
	}
	
	public enum ModItemTier implements IItemTier{
		
		//stats for new item tiers
		//int havestlevel, int maxuses,float efficiency, float attackDamage, int enchantability, supplier<Ingredient>, repairMaterial
		shapedstone(2,235,3.0f,2.0f,15, () ->{
			return Ingredient.fromItems(itemInit.soft_stone); 
		});
		
		private final int harvestLevel; 
		private final int MaxUses; 
		private final float efficiency; 
		private final float attackDamage; 
		private final int enchantability; 
		private final LazyValue<Ingredient> repairMaterial; 
		
		private ModItemTier(int harvestLevel, int MaxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
			
			this.harvestLevel = harvestLevel; 
			this.MaxUses = MaxUses; 
			this.efficiency = efficiency; 
			this.attackDamage = attackDamage; 
			this.enchantability = enchantability; 
			this.repairMaterial = new LazyValue<>(repairMaterial); 
		}

		@Override
		public int getMaxUses() {
			
			return this.MaxUses;
		}

		@Override
		public float getEfficiency() {
		
			return  this.efficiency;
		}

		@Override
		public float getAttackDamage() {
			
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel() {
			
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability() {
			
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial() {
			
			return this.repairMaterial.getValue();
		}
	}
}







