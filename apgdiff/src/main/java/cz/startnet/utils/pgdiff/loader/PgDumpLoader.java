/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff.loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Queue;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.SqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.TSqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrTask;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomTSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLOverridesListener;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLOverridesListener;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.GenericColumn;
import cz.startnet.utils.pgdiff.schema.MsSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgObjLocation;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementOverride;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.fileutils.InputStreamProvider;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

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
     * This constructor creates {@link InputStream} using inputFile parameter.
     * Call {@link #close()} after this {@link PgDumpLoader} instance is no longer needed,
     * or wrap usage of the instance with try-with-resources.
     */
    public PgDumpLoader(File inputFile, PgDiffArguments args,
            IProgressMonitor monitor, int monitoringLevel) {
        this(() -> new FileInputStream(inputFile), inputFile.toString(), args, monitor, monitoringLevel);
    }

    /**
     * @see #PgDumpLoader(File, PgDiffArguments, IProgressMonitor, int)
     * @see #PgDumpLoader(InputStream, String, PgDiffArguments, IProgressMonitor)
     */
    public PgDumpLoader(File inputFile, PgDiffArguments args, IProgressMonitor monitor) {
        this(inputFile, args, monitor, 1);
    }

    /**
     * @see #PgDumpLoader(File, PgDiffArguments, IProgressMonitor, int)
     * @see #PgDumpLoader(InputStream, String, PgDiffArguments)
     */
    public PgDumpLoader(File inputFile, PgDiffArguments args) {
        this(inputFile, args, new NullProgressMonitor(), 0);
    }

    @Override
    public PgDatabase load() throws IOException, InterruptedException {
        PgDatabase d = new PgDatabase(args);
        loadAsync(d, antlrTasks);
        finishLoaders();
        return d;
    }

    public PgDatabase loadAsync(PgDatabase d, Queue<AntlrTask<?>> antlrTasks)
            throws InterruptedException {
        AbstractSchema schema = args.isMsSql() ? new MsSchema(ApgdiffConsts.DBO) :
            new PgSchema(ApgdiffConsts.PUBLIC);
        d.addSchema(schema);
        schema.setLocation(new PgObjLocation(
                new GenericColumn(schema.getName(), DbObjType.SCHEMA)));
        d.setDefaultSchema(schema.getName());
        loadDatabase(d, antlrTasks);
        return d;
    }

    public PgDatabase loadDatabase(PgDatabase intoDb, Queue<AntlrTask<?>> antlrTasks)
            throws InterruptedException {
        PgDiffUtils.checkCancelled(monitor);

        if (args.isMsSql()) {
            TSqlContextProcessor listener;
            if (overrides != null) {
                listener = new TSQLOverridesListener(
                        intoDb, inputObjectName, mode, errors, monitor, overrides);
            } else {
                listener = new CustomTSQLParserListener(
                        intoDb, inputObjectName, mode, errors, monitor);
            }
            AntlrParser.parseTSqlStream(input, args.getInCharsetName(), inputObjectName, errors,
                    monitor, monitoringLevel, listener, antlrTasks);
        } else {
            SqlContextProcessor listener;
            if (overrides != null) {
                listener = new SQLOverridesListener(
                        intoDb, inputObjectName, mode, errors, monitor, overrides);
            } else {
                listener = new CustomSQLParserListener(intoDb,
                        inputObjectName, mode, errors, antlrTasks, monitor);
            }

            AntlrParser.parseSqlStream(input, args.getInCharsetName(), inputObjectName, errors,
                    monitor, monitoringLevel, listener, antlrTasks);
        }

        return intoDb;
    }
}
