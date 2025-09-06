package net.somesanity.skillability.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class keyBinding {
    public static final String KEY_CATEGORY_SKILLABILITY = "key.category.skillability.skills";
    public static final String KEY_USE_SPELL = "key.skillability.use_spell";

    public static final KeyMapping USESPELL_KEY = new KeyMapping(KEY_USE_SPELL, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_R, KEY_CATEGORY_SKILLABILITY);
}