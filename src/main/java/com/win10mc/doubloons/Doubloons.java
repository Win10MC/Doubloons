package com.win10mc.doubloons;

import com.win10mc.doubloons.block.ModBlocks;
import com.win10mc.doubloons.item.ModItems;
import com.win10mc.doubloons.loot.LootTableHandler;
import com.win10mc.doubloons.villager.ModVillagers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Doubloons implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger(ModInformation.Id);

	@Override
	public void onInitialize() {
		ModItems.register();
		ModBlocks.register();
		LootTableHandler.register();
		ModVillagers.register();
		ModVillagers.registerTrades();
	}
}
