package de.fabiexe.byebyebuttons.mixin;

import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/** This mixin removes the realms button from the title screen */
@Mixin(TitleScreen.class)
public class TitleScreenRealmsButtonMixin {
    @Redirect(
            method = "createNormalMenuOptions",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/TitleScreen;addRenderableWidget(Lnet/minecraft/client/gui/components/events/GuiEventListener;)Lnet/minecraft/client/gui/components/events/GuiEventListener;",
                    ordinal = 3))
    public GuiEventListener removeRealmsButton(TitleScreen instance, GuiEventListener guiEventListener) {
        return guiEventListener;
    }
}