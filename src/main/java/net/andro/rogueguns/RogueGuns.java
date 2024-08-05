package net.andro.rogueguns;


import net.andro.rogueguns.client.ClientHandler;
import net.andro.rogueguns.init.ModItems;
import net.andro.rogueguns.init.ModSounds;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.world.item.CreativeModeTab;


import static net.andro.rogueguns.Reference.MOD_ID;

@Mod(MOD_ID)
public class RogueGuns {

    public RogueGuns() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::setup);
        bus.addListener(this::onClientSetup);
        MinecraftForge.EVENT_BUS.register(this);
        ModItems.ITEMS.register(bus);
        ModSounds.SOUNDS.register(bus);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            ClientHandler.onRegisterCreativeTab(bus);
        });
    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    //This is the client setup event.
    private void onClientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(ClientHandler::setup);
    }

}