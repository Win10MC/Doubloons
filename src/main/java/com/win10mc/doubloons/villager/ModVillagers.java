package com.win10mc.doubloons.villager;

import com.google.common.collect.ImmutableSet;
import com.win10mc.doubloons.Doubloons;
import com.win10mc.doubloons.ModInformation;
import com.win10mc.doubloons.block.ModBlocks;
import com.win10mc.doubloons.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {

	public static final RegistryKey<PointOfInterestType> barterer_poi_key = registerPoiKey("barterer_poi");
	public static final PointOfInterestType barterer_poi = registerPOI("barterer_poi", ModBlocks.BARTERING_BLOCK);

	public static final VillagerProfession BARTERER = registerProfession("barterer", barterer_poi_key);

	private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
		return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(ModInformation.Id, name), new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type), ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
	}

	private static PointOfInterestType registerPOI(String name, Block block) {
		return PointOfInterestHelper.register(Identifier.of(ModInformation.Id, name), 1, 1, block);
	}

	private static RegistryKey<PointOfInterestType> registerPoiKey(String name) {
		return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(ModInformation.Id, name));
	}

	public static void registerTrades() {
		TradeOfferHelper.registerVillagerOffers(BARTERER, 1,
				factories -> {
					factories.add(((entity, random) -> new TradeOffer(
							new TradedItem(ModItems.DOUBLOON, 5),
							new ItemStack(Items.DIAMOND, 2),
							6, 2, 0.02f
					)));
				});
	}

	public static void register() {
		Doubloons.LOGGER.info("Registering Villagers");
	}
}
