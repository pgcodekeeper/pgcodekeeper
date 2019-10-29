package cz.startnet.utils.pgdiff.schema;

import java.util.Locale;

public enum ArgMode {
    IN,
    INOUT,
    OUT,
    VARIADIC,
    // MS SQL
    OUTPUT;

    public boolean isIn() {
        return this == IN || this == INOUT;
    }

    public static ArgMode of(String string) {
        String s = string.toLowerCase(Locale.ROOT);
        switch (s) {
        case "in":
        case "i":
            return IN;
        case "out":
        case "o":
            return OUT;
        case "inout":
        case "b":
            return INOUT;
        case "variadic":
        case "v":
            return VARIADIC;
        case "output":
            return OUTPUT;
        default:
            return valueOf(string);
        }
    }
}
