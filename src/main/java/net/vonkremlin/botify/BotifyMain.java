package net.vonkremlin.botify;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.c2s.play.VehicleMoveC2SPacket;
import net.vonkremlin.botify.event.KeyInputHandler;
import org.lwjgl.glfw.GLFW;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BotifyMain implements ModInitializer {

	public static KeyBinding exampleBind = KeyInputHandler.registerNewBind("Example(BotifyMain.class)", "Example Name", -1);
	static boolean exampleModuleToggled = true;
	public static MinecraftClient mc = MinecraftClient.getInstance();
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("botify");

	public static void onTick() {
		ifEnabled();
	}


	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");
	}

	public static void onPacketReceive(Packet<?> packet) {

		}
	public static void onPacketSend(Packet<?> packet) {
		if (exampleModuleToggled&&packet instanceof PlayerMoveC2SPacket) {
			double x = ((int)(((PlayerMoveC2SPacket) packet).getX(mc.player.getX()) * 100)) / 100.0;
			double z = ((int)(((PlayerMoveC2SPacket) packet).getZ(mc.player.getZ()) * 100)) / 100.0;
		}

	}

	public static boolean nullCheck() {
		return  MinecraftClient.getInstance() == null || MinecraftClient.getInstance().world == null;

	}


	public static void ifEnabled() {
		if (exampleBind.wasPressed()) {exampleModuleToggled = !exampleModuleToggled;}
	}
}
