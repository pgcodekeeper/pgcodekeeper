package cz.startnet.utils.pgdiff;

public enum FILES_POSTFIX {
    DIFF_SQL("_diff.sql"),
    NEW_SQL("_new.sql"),
    ORIGINAL_SQL("_original.sql");

    private final String value;
    private FILES_POSTFIX(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}
