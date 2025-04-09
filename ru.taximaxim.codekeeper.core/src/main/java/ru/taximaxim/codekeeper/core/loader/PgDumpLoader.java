/*******************************************************************************
 * Copyright 2017-2025 TAXTELECOM, LLC
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
 *
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 *******************************************************************************/
package ru.taximaxim.codekeeper.core.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Queue;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.PgDiffUtils;
import ru.taximaxim.codekeeper.core.fileutils.InputStreamProvider;
import ru.taximaxim.codekeeper.core.localizations.Messages;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrContextProcessor.ChSqlContextProcessor;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrContextProcessor.SqlContextProcessor;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrContextProcessor.TSqlContextProcessor;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrParser;
import ru.taximaxim.codekeeper.core.parsers.antlr.AntlrTask;
import ru.taximaxim.codekeeper.core.parsers.antlr.ChSQLOverridesListener;
import ru.taximaxim.codekeeper.core.parsers.antlr.CustomChSQLParserListener;
import ru.taximaxim.codekeeper.core.parsers.antlr.CustomSQLParserListener;
import ru.taximaxim.codekeeper.core.parsers.antlr.CustomTSQLParserListener;
import ru.taximaxim.codekeeper.core.parsers.antlr.SQLOverridesListener;
import ru.taximaxim.codekeeper.core.parsers.antlr.TSQLOverridesListener;
import ru.taximaxim.codekeeper.core.schema.AbstractDatabase;
import ru.taximaxim.codekeeper.core.schema.AbstractSchema;
import ru.taximaxim.codekeeper.core.schema.GenericColumn;
import ru.taximaxim.codekeeper.core.schema.PgObjLocation;
import ru.taximaxim.codekeeper.core.schema.PgStatement;
import ru.taximaxim.codekeeper.core.schema.StatementOverride;
import ru.taximaxim.codekeeper.core.schema.ch.ChDatabase;
import ru.taximaxim.codekeeper.core.schema.ch.ChSchema;
import ru.taximaxim.codekeeper.core.schema.ms.MsDatabase;
import ru.taximaxim.codekeeper.core.schema.ms.MsSchema;
import ru.taximaxim.codekeeper.core.schema.pg.PgDatabase;
import ru.taximaxim.codekeeper.core.schema.pg.PgSchema;
import ru.taximaxim.codekeeper.core.settings.ISettings;

/**
 * Loads PostgreSQL dump into classes.
 *
 * @author fordfrog
 */
public class PgDumpLoader extends DatabaseLoader {

    private final InputStreamProvider input;
    private final String inputObjectName;
    private final ISettings settings;

    private final IProgressMonitor monitor;
    private final int monitoringLevel;

    private ParserListenerMode mode = ParserListenerMode.NORMAL;
    private Map<PgStatement, StatementOverride> overrides;

    public void setMode(ParserListenerMode mode) {
        this.mode = mode;
    }

    public void setOverridesMap(Map<PgStatement, StatementOverride> overrides) {
        this.overrides = overrides;
    }

    public PgDumpLoader(InputStreamProvider input, String inputObjectName,
            ISettings settings, IProgressMonitor monitor, int monitoringLevel) {
        this.input = input;
        this.inputObjectName = inputObjectName;
        this.settings = settings;
        this.monitor = monitor;
        this.monitoringLevel = monitoringLevel;
    }

    /**
     * This constructor sets the monitoring level to the default of 1.
     */
    public PgDumpLoader(InputStreamProvider input, String inputObjectName,
            ISettings settings, IProgressMonitor monitor) {
        this(input, inputObjectName, settings, monitor, 1);
    }

    /**
     * This constructor uses {@link NullProgressMonitor}.
     */
    public PgDumpLoader(InputStreamProvider input, String inputObjectName, ISettings settings) {
        this(input, inputObjectName, settings, new NullProgressMonitor(), 0);
    }

