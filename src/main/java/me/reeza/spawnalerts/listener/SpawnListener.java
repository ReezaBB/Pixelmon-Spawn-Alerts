package me.reeza.spawnalerts.listener;

import com.pixelmonmod.pixelmon.api.events.spawning.SpawnEvent;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.api.spawning.archetypes.entities.pokemon.SpawnActionPokemon;
import com.pixelmonmod.pixelmon.entities.pixelmon.PixelmonEntity;
import me.reeza.spawnalerts.sound.SoundRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

/**
 * Created by Reeza on Oct 05, 2022 at 4:25 PM
 */
public final class SpawnListener {

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onSpawn(final SpawnEvent spawnEvent) {
		if (spawnEvent.isCanceled()) {
			return;
		}

		if (spawnEvent.action instanceof SpawnActionPokemon) {
			final SpawnActionPokemon pokemonSpawn = (SpawnActionPokemon) spawnEvent.action;
			final PixelmonEntity entity = pokemonSpawn.getOrCreateEntity();
			final Pokemon pokemon = pokemonSpawn.pokemon;

			if (!entity.hasOwner() && pokemon.isShiny() && !entity.isBossPokemon()) {
				final AxisAlignedBB boundingBox = new AxisAlignedBB(pokemonSpawn.spawnLocation.location.pos).grow(64);
				final List<PlayerEntity> players = entity.world.getLoadedEntitiesWithinAABB(PlayerEntity.class, boundingBox);

				for (final PlayerEntity player : players) {
					player.playSound(SoundRegistry.SHINY_SPAWN.get(), SoundCategory.BLOCKS, 1.0F, 1.0F);
				}
			}
		}
	}
}
