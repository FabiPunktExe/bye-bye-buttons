package de.fabiexe.byebyebuttons.mixin;

import net.minecraft.client.gui.components.StringWidget;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.layouts.LayoutElement;
import net.minecraft.client.gui.layouts.LinearLayout;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.dialog.DialogConnectionAccess;
import net.minecraft.client.gui.screens.dialog.DialogScreen;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.HoverEvent;
import net.minecraft.network.chat.TextColor;
import net.minecraft.server.dialog.Dialog;
import org.jspecify.annotations.NonNull;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

/** This mixin replaces the warning button from the pause screen with a message */
@Mixin(DialogScreen.class)
public abstract class DialogScreenWarningButtonMixin extends Screen {
    @Unique
    private static final Component bye_bye_buttons$warnMessage = Component.translatable("bye_bye_buttons.custom_screen_warning")
            .withColor(TextColor.GRAY)
            .withStyle(style -> style
                    .withHoverEvent(new HoverEvent.ShowText(
                            Component.translatable("menu.custom_screen_info.button_narration"))));

    @Unique
    private StringWidget bye_bye_buttons$warning = null;

    @Shadow
    @Final
    private DialogConnectionAccess connectionAccess;

    protected DialogScreenWarningButtonMixin(Component title) {
        super(title);
    }

    @Redirect(
            method = "createTitleWithWarningButton",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/layouts/LinearLayout;addChild(Lnet/minecraft/client/gui/layouts/LayoutElement;)Lnet/minecraft/client/gui/layouts/LayoutElement;",
                    ordinal = 1))
    public <T extends LayoutElement> T replaceButton1(LinearLayout instance, T child) {
        bye_bye_buttons$warning = new StringWidget(bye_bye_buttons$warnMessage, font) {
            @Override
            public void onClick(@NonNull MouseButtonEvent event, boolean doubleClick) {
                minecraft.gui.setScreen(DialogScreen.WarningScreen.create(minecraft, connectionAccess, DialogScreenWarningButtonMixin.this));
                super.onClick(event, doubleClick);
            }
        };
        bye_bye_buttons$warning.active = true;
        instance.addChild(bye_bye_buttons$warning);
        return child;
    }

    @Redirect(
            method = "init",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/screens/dialog/DialogScreen;addRenderableWidget(Lnet/minecraft/client/gui/components/events/GuiEventListener;)Lnet/minecraft/client/gui/components/events/GuiEventListener;",
                    ordinal = 0))
    public <T extends Dialog> GuiEventListener replaceButton2(DialogScreen<T> instance, GuiEventListener guiEventListener) {
        return bye_bye_buttons$warning;
    }

    @Redirect(
            method = "createTitleWithWarningButton",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/layouts/LinearLayout;horizontal()Lnet/minecraft/client/gui/layouts/LinearLayout;"))
    public LinearLayout modifyLayoutDirection() {
        return LinearLayout.vertical();
    }

    @Redirect(
            method = "createTitleWithWarningButton",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/layouts/LinearLayout;spacing(I)Lnet/minecraft/client/gui/layouts/LinearLayout;"))
    public LinearLayout modifyLayoutSpacing(LinearLayout instance, int spacing) {
        return instance.spacing(4);
    }
}