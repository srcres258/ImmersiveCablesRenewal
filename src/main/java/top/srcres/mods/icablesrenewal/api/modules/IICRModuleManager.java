// SPDX-License-Identifier: LGPL-3.0-only

package top.srcres.mods.icablesrenewal.api.modules;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
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

    /**
     * Ask the managed modules to build up their own configurations for the mod.
     * @param builder The builder used to build configurations.
     * @param type The type of configuration to be built.
     */
    void processBuildModConfig(@NotNull ForgeConfigSpec.Builder builder, @NotNull ModConfig.Type type);
}
