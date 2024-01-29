package top.srcres.mods.icablesrenewal.api;

/**
 * The specification of bootstrap code of ImmersiveCablesRenewal.
 */
public interface IICRBootstrap {
    /**
     * Initialize core components of ImmersiveCablesRenewal.
     */
    void doCoreInit();

    /**
     * Discover all ImmersiveCablesRenewal's modules from FML.
     */
    void discoverModules();

    /**
     * Initialize the discovered modules.
     */
    void doModulesInit();
}
