package net.vonkremlin.botify.event;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public class KeyInputHandler {
    public static final String KEY_CATEGORY = "Hello";
    public static final String KEYNAME = "Hi";
    static boolean boatFlyIsActive = false;
    static double speed = 2;


    public static KeyBinding boatFlyToggle;


    public static KeyBinding registerNewBind(String category, String NAME, int DefaultKey) {
        KeyBinding binding = KeyBindingHelper.registerKeyBinding(new KeyBinding(NAME, InputUtil.Type.KEYSYM, DefaultKey, category ));
        return binding;
    }
}
