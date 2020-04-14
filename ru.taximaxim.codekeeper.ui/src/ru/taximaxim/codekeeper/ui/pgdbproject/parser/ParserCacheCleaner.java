package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.util.concurrent.TimeUnit;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IStartup;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.ui.Activator;
import ru.taximaxim.codekeeper.ui.Log;
import ru.taximaxim.codekeeper.ui.UIConsts.PREF;

/**
 * Periodically clears the parser cache
 * (it starts working immediately after the pgCodeKeeper starts).
 */
public class ParserCacheCleaner implements IStartup {

    private static final long CHECK_INTERVAL = 30000;

    @Override
    public void earlyStartup() {
        IPreferenceStore mainPrefs = Activator.getDefault().getPreferenceStore();
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(CHECK_INTERVAL);
                } catch (InterruptedException e) {
                    Log.log(e);
                    Thread.currentThread().interrupt();
                }

                long cleaningInterval = TimeUnit.MINUTES
                        .toMillis(mainPrefs.getInt(PREF.PARSER_CACHE_CLEANING_INTERVAL));
                if (cleaningInterval != 0) {
                    AntlrParser.checkToClean(false, cleaningInterval);
                    AntlrParser.checkToClean(true, cleaningInterval);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
