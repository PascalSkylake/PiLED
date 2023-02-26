package net;

import led.Pattern;
import led.patterns.AutoBlue;
import led.patterns.AutoRed;
import led.patterns.DisabledBlue;
import led.patterns.DisabledRed;

public enum State {
    DISABLEDRED,
    DISABLEDBLUE,
    AUTORED,
    AUTOBLUE,
    TELEZERO,
    TELEONE,
    TELETWO,
    TELEWRONG,
    PURPLE,
    YELLOW,
    RAINBOW,
    OFF;

    public static Pattern getPattern(State s) {
        return switch (s) {
            case DISABLEDRED -> new DisabledRed(DISABLEDRED);
            case DISABLEDBLUE -> new DisabledBlue(DISABLEDBLUE);
            case AUTORED -> new AutoRed(AUTORED);
            case AUTOBLUE -> new AutoBlue(AUTOBLUE);
            default ->
                // case TELEZERO: return new TeleZero(TELEZERO);
                // case TELEONE: return new TeleOne(TELEONE);
                // case TELETWO: return new TeleTwo(TELETWO);
                // case TELEWRONG: return new TeleWrong(TELEWRONG);
                null;
        };
    }
}
