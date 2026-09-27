package de.fabiexe.byebyebuttons;

import de.fabiexe.mmp.config.ConfigNeoforge;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(value = "bye_bye_buttons", dist = Dist.CLIENT)
public final class ByeByeButtonsNeoForge {
    public ByeByeButtonsNeoForge(IEventBus modEventBus, ModContainer container) {
        ConfigNeoforge.register(modEventBus, container, ByeByeButtonsConfig.CONFIG);
    }
}