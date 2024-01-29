// SPDX-License-Identifier: LGPL-3.0-only

package top.srcres.mods.icablesrenewal.api.modules;

/**
 * An ImmersiveCablesRenewal module but with an additional specific mod that this module serves for.
 */
public interface IICRModSpecModule extends IICRModule {
    /**
     * Gets the modid of the mod that this module is targeted towards.
     * @return The mod id of the mod that this module is targeted towards.
     */
    String getSpecModId();
}
