package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.util.concurrent.TimeUnit;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IStartup;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;

/**
 * Periodically clears the parser cache
 * (it starts working immediately after the pgCodeKeeper starts).
 */
public class ParserCacheCleaner implements IStartup {

    private final IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();

    @Override
    public void earlyStartup() {
        Thread thread = new Thread(AntlrParser.checkLastParserStart(
                TimeUnit.MINUTES.toMillis(mainPrefs.getInt(PREF.TIME_CLEAN_PARSER_CACHE))));
        thread.setDaemon(true);
        thread.start();
    }

}
