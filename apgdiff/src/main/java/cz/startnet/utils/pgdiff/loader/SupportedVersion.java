package cz.startnet.utils.pgdiff.loader;

public enum SupportedVersion {
    VERSION_9_2 (90200, "9.2"),
    VERSION_9_3 (90300, "9.3"),
    VERSION_9_4 (90400, "9.4"),
    VERSION_9_5 (90500, "9.5"),
    VERSION_9_6 (90600, "9.6"),
    VERSION_10 (100000, "10.0"),/*,
    //TODO check version from postgresPRO
    VERSION_9_5_P (91500),
    VERSION_9_6_P (91600)*/;

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

        return SupportedVersion.VERSION_9_2;
    }
}