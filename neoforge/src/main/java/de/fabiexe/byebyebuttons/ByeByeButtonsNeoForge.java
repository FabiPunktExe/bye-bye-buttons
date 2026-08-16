package de.fabiexe.byebyebuttons;

import de.fabiexe.byebyebuttons.config.ByeByeButtonsConfig;
import de.fabiexe.byebyebuttons.config.ConfigPart;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.HashMap;
import java.util.Map;

@Mod(value = "bye_bye_buttons", dist = Dist.CLIENT)
public final class ByeByeButtonsNeoForge {
    private final Map<ConfigPart<?>, ModConfigSpec.ConfigValue<?>> configValues = new HashMap<>();

    public ByeByeButtonsNeoForge(IEventBus modEventBus, ModContainer container) {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        for (ConfigPart<?> configPart : ByeByeButtonsConfig.ALL_CONFIG_PARTS) {
            builder.translation("bye_bye_buttons.config." + configPart.getName());
            configValues.put(configPart, builder.define(configPart.getName(), (boolean) configPart.getDefaultValue()));
        }
        ModConfigSpec configSpec = builder.build();

        container.registerConfig(ModConfig.Type.CLIENT, configSpec);
        container.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
        modEventBus.addListener(ModConfigEvent.Loading.class, _ -> syncConfig());
        modEventBus.addListener(ModConfigEvent.Reloading.class, _ -> syncConfig());
    }

    private void syncConfig() {
        ByeByeButtonsConfig.ALL_CONFIG_PARTS.forEach(this::syncConfigPart);
    }

    @SuppressWarnings("unchecked")
    private <T> void syncConfigPart(ConfigPart<T> configPart) {
        configPart.set((T) configValues.get(configPart).get());
    }
}