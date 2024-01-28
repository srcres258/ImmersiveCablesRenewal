package top.srcres.mods.icablesrenewal;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(ImmersiveCablesRenewal.MODID)
public class ImmersiveCablesRenewal {
    public static final String MODID = "icablesrenewal";

    private static ImmersiveCablesRenewal _instance = null;
    public Logger modLogger;

    public ImmersiveCablesRenewal() {
        _instance = this;
        modLogger = LogUtils.getLogger();
    }

    public static ImmersiveCablesRenewal getInstance() {
        return _instance;
    }
}
