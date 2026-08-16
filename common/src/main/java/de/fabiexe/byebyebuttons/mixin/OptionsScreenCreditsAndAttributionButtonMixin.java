package de.fabiexe.byebyebuttons.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import de.fabiexe.byebyebuttons.config.ByeByeButtonsConfig;
import net.minecraft.client.gui.layouts.GridLayout;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.screens.options.OptionsScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** This mixin removes the credits & attribution button from the options screen */
@Mixin(OptionsScreen.class)
public class OptionsScreenCreditsAndAttributionButtonMixin {
    @WrapOperation(
            method = "init",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/layouts/GridLayout$RowHelper;addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;)Lnet/minecraft/client/gui/layouts/LayoutElement;",
                    ordinal = 9))
    public <T extends LayoutElement> T removeButton(GridLayout.RowHelper instance, T widget, Operation<T> original) {
        if (ByeByeButtonsConfig.CREDITS_AND_ATTRIBUTION_BUTTON.get()) {
            return original.call(instance, widget);
        } else {
            return widget;
        }
    }
}