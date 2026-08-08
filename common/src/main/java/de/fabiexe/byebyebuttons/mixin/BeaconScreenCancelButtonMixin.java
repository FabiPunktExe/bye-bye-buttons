package de.fabiexe.byebyebuttons.mixin;

import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.inventory.BeaconScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/** This mixin removes the cancel button from the beacon screen */
@Mixin(BeaconScreen.class)
public class BeaconScreenCancelButtonMixin {
    @Redirect(
            method = "init",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/inventory/BeaconScreen;addBeaconButton(Lnet/minecraft/client/gui/components/AbstractWidget;)V",
                    ordinal = 4))
    public <T extends AbstractWidget> void removeCancelButton(BeaconScreen instance, T beaconButton) {}
}