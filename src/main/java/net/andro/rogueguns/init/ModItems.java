package net.andro.rogueguns.init;

import net.andro.rogueguns.Reference;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ttv.migami.jeg.item.GunItem;


/**
 * This class is where all of the mod's item are registered.
 */

public class ModItems {

    /*
     * This creates a Deferred Register where all of the items will be registered
     * This is called and added to the event bus in the main mod file
     */


    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    //Gun Items
    public static final RegistryObject<GunItem> DESERT_EAGLE = ITEMS.register("desert_eagle",
        () -> new GunItem(new Item.Properties().stacksTo(1).durability(400).rarity(Rarity.RARE)
    ));
    public static final RegistryObject<GunItem> RAPID_SMG = ITEMS.register("rapid_smg",
            () -> new GunItem(new Item.Properties().stacksTo(1).durability(554).rarity(Rarity.EPIC)
    ));
    public static final RegistryObject<GunItem> HAUNTED_SHOTGUN = ITEMS.register("haunted_shotgun",
            () -> new GunItem(new Item.Properties().stacksTo(1).durability(673).rarity(Rarity.EPIC)
            ));
    //Ammo Items




}
