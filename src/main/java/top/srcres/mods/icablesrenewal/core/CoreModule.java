package top.srcres.mods.icablesrenewal.core;

import net.minecraftforge.eventbus.api.IEventBus;
import org.jetbrains.annotations.NotNull;
import top.srcres.mods.icablesrenewal.api.modules.ICRModule;
import top.srcres.mods.icablesrenewal.modules.BaseICRModule;
import top.srcres.mods.icablesrenewal.util.LogHelper;

@ICRModule
public class CoreModule extends BaseICRModule {
    public CoreModule() {
        super("core", true);
    }

    @Override
    public void onInit() {
        LogHelper.info("onInit from CoreModule");
    }

    @Override
    public void onRegisterListener(@NotNull IEventBus eventBus) {
        LogHelper.info("onRegisterListener from CoreModule");
    }
}
