package net.somesanity.skillability.Client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.somesanity.skillability.ModCapabilities.ModCapabilities;

@Mod.EventBusSubscriber(modid = "skillability", value = Dist.CLIENT)
public class statsOverlay {
    @SubscribeEvent
    public static void onRenderGui(RenderGuiOverlayEvent.Post event) {
        GuiGraphics guiGraphics = event.getGuiGraphics();
        Minecraft mc = Minecraft.getInstance();

        Player player = mc.player;
        if (player == null) return;

        player.getCapability(ModCapabilities.EVASION).ifPresent(evasion -> {
            int currentEvasion = evasion.getEvasion();

            Font font = mc.font;
            int x = 5;
            int y = 5;
            guiGraphics.drawString(font, "Evasion: " + currentEvasion + "%", x, y, 0xFFFFFF);
        });
    }
}