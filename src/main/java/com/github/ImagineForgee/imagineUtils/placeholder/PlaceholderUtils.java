package com.github.ImagineForgee.imagineUtils.placeholder;

import org.bukkit.entity.Player;

import java.util.Map;
import java.util.function.Function;

public class PlaceholderUtils {
    public static String replacePlaceholders(IPlaceholderManager manager, Player player, String text) {
        return manager.parsePlaceholders(player, text);
    }

    public static void registerCommonPlaceholders(IPlaceholderManager manager) {
        manager.registerPlaceholder("player_name", Player::getName);
        manager.registerPlaceholder("player_world", player -> player.getWorld().getName());
        manager.registerPlaceholder("player_health", player -> String.valueOf(player.getHealth()));
    }

    public static void registerBulkPlaceholders(IPlaceholderManager manager, Map<String, Function<Player, String>> placeholders) {
        placeholders.forEach(manager::registerPlaceholder);
    }

    public static boolean validatePlaceholderFormat(String placeholder) {
        return placeholder != null && placeholder.matches("%[a-zA-Z0-9_]+%");
    }
}

