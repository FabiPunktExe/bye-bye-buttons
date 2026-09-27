package de.fabiexe.byebyebuttons;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import de.fabiexe.mmp.config.ConfigClothConfig;

public final class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        return parent -> ConfigClothConfig.createScreen(parent, ByeByeButtonsConfig.CONFIG, "bye_bye_buttons");
    }
}