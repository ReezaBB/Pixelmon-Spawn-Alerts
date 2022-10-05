package me.reeza.spawnalerts.sound;

import me.reeza.spawnalerts.SpawnAlerts;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Created by Reeza on Oct 05, 2022 at 4:29 PM
 */
public final class SoundRegistry {

	private static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, SpawnAlerts.MOD_ID);
	public static final RegistryObject<SoundEvent> SHINY_SPAWN = registerSoundEvent("shiny_spawn");

	private static RegistryObject<SoundEvent> registerSoundEvent(final String name) {
		return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(SpawnAlerts.MOD_ID, name)));
	}

	public static void register(final IEventBus eventBus) {
		SOUND_EVENTS.register(eventBus);
	}
}
