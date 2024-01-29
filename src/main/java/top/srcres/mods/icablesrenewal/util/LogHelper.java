// SPDX-License-Identifier: LGPL-3.0-only

package top.srcres.mods.icablesrenewal.util;

import org.slf4j.Logger;
import top.srcres.mods.icablesrenewal.ImmersiveCablesRenewal;

public class LogHelper {
    public static Logger getLogger() {
        return ImmersiveCablesRenewal.getInstance().getModLogger();
    }

    public static void trace(String msg) {
        getLogger().trace(msg);
    }
    public static void trace(String msg, Object arg1) {
        getLogger().trace(msg, arg1);
    }
    public static void trace(String msg, Object arg1, Object arg2) {
        getLogger().trace(msg, arg1, arg2);
    }
    public static void trace(String msg, Object... args) {
        getLogger().trace(msg, args);
    }

    public static void debug(String msg) {
        getLogger().debug(msg);
    }
    public static void debug(String msg, Object arg1) {
        getLogger().debug(msg, arg1);
    }
    public static void debug(String msg, Object arg1, Object arg2) {
        getLogger().debug(msg, arg1, arg2);
    }
    public static void debug(String msg, Object... args) {
        getLogger().debug(msg, args);
    }

    public static void info(String msg) {
        getLogger().info(msg);
    }
    public static void info(String msg, Object arg1) {
        getLogger().info(msg, arg1);
    }
    public static void info(String msg, Object arg1, Object arg2) {
        getLogger().info(msg, arg1, arg2);
    }
    public static void info(String msg, Object... args) {
        getLogger().info(msg, args);
    }

    public static void warn(String msg) {
        getLogger().warn(msg);
    }
    public static void warn(String msg, Object arg1) {
        getLogger().warn(msg, arg1);
    }
    public static void warn(String msg, Object arg1, Object arg2) {
        getLogger().warn(msg, arg1, arg2);
    }
    public static void warn(String msg, Object... args) {
        getLogger().warn(msg, args);
    }

    public static void error(String msg) {
        getLogger().error(msg);
    }
    public static void error(String msg, Object arg1) {
        getLogger().error(msg, arg1);
    }
    public static void error(String msg, Object arg1, Object arg2) {
        getLogger().error(msg, arg1, arg2);
    }
    public static void error(String msg, Object... args) {
        getLogger().error(msg, args);
    }
}
