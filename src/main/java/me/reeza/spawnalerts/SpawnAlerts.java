package me.reeza.spawnalerts;

import com.pixelmonmod.pixelmon.Pixelmon;
import me.reeza.spawnalerts.listener.SpawnListener;
import me.reeza.spawnalerts.sound.SoundRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Created by Reeza on Oct 05, 2022 at 4:22 PM
 */
@Mod(SpawnAlerts.MOD_ID)
public final class SpawnAlerts {

	public static final String MOD_ID = "spawn-alerts";

	public SpawnAlerts() {
		SoundRegistry.register(FMLJavaModLoadingContext.get().getModEventBus());
		Pixelmon.EVENT_BUS.register(new SpawnListener());
	}
}
