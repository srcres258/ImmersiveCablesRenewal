package top.srcres.mods.icablesrenewal.api.modules;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * The specification of the module manager of ImmersiveCablesRenewal.
 */
public interface IICRModuleManager {
    /**
     * Load a module from the given module class.
     * @param moduleClass The module class that will be used to load from.
     */
    void loadModule(@NotNull Class<? extends IICRModule> moduleClass);

    /**
     * Initialize the modules that have been loaded by this manager.
     */
    void doModulesInit();

    /**
     * Gets a list of modules managed by this manager.
     * @return The list of modules managed by this manager.
     */
    List<IICRModule> getModuleList();
}
