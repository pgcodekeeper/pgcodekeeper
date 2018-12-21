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
import java.text.MessageFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import cz.startnet.utils.pgdiff.PgDiffArguments;
import cz.startnet.utils.pgdiff.PgDiffUtils;
import cz.startnet.utils.pgdiff.loader.jdbc.AntlrTask;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.SqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrContextProcessor.TSqlContextProcessor;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrError;
import cz.startnet.utils.pgdiff.parsers.antlr.AntlrParser;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.CustomTSQLParserListener;
import cz.startnet.utils.pgdiff.parsers.antlr.ReferenceListener;
import cz.startnet.utils.pgdiff.parsers.antlr.SQLOverridesListener;
import cz.startnet.utils.pgdiff.parsers.antlr.StatementBodyContainer;
import cz.startnet.utils.pgdiff.parsers.antlr.TSQLOverridesListener;
import cz.startnet.utils.pgdiff.schema.AbstractSchema;
import cz.startnet.utils.pgdiff.schema.MsSchema;
import cz.startnet.utils.pgdiff.schema.PgDatabase;
import cz.startnet.utils.pgdiff.schema.PgSchema;
import cz.startnet.utils.pgdiff.schema.PgStatement;
import cz.startnet.utils.pgdiff.schema.StatementOverride;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;

/**
 * Loads PostgreSQL dump into classes.
 *
 * @author fordfrog
 */
public class PgDumpLoader implements AutoCloseable {

    private final InputStream input;
    private boolean isInputInAntlrParser;

    private final String inputObjectName;
    private final PgDiffArguments args;

    private final IProgressMonitor monitor;
    private final int monitoringLevel;

    private final List<AntlrError> errors = new ArrayList<>();

    private final Queue<AntlrTask<?>> antlrTasks = new ArrayDeque<>();

    private boolean loadSchema = true;
    private boolean loadReferences;
    private List<StatementBodyContainer> statementBodyReferences;
    private Map<PgStatement, StatementOverride> overrides;

    public List<AntlrError> getErrors() {
        return errors;
    }

    public void setLoadSchema(boolean loadSchema) {
        this.loadSchema = loadSchema;
    }

    public void setOverridesMap(Map<PgStatement, StatementOverride> overrides) {
        this.overrides = overrides;
    }

    public void setLoadReferences(boolean loadReferences) {
        this.loadReferences = loadReferences;
    }

    public List<StatementBodyContainer> getStatementBodyReferences() {
        return statementBodyReferences;
    }

    public PgDumpLoader(InputStream input, String inputObjectName,
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
    public PgDumpLoader(InputStream input, String inputObjectName,
            PgDiffArguments args, IProgressMonitor monitor) {
        this(input, inputObjectName, args, monitor, 1);
    }

    /**
     * This constructor uses {@link NullProgressMonitor}.
     */
    public PgDumpLoader(InputStream input, String inputObjectName,
            PgDiffArguments args) {
        this(input, inputObjectName, args, new NullProgressMonitor(), 0);
    }

    /**
     * This constructor creates {@link InputStream} using inputFile parameter.
     * Call {@link #close()} after this {@link PgDumpLoader} instance is no longer needed,
     * or wrap usage of the instance with try-with-resources.
     */
    public PgDumpLoader(File inputFile, PgDiffArguments args,
            IProgressMonitor monitor, int monitoringLevel) throws IOException {
        this(new FileInputStream(inputFile), inputFile.toString(), args,
                monitor, monitoringLevel);
    }

    /**
     * @see #PgDumpLoader(File, PgDiffArguments, IProgressMonitor, int)
     * @see #PgDumpLoader(InputStream, String, PgDiffArguments, IProgressMonitor)
     */
    public PgDumpLoader(File inputFile, PgDiffArguments args,
            IProgressMonitor monitor) throws IOException {
        this(inputFile, args, monitor, 1);
    }

    /**
     * @see #PgDumpLoader(File, PgDiffArguments, IProgressMonitor, int)
     * @see #PgDumpLoader(InputStream, String, PgDiffArguments)
     */
    public PgDumpLoader(File inputFile, PgDiffArguments args) throws IOException {
        this(inputFile, args, new NullProgressMonitor(), 0);
    }

    public PgDatabase load() throws IOException, InterruptedException {
        PgDatabase d = new PgDatabase();
        d.setArguments(args);
        load(d);
        FullAnalyze.fullAnalyze(d, errors);
        return d;
    }

    public PgDatabase load(PgDatabase d) throws IOException, InterruptedException {
        AbstractSchema schema = args.isMsSql() ? new MsSchema(ApgdiffConsts.DBO) :
            new PgSchema(ApgdiffConsts.PUBLIC);
        d.addSchema(schema);
        d.setDefaultSchema(schema.getName());
        loadDatabase(d);
        d.getSchema(schema.getName()).setLocation(inputObjectName);
        return d;
    }

    protected PgDatabase loadDatabase(PgDatabase intoDb) throws IOException, InterruptedException {
        PgDiffUtils.checkCancelled(monitor);

        if (args.isMsSql()) {
            List<TSqlContextProcessor> listeners = new ArrayList<>();
            if (overrides != null) {
                listeners.add(new TSQLOverridesListener(intoDb, inputObjectName, errors, monitor, overrides));
            } else if (loadSchema) {
                listeners.add(new CustomTSQLParserListener(intoDb, inputObjectName, errors, monitor));
            }

            // TODO Uncomment this code and use it instead of
            // 'statementBodyReferences = Collections.emptyList()'
            // when references-mechanism for MSSQL will be added.
            /*
            if (loadReferences) {
                ReferenceListener refListener = new ReferenceListener(intoDb, inputObjectName, monitor);
                statementBodyReferences = refListener.getStatementBodies();
                listeners.add(refListener);
            }
             */
            statementBodyReferences = Collections.emptyList();

            isInputInAntlrParser = true;
            AntlrParser.parseTSqlStream(input, args.getInCharsetName(), inputObjectName, errors,
                    monitor, monitoringLevel, listeners, antlrTasks);
        } else {
            List<SqlContextProcessor> listeners = new ArrayList<>();
            if (overrides != null) {
                listeners.add(new SQLOverridesListener(intoDb, inputObjectName, errors, monitor, overrides));
            } else if (loadSchema) {
                listeners.add(new CustomSQLParserListener(intoDb, inputObjectName, errors, monitor));
            }
            if (loadReferences) {
                ReferenceListener refListener = new ReferenceListener(intoDb, inputObjectName, monitor);
                statementBodyReferences = refListener.getStatementBodies();
                listeners.add(refListener);
            }

            isInputInAntlrParser = true;
            AntlrParser.parseSqlStream(input, args.getInCharsetName(), inputObjectName, errors,
                    monitor, monitoringLevel, listeners, antlrTasks);
        }

        try {
            AntlrParser.finishAntlr(antlrTasks);
        } catch(Exception e) {
            throw new IOException(MessageFormat.format(Messages.PgDumpLoader_ProjReadingError,
                    e.getLocalizedMessage(), inputObjectName), e);
        }

        return intoDb;
    }

    @Override
    public void close() throws IOException {
        if (!isInputInAntlrParser) {
            input.close();
        }
    }
}