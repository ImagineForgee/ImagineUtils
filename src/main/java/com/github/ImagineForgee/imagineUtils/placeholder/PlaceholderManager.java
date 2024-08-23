package com.github.ImagineForgee.imagineUtils.placeholder;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PlaceholderManager implements IPlaceholderManager {
    private final Map<String, Function<Player, String>> placeholders = new HashMap<>();
    private final boolean placeholderAPIEnabled;

    public PlaceholderManager() {
        this.placeholderAPIEnabled = Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI");
    }

    @Override
    public void registerPlaceholder(String key, Function<Player, String> function) {
        placeholders.put(key, function);
    }

    @Override
    public boolean isPlaceholderRegistered(String key) {
        return placeholders.containsKey(key);
    }

    @Override
    public void unregisterPlaceholder(String key) {
        placeholders.remove(key);
    }

    @Override
    public String parsePlaceholders(Player player, String text) {
        for (Map.Entry<String, Function<Player, String>> entry : placeholders.entrySet()) {
            text = text.replace("%" + entry.getKey() + "%", entry.getValue().apply(player));
        }
        if (placeholderAPIEnabled) {
            text = PlaceholderAPI.setPlaceholders(player, text);
        }

        return text;
    }
}
