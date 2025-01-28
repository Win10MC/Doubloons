package com.win10mc.doubloons.block;

import com.win10mc.doubloons.Doubloons;
import com.win10mc.doubloons.ModInformation;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

	public static final Block DOUBLOON_BLOCK = registerBlock("doubloon_block", new Block(AbstractBlock.Settings.create()
		.strength(3f)
		.requiresTool()
	));

	public static final Block BARTERING_BLOCK = registerBlock("bartering_block", new Block(AbstractBlock.Settings.create()
			.strength(3f)
			.requiresTool()
	));

	private static Block registerBlock(String name, Block block) {
		registerBlockItem(name, block);
		return Registry.register(Registries.BLOCK, Identifier.of(ModInformation.Id, name), block);
	}

	private static void registerBlockItem(String name, Block block) {
		Registry.register(Registries.ITEM, Identifier.of(ModInformation.Id, name),
				new BlockItem(block, new Item.Settings()));
	}

	public static void register() {
		Doubloons.LOGGER.info("Registering blocks");
	}

}
