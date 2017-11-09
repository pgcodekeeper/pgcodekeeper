package ru.taximaxim.codekeeper.cli.opthandlers;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.EnumOptionHandler;
import org.kohsuke.args4j.spi.Setter;

import cz.startnet.utils.pgdiff.DangerStatement;

public class DangerStatementOptionHandler extends EnumOptionHandler<DangerStatement> {

    public DangerStatementOptionHandler(CmdLineParser parser, OptionDef option, Setter<DangerStatement> setter) {
        super(parser, option, setter, DangerStatement.class);
    }

    @Override
    public String getDefaultMetaVariable() {
        return "<DANGER_STATEMENT>";
    }

    public static String getMetaVariable() {
        return Arrays.stream(DangerStatement.values())
                .map(DangerStatement::name)
                .collect(Collectors.joining(" | ", "DANGER_STATEMENT : [", "]"));
    }
}
