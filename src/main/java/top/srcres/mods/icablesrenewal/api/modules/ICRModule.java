// SPDX-License-Identifier: LGPL-3.0-only

package top.srcres.mods.icablesrenewal.api.modules;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * An annotation used to mark a module class to be detected by ImmersiveCablesRenewal so as to be loaded.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ICRModule {
}
