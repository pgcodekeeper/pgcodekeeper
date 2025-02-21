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

/**
 * Loads PostgreSQL dump into classes.
 *
 * @author fordfrog
 */
public class PgDumpLoader extends DatabaseLoader {

    private final InputStreamProvider input;
    private final String inputObjectName;
    private final PgDiffArguments args;

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
            PgDiffArguments args, IProgressMonitor monitor, int monitoringLevel) {
        this.input = input;
        this.inputObjectName = inputObjectName;
        this.args = args;
        this.monitor = monitor;
        this.monitoringLevel = monitoringLevel;
    }

    /**
     * This constructor sets the monitoring level to the default of 1.
     */
    public PgDumpLoader(InputStreamProvider input, String inputObjectName,
            PgDiffArguments args, IProgressMonitor monitor) {
        this(input, inputObjectName, args, monitor, 1);
    }

    /**
     * This constructor uses {@link NullProgressMonitor}.
     */
    public PgDumpLoader(InputStreamProvider input, String inputObjectName, PgDiffArguments args) {
        this(input, inputObjectName, args, new NullProgressMonitor(), 0);
    }

    /**
     * This constructor creates {@link InputStreamProvider} using inputFile parameter.
     */
    public PgDumpLoader(Path inputFile, PgDiffArguments args, IProgressMonitor monitor, int monitoringLevel) {
        this(() -> Files.newInputStream(inputFile), inputFile.toString(), args, monitor, monitoringLevel);
    }

    /**
     * @see #PgDumpLoader(Path, PgDiffArguments, IProgressMonitor, int)
     * @see #PgDumpLoader(InputStreamProvider, String, PgDiffArguments, IProgressMonitor, int)
     */
    public PgDumpLoader(Path inputFile, PgDiffArguments args, IProgressMonitor monitor) {
        this(inputFile, args, monitor, 1);
    }

    /**
     * @see #PgDumpLoader(Path, PgDiffArguments, IProgressMonitor, int)
     * @see #PgDumpLoader(InputStreamProvider, String, PgDiffArguments, IProgressMonitor, int)
     */
    public PgDumpLoader(Path inputFile, PgDiffArguments args) {
        this(inputFile, args, new NullProgressMonitor(), 0);
    }

    @Override
    public AbstractDatabase load() throws IOException, InterruptedException {
        AbstractDatabase d = createDb(args);
        loadAsync(d, antlrTasks);
        finishLoaders();
        return d;
    }

    public AbstractDatabase loadAsync(AbstractDatabase d, Queue<AntlrTask<?>> antlrTasks)
            throws InterruptedException {
        AbstractSchema schema;
        switch (args.getDbType()) {
        case MS:
            schema = new MsSchema(Consts.DBO);
            break;
        case PG:
            schema = new PgSchema(Consts.PUBLIC);
            break;
        case CH:
            schema = new ChSchema(Consts.CH_DEFAULT_DB);
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + args.getDbType());
        }
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
        switch (args.getDbType()) {
        case PG:
            SqlContextProcessor sqlListener;
            if (overrides != null) {
                sqlListener = new SQLOverridesListener((PgDatabase) intoDb, inputObjectName, mode, errors, monitor,
                        overrides);
            } else {
                sqlListener = new CustomSQLParserListener((PgDatabase) intoDb, inputObjectName, mode, errors,
                        antlrTasks, monitor);
            }

            AntlrParser.parseSqlStream(input, args.getInCharsetName(), inputObjectName, errors,
                    monitor, monitoringLevel, sqlListener, antlrTasks);
            break;
        case MS:
            TSqlContextProcessor tsqlListener;
            if (overrides != null) {
                tsqlListener = new TSQLOverridesListener((MsDatabase) intoDb, inputObjectName, mode, errors, monitor,
                        overrides);
            } else {
                tsqlListener = new CustomTSQLParserListener((MsDatabase) intoDb, inputObjectName, mode, errors, monitor);
            }
            AntlrParser.parseTSqlStream(input, args.getInCharsetName(), inputObjectName, errors,
                    monitor, monitoringLevel, tsqlListener, antlrTasks);
            break;
        case CH:
            ChSqlContextProcessor chSqlListener;
            if (overrides != null) {
                chSqlListener = new ChSQLOverridesListener((ChDatabase) intoDb, inputObjectName, mode, errors, monitor,
                        overrides);
            } else {
                chSqlListener = new CustomChSQLParserListener((ChDatabase) intoDb, inputObjectName, mode, errors,
                        monitor);
            }
            AntlrParser.parseChSqlStream(input, args.getInCharsetName(), inputObjectName, errors,
                    monitor, monitoringLevel, chSqlListener, antlrTasks);
            break;
        default:
            throw new IllegalArgumentException(Messages.DatabaseType_unsupported_type + args.getDbType());
        }

        return intoDb;
    }
}