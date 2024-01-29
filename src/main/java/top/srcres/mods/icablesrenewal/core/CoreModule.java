// SPDX-License-Identifier: LGPL-3.0-only

package top.srcres.mods.icablesrenewal.core;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import top.srcres.mods.icablesrenewal.api.modules.ICRModule;
import top.srcres.mods.icablesrenewal.modules.BaseICRModule;
import top.srcres.mods.icablesrenewal.util.DeferredRegisters;
import top.srcres.mods.icablesrenewal.util.LogHelper;

@ICRModule
public class CoreModule extends BaseICRModule {
    private ForgeConfigSpec.IntValue configTestNumber = null;
    private RegistryObject<Item> sampleItem;
    private RegistryObject<CreativeModeTab> sampleCreativeModTab;

    public CoreModule() {
        super("core", true);
    }

    @Override
    public void onInit() {
        LogHelper.info("onInit from CoreModule");
        sampleItem = DeferredRegisters.ITEMS.register("example_item", () -> new Item(
                new Item.Properties().food(new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(2f).build())));
        sampleCreativeModTab = DeferredRegisters.CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
                .withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> sampleItem.get().getDefaultInstance()).displayItems((params, output) -> output.accept(sampleItem.get())).build());
    }

    @Override
    public void onRegisterListener(@NotNull IEventBus eventBus) {
        LogHelper.info("onRegisterListener from CoreModule");
        eventBus.addListener(this::onModConfigLoading);
    }

    @Override
    public void onBuildModConfig(ForgeConfigSpec.@NotNull Builder builder, ModConfig.@NotNull Type type) {
        LogHelper.info("onBuildModConfig from CoreModule, type {}", type.toString());
        if (type.equals(ModConfig.Type.COMMON)) {
            configTestNumber = builder.comment("test number").defineInRange("testNumber", 50, 0, 100);
        }
    }

    private void onModConfigLoading(ModConfigEvent.Loading event) {
        LogHelper.info("test number: {}", configTestNumber.get());
    }
}
