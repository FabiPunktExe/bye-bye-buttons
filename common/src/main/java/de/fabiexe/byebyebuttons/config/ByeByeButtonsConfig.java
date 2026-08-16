package de.fabiexe.byebyebuttons.config;

import java.util.List;public final class ByeByeButtonsConfig {
    private ByeByeButtonsConfig() {
        throw new UnsupportedOperationException();
    }

    public static final ConfigPart<Boolean> TITLE_SCREEN_REALMS_BUTTON = new ConfigPart<>("title_screen_realms_button", false);
    public static final ConfigPart<Boolean> TITLE_SCREEN_ACCESSIBILITY_BUTTON = new ConfigPart<>("title_screen_accessibility_button", false);
    public static final ConfigPart<Boolean> TITLE_SCREEN_FRIENDS_BUTTON = new ConfigPart<>("title_screen_friends_button", false);
    public static final ConfigPart<Boolean> TITLE_SCREEN_LANGUAGE_BUTTON = new ConfigPart<>("title_screen_language_button", false);
    public static final ConfigPart<Boolean> PAUSE_SCREEN_BUG_REPORT_BUTTON = new ConfigPart<>("pause_screen_bug_report_button", false);
    public static final ConfigPart<Boolean> PAUSE_SCREEN_FEEDBACK_BUTTON = new ConfigPart<>("pause_screen_feedback_button", false);
    public static final ConfigPart<Boolean> PAUSE_SCREEN_FRIENDS_BUTTON = new ConfigPart<>("pause_screen_friends_button", false);
    public static final ConfigPart<Boolean> PAUSE_SCREEN_PLAYER_REPORTING_BUTTON = new ConfigPart<>("pause_screen_player_reporting_button", false);
    public static final ConfigPart<Boolean> MULTIPLAYER_WARNING = new ConfigPart<>("multiplayer_warning", false);
    public static final ConfigPart<Boolean> TELEMETRY_DATA_BUTTON = new ConfigPart<>("telemetry_data_button", false);
    public static final ConfigPart<Boolean> CREDITS_AND_ATTRIBUTION_BUTTON = new ConfigPart<>("credits_and_attribution_button", false);
    public static final ConfigPart<Boolean> DIALOG_WARNING_BUTTON = new ConfigPart<>("dialog_warning_button", false);
    public static final ConfigPart<Boolean> BEACON_CANCEL_BUTTON = new ConfigPart<>("beacon_cancel_button", false);

    public static final List<ConfigPart<?>> ALL_CONFIG_PARTS = List.of(
        TITLE_SCREEN_REALMS_BUTTON,
        TITLE_SCREEN_ACCESSIBILITY_BUTTON,
        TITLE_SCREEN_FRIENDS_BUTTON,
        TITLE_SCREEN_LANGUAGE_BUTTON,
        PAUSE_SCREEN_BUG_REPORT_BUTTON,
        PAUSE_SCREEN_FEEDBACK_BUTTON,
        PAUSE_SCREEN_FRIENDS_BUTTON,
        PAUSE_SCREEN_PLAYER_REPORTING_BUTTON,
        MULTIPLAYER_WARNING,
        TELEMETRY_DATA_BUTTON,
        CREDITS_AND_ATTRIBUTION_BUTTON,
        DIALOG_WARNING_BUTTON,
        BEACON_CANCEL_BUTTON
    );
}