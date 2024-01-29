package top.srcres.mods.icablesrenewal.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import top.srcres.mods.icablesrenewal.ImmersiveCablesRenewal;

public class DeferredRegisters {
    public static DeferredRegister<Block> BLOCKS = null;
    public static DeferredRegister<Item> ITEMS = null;
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = null;

    public static void init() {
        BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ImmersiveCablesRenewal.MODID);
        ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ImmersiveCablesRenewal.MODID);
        CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ImmersiveCablesRenewal.MODID);

        IEventBus bus = ImmersiveCablesRenewal.getInstance().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        CREATIVE_MODE_TABS.register(bus);
    }
}
