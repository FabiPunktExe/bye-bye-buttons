package de.fabiexe.byebyebuttons.mixin;

import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.PauseScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/** This mixin removes the feedback button from the pause screen */
@Mixin(PauseScreen.class)
public class PauseScreenFeedbackButtonMixin {
    @Redirect(
            method = "createPauseMenu",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/layouts/LinearLayout;addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;)Lnet/minecraft/client/gui/layouts/LayoutElement;",
                    ordinal = 2))
    public <T extends LayoutElement> T removeButton(LinearLayout instance, T child) {
        return child;
    }
}