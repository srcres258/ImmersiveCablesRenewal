package top.srcres.mods.icablesrenewal.modules;

import top.srcres.mods.icablesrenewal.api.modules.IICRModSpecModule;
import top.srcres.mods.icablesrenewal.util.FMLHelper;

public abstract class BaseICRModSpecModule extends BaseICRModule implements IICRModSpecModule {
    private String specModId;

    public BaseICRModSpecModule(String moduleId, String specModId, boolean coreModule) {
        super(moduleId, coreModule);
        this.specModId = specModId;
    }

    public BaseICRModSpecModule(String moduleId, String specModId) {
        super(moduleId);
        this.specModId = specModId;
    }

    @Override
    public String getSpecModId() {
        return specModId;
    }

    @Override
    public boolean isAvailable() {
        return FMLHelper.isModLoaded(specModId);
    }
}
