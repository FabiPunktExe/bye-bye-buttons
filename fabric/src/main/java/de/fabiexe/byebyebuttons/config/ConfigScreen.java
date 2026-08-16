package de.fabiexe.byebyebuttons.config;

import de.fabiexe.byebyebuttons.ByeByeButtonsFabric;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.options.OptionsSubScreen;
import net.minecraft.network.chat.Component;

import java.util.Objects;

public class ConfigScreen extends OptionsSubScreen {
    public ConfigScreen(Screen lastScreen) {
        super(lastScreen, Minecraft.getInstance().options, Component.literal("Bye Bye Buttons"));
    }

    @Override
    protected void addOptions() {
        ByeByeButtonsConfig.ALL_CONFIG_PARTS.forEach(this::addOption);
    }

    @SuppressWarnings("unchecked")
    private <T> void addOption(ConfigPart<T> configPart) {
        OptionInstance<?> optionInstance = OptionInstance.createBoolean(
                "bye_bye_buttons.config." + configPart.getName(),
                (boolean) configPart.get(),
                newValue -> {
                    configPart.set((T) newValue);
                    ByeByeButtonsFabric.saveConfig();
                }
        );
        Objects.requireNonNull(list).addSmall(optionInstance);
    }
}