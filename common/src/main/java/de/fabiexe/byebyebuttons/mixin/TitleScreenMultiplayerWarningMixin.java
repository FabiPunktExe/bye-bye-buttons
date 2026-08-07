package de.fabiexe.byebyebuttons.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.client.gui.screens.TitleScreen;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

/** This mixin removes the warning when navigating from the title screen to the multiplayer screen */
@Mixin(TitleScreen.class)
public class TitleScreenMultiplayerWarningMixin {
    @ModifyExpressionValue(
            method = "lambda$createNormalMenuOptions$3",
            at = @At(value = "FIELD", target = "Lnet/minecraft/client/Options;skipMultiplayerWarning:Z", opcode = Opcodes.GETFIELD),
            order = 100)
    public boolean removeWarning(boolean original) {
        return true;
    }
}