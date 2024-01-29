package top.srcres.mods.icablesrenewal;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ImmersiveCablesRenewal.MODID)
public class ImmersiveCablesRenewal {
    public static final String MODID = "icablesrenewal";

    private static ImmersiveCablesRenewal _instance = null;
    private Logger modLogger;
    private IEventBus modEventBus;
    private ICRBootstrap bootstrap;

    public ImmersiveCablesRenewal() {
        _instance = this;
        modLogger = LogUtils.getLogger();
        modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        bootstrap = new ICRBootstrap();
        bootstrap.doCoreInit();
        bootstrap.discoverModules();
        bootstrap.doModulesInit();
    }

    public static ImmersiveCablesRenewal getInstance() {
        return _instance;
    }

    public Logger getModLogger() {
        return modLogger;
    }

    public IEventBus getModEventBus() {
        return modEventBus;
    }
}
