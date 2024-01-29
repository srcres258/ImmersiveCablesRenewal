package top.srcres.mods.icablesrenewal.modules;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import org.jetbrains.annotations.NotNull;
import top.srcres.mods.icablesrenewal.ImmersiveCablesRenewal;
import top.srcres.mods.icablesrenewal.api.modules.ICRModule;
import top.srcres.mods.icablesrenewal.api.modules.IICRModule;
import top.srcres.mods.icablesrenewal.api.modules.IICRModuleManager;
import top.srcres.mods.icablesrenewal.api.modules.ModuleLoadFailureException;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class ICRModuleManager implements IICRModuleManager {
    public LinkedList<IICRModule> moduleList = new LinkedList<>();

    @Override
    public void loadModule(@NotNull Class<? extends IICRModule> moduleClass) {
        ICRModule anno = moduleClass.getAnnotation(ICRModule.class);
        if (anno == null)
            throw loadFailEx(moduleClass.getCanonicalName(), new IllegalArgumentException(String.format(
                    "Attempting to load a module whose type %s is not associated with @ICRModule.",
                    moduleClass.getCanonicalName())));

        IICRModule moduleObj;
        try {
            moduleObj = moduleClass.getConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException ex) {
            throw loadFailEx(moduleClass.getCanonicalName(), ex);
        }
        if (moduleObj.isAvailable()) {
            moduleObj.onConstruct(this);
            moduleList.add(moduleObj);
        }
    }

    @Override
    public void doModulesInit() {
        initCoreModules();
        initNonCoreModules();

        for (IICRModule module : moduleList) {
            module.onRegisterListener(ImmersiveCablesRenewal.getInstance().getModEventBus());
        }
    }

    private void initCoreModules() {
        for (IICRModule module : moduleList) {
            if (module.isCoreModule()) {
                module.onInit();
            }
        }
    }

    private void initNonCoreModules() {
        for (IICRModule module : moduleList) {
            if (!module.isCoreModule()) {
                module.onInit();
            }
        }
    }

    @Override
    public List<IICRModule> getModuleList() {
        return moduleList;
    }

    @Override
    public void processBuildModConfig(@NotNull ForgeConfigSpec.Builder builder, @NotNull ModConfig.Type type) {
        for (IICRModule module : moduleList) {
            module.onBuildModConfig(builder, type);
        }
    }

    private static ModuleLoadFailureException loadFailEx(String className, Exception cause) {
        return new ModuleLoadFailureException(String.format("Failed to load module: %s", className), cause);
    }
}
