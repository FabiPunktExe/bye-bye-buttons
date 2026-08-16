package de.fabiexe.byebyebuttons.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import de.fabiexe.byebyebuttons.config.ByeByeButtonsConfig;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

/** This mixin removes the friends button from the title screen */
@Mixin(TitleScreen.class)
public class TitleScreenFriendsButtonMixin {
    @WrapOperation(
            method = "init",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/TitleScreen;addRenderableWidget(Lnet/minecraft/client/gui/components/events/GuiEventListener;)Lnet/minecraft/client/gui/components/events/GuiEventListener;",
                    ordinal = 0))
    public GuiEventListener removeButton1(TitleScreen instance, GuiEventListener guiEventListener, Operation<GuiEventListener> original) {
        if (ByeByeButtonsConfig.TITLE_SCREEN_FRIENDS_BUTTON.get()) {
            return original.call(instance, guiEventListener);
        } else {
            return guiEventListener;
        }
    }

    @ModifyVariable(
            method = "init",
            at = @At(value = "STORE"),
            name = "numberOfButtons",
            order = 100)
    public int removeButton2(int numberOfButtons) {
        if (ByeByeButtonsConfig.TITLE_SCREEN_FRIENDS_BUTTON.get()) {
            return numberOfButtons;
        } else {
            return numberOfButtons - 1;
        }
    }

    @ModifyVariable(
            method = "init",
            at = @At(value = "STORE", ordinal = 0),
            name = "currentButton")
    public int removeButton3(int currentButton) {
        if (ByeByeButtonsConfig.TITLE_SCREEN_FRIENDS_BUTTON.get()) {
            return currentButton;
        } else {
            return currentButton - 1;
        }
    }
}