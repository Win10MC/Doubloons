package com.win10mc.doubloons.datagen;

import com.win10mc.doubloons.block.ModBlocks;
import com.win10mc.doubloons.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void generate(RecipeExporter exporter) {
		offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.DOUBLOON, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DOUBLOON_BLOCK);
		ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.BARTERING_BLOCK)
				.pattern(" D ")
				.pattern("DGD")
				.pattern(" D ")
				.input('D', ModItems.DOUBLOON)
				.input('G', Blocks.GOLD_BLOCK)
				.criterion("has_material", conditionsFromItem(ModItems.DOUBLOON))
				.criterion("has_material", conditionsFromItem(Blocks.GOLD_BLOCK))
				.offerTo(exporter);
	}
}