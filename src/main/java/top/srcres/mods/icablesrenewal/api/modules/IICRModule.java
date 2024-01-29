package top.srcres.mods.icablesrenewal.api.modules;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.config.ModConfig;
import org.jetbrains.annotations.NotNull;

/**
 * The definition of basic contents for a module within ImmersiveCablesRenewal.
 * <p>
 * Note that all the classes which implement this interface must have a non-argument constructor so that they can
 * be loaded by the module manager properly.
 */
public interface IICRModule {
    /**
     * Gets the identification of this module.
     * @return The identification of this module.
     */
    String getModuleId();

    /**
     * Gets the name of this module.
     * @return The name of this module.
     */
    default String getModuleName() {
        return getModuleId();
    }

    /**
     * Gets the description of this module.
     * @return The description of this module.
     */
    default String getModuleDescription() {
        return "";
    }

    /**
     * Judges whether this module is a kernel module. A kernel module cannot be disabled by the module manager.
     * @return Whether this module is a kernel module.
     */
    default boolean isCoreModule() {
        return false;
    }

    /**
     * Judges whether this module is available. A module cannot be loaded if it is not available.
     * @return Whether this module is available.
     */
    default boolean isAvailable() {
        return true;
    }

    /**
     * Gets the module manager which this module belongs to.
     * @return The module manager which this module belongs to.
     */
    IICRModuleManager getModuleManager();

    /**
     * A callback that will be called immediately after the module is instantiated.
     * @param moduleManager The module manager that instantiated this module instance.
     */
    default void onConstruct(@NotNull IICRModuleManager moduleManager) {
    }

    /**
     * A callback used to initialize the module. All tasks around registry (registering blocks, items, etc.) should all
     * be done within this callback.
     */
    void onInit();

    /**
     * A callback aiming to complete the registration of the module's event bus listener.
     * @param eventBus ImmersiveCablesRenewal's mod event bus used to register listeners.
     */
    default void onRegisterListener(@NotNull IEventBus eventBus) {
    }

    /**
     * A callback used to build ImmersiveCablesRenewal's mod configuration.
     * @param builder The builder to create ImmersiveCablesRenewal's mod configuration.
     * @param type The type of the configuration being built.
     */
    default void onBuildModConfig(@NotNull ForgeConfigSpec.Builder builder, @NotNull ModConfig.Type type) {
    }
}
