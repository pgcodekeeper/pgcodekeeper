package ru.taximaxim.codekeeper.cli.opthandlers;

import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.OptionDef;
import org.kohsuke.args4j.spi.BooleanOptionHandler;
import org.kohsuke.args4j.spi.Setter;

/**
 * Shows no default values for boolean CLI options.
 *
 * @author levsha_aa
 */
public class BooleanNoDefOptionHandler extends BooleanOptionHandler {

    public BooleanNoDefOptionHandler(CmdLineParser parser, OptionDef option, Setter<Boolean> setter) {
        super(parser, option, setter);
    }

    @Override
    public String printDefaultValue() {
        return null;
    }
}
