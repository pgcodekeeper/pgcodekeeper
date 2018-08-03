package cz.startnet.utils.pgdiff;

import java.util.regex.Pattern;

public enum DangerStatement {

    DROP_TABLE("^DROP[\\s]+TABLE.+"),

    ALTER_COLUMN(AlterTableStatic.ALTER_TABLE_PATTERN
            // match ALTER [ COLUMN ] column_name [ SET DATA ] TYPE data_type
            + "ALTER[\\s]+(COLUMN[\\s]+)?([\\w]+[\\s]+)"
            + "(SET[\\s]+DATA[\\s]+)?(TYPE).+"),

    DROP_COLUMN(AlterTableStatic.ALTER_TABLE_PATTERN
            // match 'DROP COLUMN' or 'DROP column_name'
            // but *not* 'DROP CONSTRAINT constraint_name'
            + "DROP[\\s]+(?!CONSTRAINT[\\s]+)([\\w]+).*"),

    RESTART_WITH("^ALTER[\\s]+SEQUENCE.*[\\s]+RESTART[\\s]+.*");

    private static class AlterTableStatic {

        static final String ALTER_TABLE_PATTERN =
                "^ALTER[\\s]+TABLE[\\s]+"
                        + "(IF[\\s]+EXISTS[\\s]+)?"
                        + "(ONLY[\\s]+)?"
                        + "([\\w]+(\\.\\w+)?+[\\s]+)"
                        + "(\\*[\\s]+)?";
    }

    private final Pattern regex;

    private DangerStatement(String regex) {
        this.regex = Pattern.compile(regex, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
    }

    public Pattern getRegex() {
        return regex;
    }
}