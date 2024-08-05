package net.andro.rogueguns.client.render.gun.model;

import com.mojang.blaze3d.vertex.PoseStack;
import net.andro.rogueguns.client.SpecialModels;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import ttv.migami.jeg.client.render.gun.IOverrideModel;
import ttv.migami.jeg.client.util.RenderUtil;

public class Rapid_SMGModel implements IOverrideModel {

    @SuppressWarnings("resource")
    @Override
    public void render(float partialTicks, ItemDisplayContext ItemDisplayContext, ItemStack stack, ItemStack parent, LivingEntity entity, PoseStack matrixStack, MultiBufferSource buffer, int light, int overlay) {

        //Renders the static parts of the model.
        RenderUtil.renderModel(SpecialModels.RAPID_SMG.getModel(), stack, matrixStack, buffer, light, overlay);

    }



}