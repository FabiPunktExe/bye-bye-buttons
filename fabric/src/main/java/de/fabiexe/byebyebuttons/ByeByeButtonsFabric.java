package de.fabiexe.byebyebuttons;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import de.fabiexe.byebyebuttons.config.ByeByeButtonsConfig;
import de.fabiexe.byebyebuttons.config.ConfigPart;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ByeByeButtonsFabric implements ClientModInitializer {
    private static final Logger logger = LoggerFactory.getLogger("ByeByeButtons");

    @Override
    public void onInitializeClient() {
        loadConfig();
    }

    public static void saveConfig() {
        Path path = FabricLoader.getInstance().getConfigDir().resolve("bye_bye_buttons.json");
        try {
            Files.createDirectories(path.getParent());
            JsonObject config = new JsonObject();
            for (ConfigPart<?> configPart : ByeByeButtonsConfig.ALL_CONFIG_PARTS) {
                config.addProperty(configPart.getName(), (Boolean) configPart.getValue());
            }
            Files.writeString(path, config.toString());
        } catch (IOException e) {
            logger.error("Failed to save config", e);
        }
    }

    private static void loadConfig() {
        Path path = FabricLoader.getInstance().getConfigDir().resolve("bye_bye_buttons.json");
        if (Files.exists(path)) {
            try {
                JsonObject config = JsonParser.parseString(Files.readString(path)).getAsJsonObject();
                for (ConfigPart<?> configPart : ByeByeButtonsConfig.ALL_CONFIG_PARTS) {
                    loadConfigPart(configPart, config);
                }
            } catch (IOException e) {
                logger.error("Failed to load config", e);
            }
        } else {
            saveConfig();
        }
    }

    @SuppressWarnings("unchecked")
    private static <T> void loadConfigPart(ConfigPart<T> configPart, JsonObject config) {
        JsonElement element = config.get(configPart.getName());
        if (element instanceof JsonPrimitive primitive && primitive.isBoolean()) {
            configPart.set((T) (Boolean) primitive.getAsBoolean());
        }
    }
}