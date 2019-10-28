package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import org.eclipse.ui.IStartup;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.apgdiff.Log;

/**
 * Periodically clears the parser cache
 * (it starts working immediately after the pgCodeKeeper starts).
 */
public class ParserCacheCleaner implements IStartup {

    private static long lastStart;
    private static final long DURATION_BEFORE_CLEAN = 600000;
    private static final long FREQUENCY_OF_CHECK = 60000;

    @Override
    public void earlyStartup() {
        Thread thread = new Thread(() -> {
            while (true) {
                if (lastStart != 0
                        && (DURATION_BEFORE_CLEAN < System.currentTimeMillis() - lastStart)) {
                    AntlrParser.cleanParserCache();
                    lastStart = 0;
                }

                try {
                    Thread.sleep(FREQUENCY_OF_CHECK);
                } catch (InterruptedException e) {
                    Log.log(e);
                    AntlrParser.cleanParserCache();
                    lastStart = 0;
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public static void saveTimeOfLastParserStart() {
        lastStart = System.currentTimeMillis();
    }
}
