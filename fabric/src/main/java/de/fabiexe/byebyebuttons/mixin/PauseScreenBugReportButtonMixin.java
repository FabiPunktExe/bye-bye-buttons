package de.fabiexe.byebyebuttons.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import de.fabiexe.byebyebuttons.config.ByeByeButtonsConfig;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.PauseScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** This mixin removes the bug report button from the pause screen */
@Mixin(PauseScreen.class)
public class PauseScreenBugReportButtonMixin {
    @WrapOperation(
            method = "createPauseMenu",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/layouts/LinearLayout;addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;)Lnet/minecraft/client/gui/layouts/LayoutElement;",
                    ordinal = 0))
    public <T extends LayoutElement> T removeButton(LinearLayout instance, T child, Operation<T> original) {
        if (ByeByeButtonsConfig.PAUSE_SCREEN_BUG_REPORT_BUTTON.get()) {
            return original.call(instance, child);
        } else {
            return child;
        }
    }
}