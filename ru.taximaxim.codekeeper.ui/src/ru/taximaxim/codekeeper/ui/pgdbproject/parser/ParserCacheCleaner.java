/*******************************************************************************
 * Copyright 2017-2024 TAXTELECOM, LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package ru.taximaxim.codekeeper.ui.pgdbproject.parser;

import java.util.concurrent.TimeUnit;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IStartup;

import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
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
                    AntlrParser.checkToClean(DatabaseType.PG, cleaningInterval);
                    AntlrParser.checkToClean(DatabaseType.MS, cleaningInterval);
                    AntlrParser.checkToClean(DatabaseType.CH, cleaningInterval);
                }
            }
        });
        thread.setDaemon(true);
        thread.start();
    }
}
