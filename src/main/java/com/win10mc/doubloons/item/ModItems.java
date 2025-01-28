package com.win10mc.doubloons.item;

import com.win10mc.doubloons.ModInformation;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
	public static final Item DOUBLOON = new Item(new Item.Settings());

	public static void register() {
		Registry.register(Registries.ITEM, Identifier.of(ModInformation.Id, "doubloon"), DOUBLOON);
	}
}
