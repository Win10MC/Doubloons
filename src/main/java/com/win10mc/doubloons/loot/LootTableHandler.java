package com.win10mc.doubloons.loot;

import com.win10mc.doubloons.item.ModItems;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKey;

public class LootTableHandler {

	private static final RegistryKey<LootTable> BURIED_TREASURE_KEY = LootTables.BURIED_TREASURE_CHEST;

	public static void register() {
		LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
			if (key.equals(BURIED_TREASURE_KEY)) {
				LootPool.Builder lootBuilder = LootPool.builder()
						.with(ItemEntry.builder(ModItems.DOUBLOON)).apply(
								SetCountLootFunction.builder(
										UniformLootNumberProvider.create(1.0f, 5.0f)).build()).rolls(
												ConstantLootNumberProvider.create(3));
				tableBuilder.pool(lootBuilder);
			}
		});
	}

}
