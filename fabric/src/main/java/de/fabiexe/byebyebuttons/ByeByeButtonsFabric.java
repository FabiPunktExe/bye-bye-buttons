package de.fabiexe.byebyebuttons;

import de.fabiexe.mmp.config.ConfigClothConfig;
import net.fabricmc.api.ClientModInitializer;

public final class ByeByeButtonsFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ConfigClothConfig.load(ByeByeButtonsConfig.CONFIG, "bye_bye_buttons");
    }
}