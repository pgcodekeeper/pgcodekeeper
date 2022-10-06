package ru.taximaxim.codekeeper.core.loader;

public enum SupportedVersion {
    VERSION_10 (100000, "10.0"),
    VERSION_11 (110000, "11.0"),
    VERSION_12 (120000, "12.0"),
    VERSION_13 (130000, "13.0"),
    VERSION_14 (140000, "14.0");

    private final int version;
    private final String text;

    SupportedVersion(int version, String text) {
        this.version = version;
        this.text = text;
    }

    public int getVersion() {
        return version;
    }

    public String getText() {
        return text;
    }

    public boolean isLE(int version) {
        return this.version <= version;
    }

    public static SupportedVersion valueOf(int checkVersion) {
        SupportedVersion[] set = SupportedVersion.values();

        for (int i = set.length - 1; i >= 0; i--) {
            SupportedVersion verEnum = set[i];
            if (verEnum.isLE(checkVersion)) {
                return verEnum;
            }
        }

        return SupportedVersion.VERSION_10;
    }
}