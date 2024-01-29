// SPDX-License-Identifier: LGPL-3.0-only

package top.srcres.mods.icablesrenewal.api.modules;

/**
 * The runtime exception thrown whenever a module is failed to be loaded.
 */
public class ModuleLoadFailureException extends ModuleException {
    public ModuleLoadFailureException() {
    }
    public ModuleLoadFailureException(String message) {
        super(message);
    }
    public ModuleLoadFailureException(String message, Throwable cause) {
        super(message, cause);
    }
    public ModuleLoadFailureException(Throwable cause) {
        super(cause);
    }
    public ModuleLoadFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
