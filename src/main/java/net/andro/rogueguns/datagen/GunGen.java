package net.andro.rogueguns.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import ttv.migami.jeg.common.*;
import ttv.migami.jeg.datagen.GunProvider;
import ttv.migami.jeg.init.ModItems;
import net.andro.rogueguns.Reference;
import net.andro.rogueguns.init.ModSounds;

import java.util.concurrent.CompletableFuture;

/**
 * Author: MrCrayfish
 */
public class GunGen extends GunProvider
{
    public GunGen(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries);
    }

    @Override
    protected void registerGuns()
    {

        this.addGun(new ResourceLocation(Reference.MOD_ID, "desert_eagle"), Gun.Builder.create()

                // General
                .setFireMode(FireMode.SEMI_AUTO)
                .setFireRate(16)
                .setGripType(GripType.TWO_HANDED)
                .setRecoilKick(1.5F)
                .setRecoilAngle(15.0F)
                .setAlwaysSpread(true)
                .setSpread(2.5F)

                // Reloads
                .setMaxAmmo(9)
                .setReloadType(ReloadType.MAG_FED)
                .setReloadTimer(30)
                .setEmptyMagTimer(10)

                // Projectile
                .setAmmo(ModItems.RIFLE_AMMO.get())
                .setEjectsCasing(true)
                .setProjectileVisible(false)
                .setDamage(7.5F)
                .setAdvantage(ModTags.Entities.HEAVY.location())
                .setProjectileSize(0.05F)
                .setProjectileSpeed(10.0F)
                .setProjectileLife(80)
                .setProjectileTrailLengthMultiplier(2)
                .setProjectileTrailColor(0xFFFF00)
                .setProjectileAffectedByGravity(false)

                // Sounds


                .build());



    }
}