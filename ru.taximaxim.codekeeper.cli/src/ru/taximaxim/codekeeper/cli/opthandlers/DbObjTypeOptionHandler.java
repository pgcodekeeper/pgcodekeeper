package ru.taximaxim.codekeeper.cli.opthandlers;

import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.EnumOptionHandler;
import org.kohsuke.args4j.spi.Setter;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class DbObjTypeOptionHandler extends EnumOptionHandler<DbObjType> {

    // TODO add VIEWCOLUMN when merged
    private static final Set<DbObjType> HIDE = Collections.unmodifiableSet(EnumSet.of(
            DbObjType.DATABASE,
            DbObjType.COLUMN));

    public DbObjTypeOptionHandler(CmdLineParser parser, OptionDef option, Setter<DbObjType> setter) {
        super(parser, option, setter, DbObjType.class);
    }

    @Override
    public String getDefaultMetaVariable() {
        return "<OBJECT_TYPE>";
    }

    public static String getMetaVariable() {
        return Arrays.stream(DbObjType.values())
                .filter(e -> !HIDE.contains(e))
                .map(DbObjType::name)
                .collect(Collectors.joining(" | ", "OBJECT_TYPE : [", "]"));
    }
}
