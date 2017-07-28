package cz.startnet.utils.pgdiff.loader;

public enum SupportedVersion {
    VERSION_9_2 (90200),
    VERSION_9_3 (90300),
    VERSION_9_4 (90400),
    VERSION_9_5 (90500),
    VERSION_9_6 (90600),
    VERSION_10 (100000),
    //TODO check version from postgresPRO
    VERSION_9_5_P (91500),
    VERSION_9_6_P (91600);

    private int version;

    SupportedVersion(int version) {
        this.version = version;
    }

    public int getVersion() {
        return version;
    }
}