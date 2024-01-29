// SPDX-License-Identifier: LGPL-3.0-only

package top.srcres.mods.icablesrenewal.api.modules;

/**
 * The runtime exception about modules.
 */
public class ModuleException extends RuntimeException {
    public ModuleException() {
    }
    public ModuleException(String message) {
        super(message);
    }
    public ModuleException(String message, Throwable cause) {
        super(message, cause);
    }
    public ModuleException(Throwable cause) {
        super(cause);
    }
    public ModuleException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
