package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import org.eclipse.ui.IStartup;

import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;

/**
 * Periodically clears the parser cache
 * (it starts working immediately after the pgCodeKeeper starts).
 */
public class ParserCacheCleaner implements IStartup {

    private static final long CLEANING_INTERVAL = 600000;

    @Override
    public void earlyStartup() {
        Thread thread = new Thread(AntlrParser.checkLastParserStart(CLEANING_INTERVAL));
        thread.setDaemon(true);
        thread.start();
    }
}
