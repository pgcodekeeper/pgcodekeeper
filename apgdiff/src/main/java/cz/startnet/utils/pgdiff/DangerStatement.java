package cz.startnet.utils.pgdiff;

import java.util.EnumSet;
import java.util.Set;

public enum DangerStatement {
    DROP_TABLE,
    ALTER_COLUMN,
    DROP_COLUMN,
    RESTART_WITH,
    UPDATE;

    public static Set<DangerStatement> getAllowedDanger(boolean ignoreDropCol, boolean ignoreAlterCol,
            boolean ignoreDropTable, boolean ignoreRestartWith, boolean ignoreUpdate) {
        Set<DangerStatement> allowedDangers = EnumSet.noneOf(DangerStatement.class);
        if (ignoreDropCol) {
            allowedDangers.add(DangerStatement.DROP_COLUMN);
        }
        if (ignoreAlterCol) {
            allowedDangers.add(DangerStatement.ALTER_COLUMN);
        }
        if (ignoreDropTable) {
            allowedDangers.add(DangerStatement.DROP_TABLE);
        }
        if (ignoreRestartWith) {
            allowedDangers.add(DangerStatement.RESTART_WITH);
        }
        if (ignoreUpdate) {
            allowedDangers.add(DangerStatement.UPDATE);
        }

        return allowedDangers;
    }
}