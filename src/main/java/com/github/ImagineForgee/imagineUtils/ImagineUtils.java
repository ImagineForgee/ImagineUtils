package com.github.ImagineForgee.imagineUtils;

import com.github.ImagineForgee.imagineUtils.placeholder.IPlaceholderManager;
import com.github.ImagineForgee.imagineUtils.placeholder.PlaceholderManager;
import com.github.ImagineForgee.imagineUtils.placeholder.PlaceholderUtils;
import org.bukkit.entity.Player;

public class ImagineUtils {
    private final IPlaceholderManager placeholderManager;

    public ImagineUtils() {
        this.placeholderManager = new PlaceholderManager();
        PlaceholderUtils.registerCommonPlaceholders(placeholderManager);
    }

    public IPlaceholderManager getPlaceholderManager() {
        return placeholderManager;
    }
    public String parsePlayerPlaceholders(Player player, String text) {
        return PlaceholderUtils.replacePlaceholders(placeholderManager, player, text);
    }
    public boolean isPlaceholderFormatValid(String placeholder) {
        return PlaceholderUtils.validatePlaceholderFormat(placeholder);
    }
}
