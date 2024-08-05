package net.andro.rogueguns.client;


import net.andro.rogueguns.Reference;
import net.andro.rogueguns.client.render.gun.model.*;
import net.andro.rogueguns.init.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.EnchantedBookItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ttv.migami.jeg.client.CustomGunManager;
import ttv.migami.jeg.client.render.gun.ModelOverrides;
import ttv.migami.jeg.enchantment.EnchantmentTypes;
import ttv.migami.jeg.item.GunItem;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT)
public class ClientHandler {

    public static void setup() {
        registerModelOverrides();
    }

    private static void registerModelOverrides() {


        //  Non Animated Models
        ModelOverrides.register(ModItems.DESERT_EAGLE.get(), new Desert_EagleModel());
        ModelOverrides.register(ModItems.RAPID_SMG.get(), new Rapid_SMGModel());
        ModelOverrides.register(ModItems.HAUNTED_SHOTGUN.get(), new Haunted_ShotgunModel());
    }

    public static void onRegisterCreativeTab(IEventBus bus)
    {
        DeferredRegister<CreativeModeTab> register = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Reference.MOD_ID);
        CreativeModeTab.Builder builder = CreativeModeTab.builder();
        builder.title(Component.translatable("itemGroup." + Reference.MOD_ID));
        builder.icon(() -> {



            //Non Animated Models
            ItemStack stack = new ItemStack(ModItems.DESERT_EAGLE.get());
            stack.getOrCreateTag().putBoolean("IgnoreAmmo", true);
            return stack;


        });
        builder.displayItems((flags, output) ->
        {
            ModItems.ITEMS.getEntries().forEach(itemRegistryObject ->
            {
                if (itemRegistryObject.get() instanceof GunItem item) {
                    ItemStack stack = new ItemStack(item);
                    stack.getOrCreateTag().putInt("AmmoCount", item.getGun().getReloads().getMaxAmmo());
                    output.accept(stack);
                    return;
                }
                output.accept(itemRegistryObject.get());
            });
            CustomGunManager.fill(output);
            for (Enchantment enchantment : ForgeRegistries.ENCHANTMENTS) {
                if (enchantment.category == EnchantmentTypes.GUN || enchantment.category == EnchantmentTypes.SEMI_AUTO_GUN) {
                    output.accept(EnchantedBookItem.createForEnchantment(new EnchantmentInstance(enchantment, enchantment.getMaxLevel())), CreativeModeTab.TabVisibility.PARENT_TAB_ONLY);
                }
            }
        });
        register.register("creative_tab", builder::build);
        register.register(bus);

        }
    }




