package de.fabiexe.byebyebuttons.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import de.fabiexe.byebyebuttons.config.ByeByeButtonsConfig;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.inventory.BeaconScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** This mixin removes the cancel button from the beacon screen */
@Mixin(BeaconScreen.class)
public class BeaconScreenCancelButtonMixin {
    @WrapOperation(
            method = "init",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/inventory/BeaconScreen;addBeaconButton(Lnet/minecraft/client/gui/components/AbstractWidget;)V",
                    ordinal = 4))
    public <T extends AbstractWidget> void removeCancelButton(BeaconScreen instance, T beaconButton, Operation<Void> original) {
        if (ByeByeButtonsConfig.BEACON_CANCEL_BUTTON.get()) {
            original.call(instance, beaconButton);
        }
    }
}