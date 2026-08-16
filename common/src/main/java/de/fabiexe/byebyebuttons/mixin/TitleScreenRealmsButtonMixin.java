package de.fabiexe.byebyebuttons.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import de.fabiexe.byebyebuttons.config.ByeByeButtonsConfig;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** This mixin removes the realms button from the title screen */
@Mixin(TitleScreen.class)
public class TitleScreenRealmsButtonMixin {
    @WrapOperation(
            method = "createNormalMenuOptions",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/TitleScreen;addRenderableWidget(Lnet/minecraft/client/gui/components/events/GuiEventListener;)Lnet/minecraft/client/gui/components/events/GuiEventListener;",
                    ordinal = 3))
    public GuiEventListener removeRealmsButton(TitleScreen instance, GuiEventListener guiEventListener, Operation<GuiEventListener> original) {
        if (!ByeByeButtonsConfig.TITLE_SCREEN_REALMS_BUTTON.get()) {
            ((AbstractWidget) guiEventListener).active = false;
            ((AbstractWidget) guiEventListener).visible = false;
        }
        return original.call(instance, guiEventListener);
    }
}