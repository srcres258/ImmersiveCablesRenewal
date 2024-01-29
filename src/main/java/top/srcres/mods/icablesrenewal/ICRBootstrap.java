package top.srcres.mods.icablesrenewal;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.objectweb.asm.Type;
import top.srcres.mods.icablesrenewal.api.IICRBootstrap;
import top.srcres.mods.icablesrenewal.api.modules.ICRModule;
import top.srcres.mods.icablesrenewal.api.modules.IICRModule;
import top.srcres.mods.icablesrenewal.modules.ICRModuleManager;
import top.srcres.mods.icablesrenewal.util.FMLHelper;

import java.util.Objects;
import java.util.Set;

public class ICRBootstrap implements IICRBootstrap {
    @Override
    public void doCoreInit() {
        ICRCore.moduleManager = new ICRModuleManager();
    }

    @Override
    public void discoverModules() {
        ICRModuleManager manager = ICRCore.moduleManager;
        Objects.requireNonNull(manager);

        Set<String> discoveredClasses = FMLHelper.discoverClassesAnnotated(Type.getType(ICRModule.class));
        for (String clsName : discoveredClasses) {
            Class<? extends IICRModule> cls;
            try {
                cls = Class.forName(clsName).asSubclass(IICRModule.class);
            } catch (ClassNotFoundException ex) {
                throw new IllegalStateException(
                        "The discovered module class is not found by the class loader. This should not happen.", ex);
            }
            manager.loadModule(cls);
        }
    }

    @Override
    public void doModulesInit() {
        ICRCore.moduleManager.doModulesInit();
    }

    @Override
    public void buildModConfig() {
        ICRModuleManager manager = ICRCore.moduleManager;

        for (ModConfig.Type type : ModConfig.Type.values()) {
            ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
            manager.processBuildModConfig(builder, type);
            ModLoadingContext.get().registerConfig(type, builder.build());
        }
    }
}