    /**
     * This constructor creates {@link InputStreamProvider} using inputFile parameter.
     */
    public PgDumpLoader(Path inputFile, ISettings settings, IProgressMonitor monitor, int monitoringLevel) {
        this(() -> Files.newInputStream(inputFile), inputFile.toString(), settings, monitor, monitoringLevel);
    }

    /**
     * @see #PgDumpLoader(Path, PgDiffArguments, IProgressMonitor, int)
     * @see #PgDumpLoader(InputStreamProvider, String, PgDiffArguments, IProgressMonitor, int)
     */
    public PgDumpLoader(Path inputFile, ISettings settings, IProgressMonitor monitor) {
        this(inputFile, settings, monitor, 1);
    }

    /**
     * @see #PgDumpLoader(Path, PgDiffArguments, IProgressMonitor, int)
     * @see #PgDumpLoader(InputStreamProvider, String, PgDiffArguments, IProgressMonitor, int)
     */
    public PgDumpLoader(Path inputFile, ISettings settings) {
        this(inputFile, settings, new NullProgressMonitor(), 0);
    }

    @Override
    public AbstractDatabase load() throws IOException, InterruptedException {
        AbstractDatabase d = createDb(settings);
        loadAsync(d, antlrTasks);
        finishLoaders();
        return d;
    }

    public AbstractDatabase loadAsync(AbstractDatabase d, Queue<AntlrTask<?>> antlrTasks)
            throws InterruptedException {
        AbstractSchema schema = switch (settings.getDbType()) {
        case MS -> new MsSchema(Consts.DBO);
        case PG -> new PgSchema(Consts.PUBLIC);
        case CH -> new ChSchema(Consts.CH_DEFAULT_DB);
        default -> throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + settings.getDbType());
        };
        d.addSchema(schema);
        PgObjLocation loc = new PgObjLocation.Builder()
                .setObject(new GenericColumn(schema.getName(), DbObjType.SCHEMA))
                .build();

        schema.setLocation(loc);
        d.setDefaultSchema(schema.getName());
        loadDatabase(d, antlrTasks);
        return d;
    }

    public AbstractDatabase loadDatabase(AbstractDatabase intoDb, Queue<AntlrTask<?>> antlrTasks)
            throws InterruptedException {
        PgDiffUtils.checkCancelled(monitor);
        switch (settings.getDbType()) {
        case PG:
            SqlContextProcessor sqlListener;
            if (overrides != null) {
                sqlListener = new SQLOverridesListener((PgDatabase) intoDb, inputObjectName, mode, errors, monitor,
                        overrides, settings);
            } else {
                sqlListener = new CustomSQLParserListener((PgDatabase) intoDb, inputObjectName, mode, errors,
                        antlrTasks, monitor, settings);
            }

            AntlrParser.parseSqlStream(input, settings.getInCharsetName(), inputObjectName, errors,
                    monitor, monitoringLevel, sqlListener, antlrTasks);
            break;
        case MS:
            TSqlContextProcessor tsqlListener;
            if (overrides != null) {
                tsqlListener = new TSQLOverridesListener((MsDatabase) intoDb, inputObjectName, mode, errors, monitor,
                        overrides, settings);
            } else {
                tsqlListener = new CustomTSQLParserListener((MsDatabase) intoDb, inputObjectName, mode, errors, monitor,
                        settings);
            }
            AntlrParser.parseTSqlStream(input, settings.getInCharsetName(), inputObjectName, errors,
                    monitor, monitoringLevel, tsqlListener, antlrTasks);
            break;
        case CH:
            ChSqlContextProcessor chSqlListener;
            if (overrides != null) {
                chSqlListener = new ChSQLOverridesListener((ChDatabase) intoDb, inputObjectName, mode, errors, monitor,
                        overrides, settings);
            } else {
                chSqlListener = new CustomChSQLParserListener((ChDatabase) intoDb, inputObjectName, mode, errors,
                        monitor, settings);
            }
            AntlrParser.parseChSqlStream(input, settings.getInCharsetName(), inputObjectName, errors,
                    monitor, monitoringLevel, chSqlListener, antlrTasks);
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + settings.getDbType());
        }

        return intoDb;
    }
}