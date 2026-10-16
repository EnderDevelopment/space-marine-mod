package com.senchinsilvestr.spacemarinemod;

import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SpaceMarineMod implements ModInitializer {
    public static final String MOD_ID = "spacemarinemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    // Armor Materials
    public static final ArmorMaterial SPACE_MARINE_ARMOR_MATERIAL = new ArmorMaterial() {
        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            return new int[]{13, 15, 16, 11}[type.ordinal()] * 33;
        }

        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            return new int[]{3, 6, 8, 3}[type.ordinal()];
        }

        @Override
        public int getEnchantmentValue() {
            return 15;
        }

        @Override
        public SoundEvent getEquipSound() {
            return SoundEvents.ARMOR_EQUIP_IRON;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(Items.IRON_INGOT);
        }

        @Override
        public String getName() {
            return "space_marine";
        }

        @Override
        public float getToughness() {
            return 2.0F;
        }

        @Override
        public float getKnockbackResistance() {
            return 0.0F;
        }
    };

    // Items
    public static final Item SPACE_MARINE_HELMET = new ArmorItem(SPACE_MARINE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    public static final Item SPACE_MARINE_CHESTPLATE = new ArmorItem(SPACE_MARINE_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    public static final Item SPACE_MARINE_LEGGINGS = new ArmorItem(SPACE_MARINE_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    public static final Item SPACE_MARINE_BOOTS = new ArmorItem(SPACE_MARINE_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    public static final Item BOLTGUN = new SwordItem(Tiers.IRON, 3, -2.4F, new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));
    public static final Item BOLT = new Item(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT));

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Space Marine Mod");

        // Register Items
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "space_marine_helmet"), SPACE_MARINE_HELMET);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "space_marine_chestplate"), SPACE_MARINE_CHESTPLATE);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "space_marine_leggings"), SPACE_MARINE_LEGGINGS);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "space_marine_boots"), SPACE_MARINE_BOOTS);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "boltgun"), BOLTGUN);
        Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, "bolt"), BOLT);
    }
}