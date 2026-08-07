package de.fabiexe.byebyebuttons.mixin;

import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;

/** This mixin removes the language button from the title screen */
@Mixin(TitleScreen.class)
public class TitleScreenLanguageButtonMixin {
    @Redirect(
            method = "init",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/TitleScreen;addRenderableWidget(Lnet/minecraft/client/gui/components/events/GuiEventListener;)Lnet/minecraft/client/gui/components/events/GuiEventListener;",
                    ordinal = 2))
    public GuiEventListener removeButton1(TitleScreen instance, GuiEventListener guiEventListener) {
        return guiEventListener;
    }

    @ModifyVariable(
            method = "init",
            at = @At(value = "STORE"),
            name = "numberOfButtons",
            order = 100)
    public int removeButton2(int numberOfButtons) {
        return numberOfButtons - 1;
    }

    @ModifyVariable(
            method = "init",
            at = @At(value = "STORE", ordinal = 0),
            name = "currentButton")
    public int removeButton3(int currentButton) {
        return currentButton - 1;
    }

    @ModifyArg(
            method = "init",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/TitleScreen;getHorizontalPosition(III)I",
                    ordinal = 0),
            index = 1)
    public int removeButton4(int numberOfButtons) {
        return numberOfButtons - 2;
    }
}