package com.github.ImagineForgee.imagineUtils.placeholder;

import org.bukkit.entity.Player;

import java.util.function.Function;

public interface IPlaceholderManager {
    void registerPlaceholder(String key, Function<Player, String> function);
    String parsePlaceholders(Player player, String text);
    boolean isPlaceholderRegistered(String key);
    void unregisterPlaceholder(String key);
}

