package top.srcres.mods.icablesrenewal.util;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.LoadingModList;
import net.minecraftforge.fml.loading.moddiscovery.ModInfo;
import net.minecraftforge.forgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class FMLHelper {
    public static boolean isModLoaded(String modId) {
        if (ModList.get() == null) {
            Stream<String> s = LoadingModList.get().getMods().stream().map(ModInfo::getModId);
            Objects.requireNonNull(s);
            return s.anyMatch(modId::equals);
        } else {
            return ModList.get().isLoaded(modId);
        }
    }

    public static Set<String> discoverClassesAnnotated(Type annotationType) {
        HashSet<String> result = new HashSet<>();

        for (ModFileScanData scanData : ModList.get().getAllScanData()) {
            for (ModFileScanData.AnnotationData annoData : scanData.getAnnotations()) {
                if (annoData.annotationType().equals(annotationType)) {
                    result.add(annoData.memberName());
                }
            }
        }

        return result;
    }
}
