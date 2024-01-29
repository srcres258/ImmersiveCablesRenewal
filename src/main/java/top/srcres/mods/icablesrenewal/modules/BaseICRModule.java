// SPDX-License-Identifier: LGPL-3.0-only

package top.srcres.mods.icablesrenewal.modules;

import org.jetbrains.annotations.NotNull;
import top.srcres.mods.icablesrenewal.api.modules.IICRModule;
import top.srcres.mods.icablesrenewal.api.modules.IICRModuleManager;

public abstract class BaseICRModule implements IICRModule {
    private String moduleId;
    private IICRModuleManager moduleManager;
    private boolean coreModule;

    public BaseICRModule(String moduleId, boolean coreModule) {
        this.moduleId = moduleId;
        this.coreModule = coreModule;
    }

    public BaseICRModule(String moduleId) {
        this(moduleId, false);
    }

    @Override
    public void onConstruct(@NotNull IICRModuleManager moduleManager) {
        this.moduleManager = moduleManager;
    }

    @Override
    public String getModuleId() {
        return moduleId;
    }

    @Override
    public IICRModuleManager getModuleManager() {
        return moduleManager;
    }

    @Override
    public boolean isCoreModule() {
        return coreModule;
    }
}
