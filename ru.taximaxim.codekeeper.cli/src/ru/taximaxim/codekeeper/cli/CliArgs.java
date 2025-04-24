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
 *******************************************************************************/
package ru.taximaxim.codekeeper.cli;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import org.kohsuke.args4j.OptionHandlerRegistry;
import org.kohsuke.args4j.ParserProperties;

import ru.taximaxim.codekeeper.cli.localizations.CliArgsLocalizationsBunble;
import ru.taximaxim.codekeeper.cli.localizations.Messages;
import ru.taximaxim.codekeeper.cli.opthandlers.BooleanNoDefOptionHandler;
import ru.taximaxim.codekeeper.cli.opthandlers.DangerStatementOptionHandler;
import ru.taximaxim.codekeeper.cli.opthandlers.DbObjTypeOptionHandler;
import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.SourceFormat;
import ru.taximaxim.codekeeper.core.formatter.FormatConfiguration;
import ru.taximaxim.codekeeper.core.loader.UrlJdbcConnector;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.core.settings.ISettings;

/**
 * Extension of {@link PgDiffArguments} with annotated CLI fields.
 * Override getters so that clients will access either CLI or parent fields
 * depending on the instance.
 */
public class CliArgs implements ISettings {

    enum CliMode {
        DIFF,
        PARSE,
        GRAPH,
        INSERT,
        VERIFY;
    }

    private static final String URL_START_JDBC = "jdbc:"; //$NON-NLS-1$
    private static final int DEFAULT_DEPTH = 10;

    // SONAR-OFF
    {
        // this was moved to initializer to avoid the IDE making the field "final" on-save
        // otherwise args4j breaks
        this.allowedDangers = new ArrayList<>();
        this.allowedTypes = new ArrayList<>();
        this.graphFilterTypes = new ArrayList<>();
        this.ignoreLists = new ArrayList<>();
        this.sourceLibXmls = new ArrayList<>();
        this.sourceLibs = new ArrayList<>();
        this.sourceLibsWithoutPriv = new ArrayList<>();
        this.targetLibXmls = new ArrayList<>();
        this.targetLibs = new ArrayList<>();
        this.targetLibsWithoutPriv = new ArrayList<>();
        this.preFilePath = new ArrayList<>();
        this.postFilePath = new ArrayList<>();
        this.graphNames = new ArrayList<>();
        this.verifySources = new ArrayList<>();
        this.inCharsetName = Consts.UTF_8;
        this.outCharsetName = Consts.UTF_8;
        this.graphDepth = DEFAULT_DEPTH;
        this.dbType = DatabaseType.PG;
        this.mode = CliMode.DIFF;
    }
    // SONAR-ON

    // "special" options start with "z"

    // all (external) source <-> target (internal) swaps should be done here
    // and not in the (internal) program logic to avoid confusion and accidents
    // only here, everything "source" refers to the NEW DB, and target to OLD DB

    @Option(name="--help", help=true, usage="Help")
    private boolean zhelp;

    @Option(name="--version", help=true, usage="Version")
    private boolean zversion;

    @Option(name="--list-charsets", help=true, usage="ListCharsets")
    private boolean zlistCharsets;

    @Option(name="--clear-lib-cache", help=true, usage="ClearLibCache")
    private boolean clearLibCache;

    /**
     * @deprecated replaced by --mode PARSE
     */
    @Deprecated(forRemoval=true)
    @Option(name="--parse", depends="-o", forbids="--mode", usage="parse")
    private boolean modeParse;

    /**
     * @deprecated replaced by --mode GRAPH
     */
    @Deprecated(forRemoval=true)
    @Option(name="--graph", forbids="--mode", usage="graph")
    private boolean modeGraph;

    /**
     * @deprecated replaced by --mode INSERT
     */
    @Deprecated(forRemoval=true)
    @Option(name="--insert", forbids="--mode", usage="insert")
    private boolean isInsertMode;

    @Option(name="--mode", usage="mode")
    private CliMode mode;

    @Option(name="-s", depends="-t", aliases="--source", metaVar=CliArgsLocalizationsBunble.PATH_OR_JDBC,
            usage="source")
    @Argument(index=0, metaVar=CliArgsLocalizationsBunble.SOURCE, usage="source")
    private String newSrc;

    @Option(name="-t", depends="-s", aliases="--target", metaVar=CliArgsLocalizationsBunble.PATH_OR_JDBC,
            forbids={"--graph", "--parse", "--insert"}, usage="target")
    @Argument(index=1, metaVar=CliArgsLocalizationsBunble.DEST, usage="target")
    private String oldSrc;

    @Option(name="-o", aliases="--output", metaVar=CliArgsLocalizationsBunble.PATH, usage="output")
    private String outputTarget;

    @Option(name="-r", aliases="--run-on-target", forbids="-R",
            usage="run-on-target")
    private boolean runOnTarget;

    @Option(name="-R", aliases="--run-on", metaVar=CliArgsLocalizationsBunble.JDBC, forbids="-r", usage="run-on")
    private String runOnDb;

    @Option(name="--in-charset", metaVar=CliArgsLocalizationsBunble.CHARSET, usage="in-charset")
    private String inCharsetName;

    @Option(name="--out-charset", metaVar=CliArgsLocalizationsBunble.CHARSET, usage="out-charset")
    private String outCharsetName;

    @Option(name="-E", aliases="--error", usage = "error")
    private boolean isDebug;

    @Option(name="--ignore-errors", usage="ignore-errors")
    private boolean ignoreErrors;

    @Option(name="-P", aliases="--no-privileges", usage="no-privileges")
    private boolean ignorePrivileges;

    @Option(name="-L", aliases="--keep-newlines", usage="keep-newlines")
    private boolean keepNewlines;

    @Option(name="--simplify-views", usage="simplify-views")
    private boolean simplifyView;

    @Option(name="-X", aliases="--add-transaction", usage="add-transaction")
    private boolean addTransaction;

    @Option(name="-F", aliases="--no-check-function-bodies", usage="no-check-function-bodies")
    private boolean disableCheckFunctionBodies;

    @Option(name="-f", aliases="--enable-function-bodies-dependencies", usage="enable-function-bodies-dependencies")
    private boolean enableFunctionBodiesDependencies;

    @Option(name="-Z", aliases="--time-zone", metaVar=CliArgsLocalizationsBunble.TIMEZONE, usage="time-zone")
    private String timeZone;

    @Option(name="--pre-script", metaVar=CliArgsLocalizationsBunble.PATH, usage="pre-script")
    private List<String> preFilePath;

    @Option(name="--post-script", metaVar=CliArgsLocalizationsBunble.PATH, usage="post-script")
    private List<String> postFilePath;

    @Option(name="--ignore-column-order", usage="ignore-column-order")
    private boolean ignoreColumnOrder;

    @Option(name="-v", aliases="--generate-constraint-not-valid", usage="generate-constraint-not-valid")
    private boolean generateConstraintNotValid;

    @Option(name="--using-off", usage="using-off")
    private boolean usingTypeCastOff;

    @Option(name="--migrate-data", usage="migrate-data")
    private boolean dataMovementMode;

    @Option(name="-C", aliases="--concurrently-mode", usage="concurrently-mode")
    private boolean concurrentlyMode;

    @Option(name="--generate-exist", usage="generate-exist")
    private boolean generateExists;

    @Option(name="-do", aliases="--generate-exist-do-block", usage="generate-exist-do-block")
    private boolean generateExistDoBlock;

    @Option(name="--drop-before-create", usage="drop-before-create")
    private boolean dropBeforeCreate;

    @Option(name="--comments-to-end", usage="comments-to-end")
    private boolean commentsToEnd;

    @Option(name="-S", aliases="--safe-mode", usage="safe-mode")
    private boolean safeMode;

    @Option(name="-D", aliases="--allow-danger-ddl", handler=DangerStatementOptionHandler.class, usage="allow-danger-ddl")
    private List<DangerStatement> allowedDangers;

    @Option(name="-O", aliases="--allowed-object", handler=DbObjTypeOptionHandler.class, usage="allowed-object")
    private List<DbObjType> allowedTypes;

    @Option(name="--stop-not-allowed", usage = "stop-not-allowed")
    private boolean stopNotAllowed;

    @Option(name="--selected-only", usage="selected-only")
    private boolean selectedOnly;

    @Option(name="-I", aliases="--ignore-list", metaVar=CliArgsLocalizationsBunble.PATH, usage="ignore-list")
    private List<String> ignoreLists;

    @Option(name="--ignore-schema", metaVar=CliArgsLocalizationsBunble.PATH, usage="ignore-schema")
    private String ignoreSchemaList;

    @Option(name="--src-lib-xml", metaVar=CliArgsLocalizationsBunble.PATH, usage="src-lib-xml")
    private List<String> targetLibXmls;

    @Option(name="--src-lib", metaVar=CliArgsLocalizationsBunble.PATH_OR_JDBC, usage="src-lib")
    private List<String> targetLibs;

    @Option(name="--src-lib-no-priv", metaVar=CliArgsLocalizationsBunble.PATH_OR_JDBC, usage="src-lib-no-priv")
    private List<String> targetLibsWithoutPriv;

    @Option(name="--tgt-lib-xml", metaVar=CliArgsLocalizationsBunble.PATH, usage="tgt-lib-xml")
    private List<String> sourceLibXmls;

    @Option(name="--tgt-lib", metaVar=CliArgsLocalizationsBunble.PATH_OR_JDBC, usage="tgt-lib")
    private List<String> sourceLibs;

    @Option(name="--tgt-lib-no-priv", metaVar=CliArgsLocalizationsBunble.PATH_OR_JDBC, usage="tgt-lib-no-priv")
    private List<String> sourceLibsWithoutPriv;

    @Option(name="--lib-safe-mode", usage="lib-safe-mode")
    private boolean libSafeMode;

    @Option(name="-m", aliases="--ignore-concurrent-modification", usage="ignore-concurrent-modification")
    private boolean ignoreConcurrentModification;

    @Option(name="--db-type", usage="db-type")
    private DatabaseType dbType;

    @Option(name="--update-project", usage="update-project")
    private boolean projUpdate;

    @Option(name="--graph-depth", metaVar=CliArgsLocalizationsBunble.N, usage="graph-depth")
    private int graphDepth;

    @Option(name="--graph-reverse", depends="--graph-name", usage="graph-reverse")
    private boolean graphReverse;

    @Option(name="--graph-name", metaVar=CliArgsLocalizationsBunble.NAME, usage="graph-name")
    private List<String> graphNames;

    @Option(name="--graph-filter-object", handler=DbObjTypeOptionHandler.class, usage="graph-filter-object")
    private List<DbObjType> graphFilterTypes;

    @Option(name="--graph-invert-filter", depends="--graph-filter-object", usage="graph-invert-filter")
    private boolean graphInvertFilter;

    @Option(name="--insert-name", metaVar=CliArgsLocalizationsBunble.NAME, depends="--insert-filter", usage="insert-name")
    private String insertName;

    @Option(name="--insert-filter", metaVar=CliArgsLocalizationsBunble.FILTER, depends="--insert-name", usage="insert-filter")
    private String insertFilter;

    @Option(name="--verify-source", metaVar=CliArgsLocalizationsBunble.PATH, usage="verify-source")
    private List<String> verifySources;

    @Option(name="--verify-rule-set", metaVar=CliArgsLocalizationsBunble.PATH, usage="verify-rule-set")
    private String verifyRuleSetPath;

    private SourceFormat oldSrcFormat;
    private SourceFormat newSrcFormat;

    public CliMode getMode() {
        return mode;
    }

    public String getInsertName() {
        return insertName;
    }

    public String getInsertFilter() {
        return insertFilter;
    }

    public boolean isClearLibCache() {
        return clearLibCache;
    }

    public String getNewSrc() {
        return newSrc;
    }

    public void setNewSrc(String newSrc) {
        this.newSrc = newSrc;
    }

    public String getOldSrc() {
        return oldSrc;
    }

    public void setOldSrc(String oldSrc) {
        this.oldSrc = oldSrc;
    }

    public String getOutputTarget() {
        return outputTarget;
    }

    @Override
    public boolean isAddTransaction() {
        return addTransaction;
    }

    @Override
    public boolean isStopNotAllowed() {
        return stopNotAllowed;
    }

    public void setStopNotAllowed(boolean stopNotAllowed) {
        this.stopNotAllowed = stopNotAllowed;
    }

    public boolean isSafeMode() {
        return safeMode;
    }

    public boolean isRunOnTarget() {
        return runOnTarget;
    }

    public String getRunOnDb() {
        return runOnDb;
    }

    public Collection<DangerStatement> getAllowedDangers() {
        return Collections.unmodifiableCollection(allowedDangers);
    }

    public Collection<String> getIgnoreLists() {
        return Collections.unmodifiableCollection(ignoreLists);
    }

    public String getIgnoreSchemaList() {
        return ignoreSchemaList;
    }

    public Collection<String> getSourceLibXmls() {
        return Collections.unmodifiableCollection(sourceLibXmls);
    }

    public Collection<String> getSourceLibs() {
        return Collections.unmodifiableCollection(sourceLibs);
    }

    public Collection<String> getSourceLibsWithoutPriv() {
        return Collections.unmodifiableCollection(sourceLibsWithoutPriv);
    }

    public Collection<String> getTargetLibXmls() {
        return Collections.unmodifiableCollection(targetLibXmls);
    }

    public Collection<String> getTargetLibs() {
        return Collections.unmodifiableCollection(targetLibs);
    }

    public Collection<String> getTargetLibsWithoutPriv() {
        return Collections.unmodifiableCollection(targetLibsWithoutPriv);
    }

    public boolean isLibSafeMode() {
        return libSafeMode;
    }

    public void setLibSafeMode(boolean libSafeMode) {
        this.libSafeMode = libSafeMode;
    }

    @Override
    public DatabaseType getDbType() {
        return dbType;
    }

    @Override
    public boolean isIgnoreConcurrentModification() {
        return ignoreConcurrentModification;
    }

    public void setIgnoreConcurrentModification(boolean ignoreConcurrentModification) {
        this.ignoreConcurrentModification = ignoreConcurrentModification;
    }

    public boolean isDebug() {
        return isDebug;
    }

    public boolean isIgnoreErrors() {
        return ignoreErrors;
    }

    public void setIgnoreErrors(boolean ignoreErrors) {
        this.ignoreErrors = ignoreErrors;
    }

    @Override
    public boolean isIgnoreColumnOrder() {
        return ignoreColumnOrder;
    }

    public void setIgnoreColumnOrder(boolean ignoreColumnOrder) {
        this.ignoreColumnOrder = ignoreColumnOrder;
    }

    @Override
    public boolean isConstraintNotValid() {
        return generateConstraintNotValid;
    }

    public void setConstraintNotValid(boolean generateConstraintNotValid) {
        this.generateConstraintNotValid = generateConstraintNotValid;
    }

    @Override
    public String getInCharsetName() {
        return inCharsetName;
    }

    @Override
    public void setInCharsetName(String inCharsetName) {
        this.inCharsetName = inCharsetName;
    }

    public String getOutCharsetName() {
        return outCharsetName;
    }

    @Override
    public boolean isDisableCheckFunctionBodies() {
        return disableCheckFunctionBodies;
    }

    public void setDisableCheckFunctionBodies(boolean disableCheckFunctionBodies) {
        this.disableCheckFunctionBodies = disableCheckFunctionBodies;
    }

    @Override
    public boolean isEnableFunctionBodiesDependencies() {
        return enableFunctionBodiesDependencies;
    }

    public void setEnableFunctionBodiesDependencies(boolean enableFunctionBodiesDependencies) {
        this.enableFunctionBodiesDependencies = enableFunctionBodiesDependencies;
    }

    @Override
    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    @Override
    public boolean isIgnorePrivileges() {
        return ignorePrivileges;
    }

    @Override
    public void setIgnorePrivileges(boolean ignorePrivilleges) {
        this.ignorePrivileges = ignorePrivilleges;
    }

    @Override
    public boolean isKeepNewlines() {
        return keepNewlines;
    }

    public void setKeepNewlines(boolean keepNewlines) {
        this.keepNewlines = keepNewlines;
    }

    @Override
    public Collection<DbObjType> getAllowedTypes() {
        return Collections.unmodifiableCollection(allowedTypes);
    }

    public void setGenerateExists(boolean generateExists) {
        this.generateExists = generateExists;
    }

    @Override
    public boolean isGenerateExists() {
        return generateExists;
    }

    @Override
    public boolean isGenerateExistDoBlock() {
        return generateExistDoBlock;
    }

    public void setGenerateExistDoBlock(boolean generateExistDoBlock) {
        this.generateExistDoBlock = generateExistDoBlock;
    }

    @Override
    public boolean isDropBeforeCreate() {
        return dropBeforeCreate;
    }

    public void setDropBeforeCreate(boolean dropBeforeCreate) {
        this.dropBeforeCreate = dropBeforeCreate;
    }

    @Override
    public boolean isCommentsToEnd() {
        return commentsToEnd;
    }

    public void setCommentsToEnd(boolean commentsToEnd) {
        this.commentsToEnd = commentsToEnd;
    }

    public Collection<DbObjType> getGraphFilterTypes() {
        return Collections.unmodifiableCollection(graphFilterTypes);
    }

    public boolean isGraphInvertFilter() {
        return graphInvertFilter;
    }

    @Override
    public boolean isSelectedOnly() {
        return selectedOnly;
    }

    public void setSelectedOnly(boolean selectedOnly) {
        this.selectedOnly = selectedOnly;
    }

    @Override
    public boolean isDataMovementMode() {
        return dataMovementMode;
    }

    public void setDataMovementMode(boolean dataMovementMode) {
        this.dataMovementMode = dataMovementMode;
    }

    @Override
    public boolean isPrintUsing() {
        return usingTypeCastOff;
    }

    public void setUsingTypeCastOff(boolean usingTypeCastOff) {
        this.usingTypeCastOff = usingTypeCastOff;
    }

    @Override
    public boolean isConcurrentlyMode() {
        return concurrentlyMode;
    }

    public void setConcurrentlyMode(boolean concurrentlyMode) {
        this.concurrentlyMode = concurrentlyMode;
    }

    @Override
    public boolean isSimplifyView() {
        return simplifyView;
    }

    public void setSimplifyView(boolean simplifyView) {
        this.simplifyView = simplifyView;
    }

    public int getGraphDepth() {
        return graphDepth;
    }

    public boolean isGraphReverse() {
        return graphReverse;
    }

    public boolean isProjUpdate() {
        return projUpdate;
    }

    public void setProjUpdate(boolean projUpdate) {
        this.projUpdate = projUpdate;
    }

    public Collection<String> getGraphNames() {
        return Collections.unmodifiableCollection(graphNames);
    }

    @Override
    public Collection<String> getPreFilePath() {
        return Collections.unmodifiableCollection(preFilePath);
    }

    public void setPreFilePath(List<String> preFilePath) {
        this.preFilePath = preFilePath;
    }

    @Override
    public Collection<String> getPostFilePath() {
        return Collections.unmodifiableCollection(postFilePath);
    }

    public void setPostFilePath(List<String> postFilePath) {
        this.postFilePath = postFilePath;
    }

    public Collection<String> getVerifySources() {
        return Collections.unmodifiableCollection(verifySources);
    }

    public String getVerifyRuleSetPath() {
        return verifyRuleSetPath;
    }

    @Override
    public boolean isAutoFormatObjectCode() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public FormatConfiguration getFormatConfiguration() {
        // TODO Auto-generated method stub
        return null;
    }

    public SourceFormat getNewSrcFormat() {
        return newSrcFormat;
    }

    public SourceFormat getOldSrcFormat() {
        return oldSrcFormat;
    }

    @Override
    public ISettings copy() {
        var args = new CliArgs();
        args.addTransaction = addTransaction;
        args.allowedDangers = allowedDangers;
        args.allowedTypes = allowedTypes;
        args.clearLibCache = clearLibCache;
        args.commentsToEnd = commentsToEnd;
        args.concurrentlyMode = concurrentlyMode;
        args.dataMovementMode = dataMovementMode;
        args.dbType = dbType;
        args.disableCheckFunctionBodies = disableCheckFunctionBodies;
        args.dropBeforeCreate = dropBeforeCreate;
        args.enableFunctionBodiesDependencies = enableFunctionBodiesDependencies;
        args.generateConstraintNotValid = generateConstraintNotValid;
        args.generateExistDoBlock = generateExistDoBlock;
        args.dropBeforeCreate = dropBeforeCreate;
        args.enableFunctionBodiesDependencies = enableFunctionBodiesDependencies;
        args.generateConstraintNotValid = generateConstraintNotValid;
        args.generateExistDoBlock = generateExistDoBlock;
        args.generateExists = generateExists;
        args.graphDepth = graphDepth;
        args.graphFilterTypes = graphFilterTypes;
        args.graphInvertFilter = graphInvertFilter;
        args.graphNames = graphNames;
        args.graphReverse = graphReverse;
        args.ignoreColumnOrder = ignoreColumnOrder;
        args.ignoreConcurrentModification = ignoreConcurrentModification;
        args.ignoreErrors = ignoreErrors;
        args.ignoreLists = ignoreLists;
        args.ignorePrivileges = ignorePrivileges;
        args.ignoreSchemaList = ignoreSchemaList;
        args.inCharsetName = inCharsetName;
        args.insertFilter = insertFilter;
        args.insertName = insertName;
        args.keepNewlines = keepNewlines;
        args.libSafeMode = libSafeMode;
        args.mode = mode;
        args.newSrc = newSrc;
        args.newSrcFormat = newSrcFormat;
        args.oldSrc = oldSrc;
        args.oldSrcFormat = oldSrcFormat;
        args.outCharsetName = outCharsetName;
        args.outputTarget = outputTarget;
        args.postFilePath = postFilePath;
        args.preFilePath = preFilePath;
        args.projUpdate = projUpdate;
        args.runOnDb = runOnDb;
        args.runOnTarget = runOnTarget;
        args.safeMode = safeMode;
        args.selectedOnly = selectedOnly;
        args.simplifyView = simplifyView;
        args.sourceLibs = sourceLibs;
        args.sourceLibsWithoutPriv = sourceLibsWithoutPriv;
        args.sourceLibXmls = sourceLibXmls;
        args.stopNotAllowed = stopNotAllowed;
        args.targetLibs = targetLibs;
        args.targetLibsWithoutPriv = targetLibsWithoutPriv;
        args.targetLibXmls = targetLibXmls;
        args.timeZone = timeZone;
        args.usingTypeCastOff = usingTypeCastOff;
        args.verifyRuleSetPath = verifyRuleSetPath;
        args.verifySources = verifySources;
        return args;
    }

    /**
     * Parses command line arguments or outputs instructions.
     *
     * @param writer writer to be used for info output
     * @param args   array of arguments
     *
     * @return true if arguments were parsed and execution can continue,
     *         otherwise false
     */
    public boolean parse(PrintWriter writer, String[] args) throws CmdLineException {
        if (args.length != 0) {
            new CmdLineParser(this).parseArgument(args);
        } else {
            // show help instead of failing for 0 args
            zhelp = true;
        }
        if (zhelp) {
            printUsage(writer);
            return false;
        }
        if (zversion) {
            printVersion(writer);
            return false;
        }
        if (zlistCharsets) {
            listCharsets(writer);
            return false;
        }

        // backwards compatibility
        convertDeprecatedArguments();

        if (clearLibCache && CliMode.DIFF == mode && (oldSrc == null || newSrc == null)) {
            return true;
        }

        checkModeParams();
        checkDbTypesParam();
        checkParams();

        if (CliMode.DIFF == mode) {
            if (oldSrc == null || newSrc == null) {
                badArgs(Messages.CliArgs_error_source_dest);
            }
            oldSrcFormat = SourceFormat.parsePath(oldSrc);
        } else if (CliMode.PARSE == mode && projUpdate) {
            setOldSrc(outputTarget);
            oldSrcFormat = SourceFormat.parsePath(oldSrc);
        }

        if (CliMode.VERIFY != mode) {
            newSrcFormat = SourceFormat.parsePath(newSrc);
        }

        return true;
    }

    private void convertDeprecatedArguments() {
        if (modeParse) {
            mode = CliMode.PARSE;
        } else if (modeGraph) {
            mode = CliMode.GRAPH;
        } else if (isInsertMode) {
            mode = CliMode.INSERT;
        }
    }

    private void checkParams() throws CmdLineException {
        if (CliMode.VERIFY == mode) {
            if (verifyRuleSetPath == null) {
                badArgs(Messages.CliArgs_error_argument_null.formatted("\"--verify-rule-name\"")); //$NON-NLS-1$
            }
            if (verifySources.isEmpty()) {
                badArgs(Messages.CliArgs_error_argument_null.formatted("\"--verify-source\"")); //$NON-NLS-1$
            }
            return;
        }

        if (newSrc == null) {
            badArgs(Messages.CliArgs_error_source_null);
        }

        if (CliMode.DIFF == mode) {
            if (dbType == DatabaseType.PG && addTransaction && concurrentlyMode) {
                badArgs(Messages.CliArgs_error_concurrently_mode_wrong_option);
            }

            DatabaseType typeNewSrc = getDatabaseTypeFromSource(newSrc);
            DatabaseType typeOldSrc = getDatabaseTypeFromSource(oldSrc);
            if (typeOldSrc != typeNewSrc) {
                badArgs(String.format(Messages.CliArgs_error_different_types, typeNewSrc.toString(),
                        typeOldSrc.toString()));
            }
            if (runOnTarget && !oldSrc.startsWith(URL_START_JDBC)) {
                badArgs(Messages.CliArgs_error_target_non_db);
            }
            if (runOnDb != null && !runOnDb.startsWith(URL_START_JDBC)) {
                badArgs(Messages.CliArgs_error_run_on_non_jdbc);
            }
        } else {
            DatabaseType typeNewSrc = getDatabaseTypeFromSource(newSrc);
            if (dbType != typeNewSrc) {
                badArgs(String.format(Messages.CliArgs_error_message_cannot_database_with_project,
                        typeNewSrc.toString(), dbType.toString()));
            }
            if (CliMode.PARSE == mode && outputTarget == null) {
                badArgs(Messages.CliArgs_error_argument_null.formatted("\"-o (--output)\"")); //$NON-NLS-1$
            }
            if (CliMode.INSERT == mode) {
                if (!newSrc.startsWith(URL_START_JDBC)) {
                    badArgs(Messages.CliArgs_error_source_non_db);
                }
                if (runOnDb != null && !runOnDb.startsWith(URL_START_JDBC)) {
                    badArgs(Messages.CliArgs_error_run_on_non_jdbc);
                }
                if (insertName == null) {
                    badArgs(Messages.CliArgs_error_argument_null.formatted("\"--insert-name\"")); //$NON-NLS-1$
                }
            }
        }
    }

    private void checkModeParams() throws CmdLineException {
        // argument can be used only with mode
        badArgWithCorrectModes(newSrc != null, "-s (--source)", CliMode.DIFF, CliMode.PARSE, CliMode.GRAPH, //$NON-NLS-1$
                CliMode.INSERT);
        badArgWithCorrectModes(oldSrc != null, "-t (--target)", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(addTransaction, "-X (--add-transaction)", CliMode.DIFF, CliMode.INSERT); //$NON-NLS-1$
        badArgWithCorrectModes(runOnDb != null, "-R (--run-on)", CliMode.DIFF, CliMode.INSERT); //$NON-NLS-1$
        badArgWithCorrectModes(enableFunctionBodiesDependencies, "-f (--enable-function-bodies-dependencies)", //$NON-NLS-1$
                CliMode.DIFF, CliMode.PARSE, CliMode.GRAPH);
        badArgWithCorrectModes(simplifyView, "--simplify-views", CliMode.DIFF, CliMode.PARSE); //$NON-NLS-1$
        badArgWithCorrectModes(timeZone != null, "-Z (--time-zone)", CliMode.DIFF, CliMode.PARSE); //$NON-NLS-1$
        badArgWithCorrectModes(!allowedTypes.isEmpty(), "-O (--allowed-object)", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(!ignoreLists.isEmpty(), "-I (--ignore-list)", CliMode.DIFF, CliMode.PARSE); //$NON-NLS-1$
        badArgWithCorrectModes(selectedOnly, "--selected-only", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(runOnTarget, "-r (--run-on-target)", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(disableCheckFunctionBodies, "-F (--no-check-function-bodies)", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(!preFilePath.isEmpty(), "--pre-script", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(!postFilePath.isEmpty(), "--post-script", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(ignoreColumnOrder, "--ignore-column-order", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(generateConstraintNotValid, "-v (--generate-constraint-not-valid)", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(usingTypeCastOff, "--using-off", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(dataMovementMode, "--migrate-data", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(concurrentlyMode, "-C (--concurrently-mode)", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(generateExists, "--generate-exist", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(generateExistDoBlock, "-do (--generate-exist-do-block)", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(dropBeforeCreate, "--drop-before-create", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(commentsToEnd, "--comments-to-end", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(safeMode, "-S (--safe-mode)", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(!allowedDangers.isEmpty(), "-D (--allow-danger-ddl)", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(stopNotAllowed, "--stop-not-allowed", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(!sourceLibXmls.isEmpty(), "--tgt-lib-xml", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(!sourceLibs.isEmpty(), "--tgt-lib", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(!sourceLibsWithoutPriv.isEmpty(), "--tgt-lib-no-priv", CliMode.DIFF); //$NON-NLS-1$
        badArgWithCorrectModes(projUpdate, "--update-project", CliMode.PARSE); //$NON-NLS-1$
        badArgWithCorrectModes(!graphNames.isEmpty(), "--graph-name", CliMode.GRAPH); //$NON-NLS-1$
        badArgWithCorrectModes(DEFAULT_DEPTH != graphDepth, "--graph-depth", CliMode.GRAPH); //$NON-NLS-1$
        badArgWithCorrectModes(!graphFilterTypes.isEmpty(), "--graph-filter-object", CliMode.GRAPH); //$NON-NLS-1$
        badArgWithCorrectModes(insertName != null, "--insert-name", CliMode.INSERT); //$NON-NLS-1$
        badArgWithCorrectModes(!verifySources.isEmpty(), "--verify-source", CliMode.VERIFY); //$NON-NLS-1$
        badArgWithCorrectModes(verifyRuleSetPath != null, "--verify-rule-set", CliMode.VERIFY); //$NON-NLS-1$
    }

    private void checkDbTypesParam() throws CmdLineException {
        badArgWithWrongDbType(simplifyView, "--simplify-views", DatabaseType.MS, DatabaseType.CH); //$NON-NLS-1$
        badArgWithWrongDbType(timeZone != null, "-Z (--time-zone)", DatabaseType.MS, DatabaseType.CH); //$NON-NLS-1$
        badArgWithWrongDbType(generateExistDoBlock, "-do (--generate-exist-do-block)", DatabaseType.MS, //$NON-NLS-1$
                DatabaseType.CH);
        badArgWithWrongDbType(concurrentlyMode, "-C (--concurrently-mode)", DatabaseType.CH); //$NON-NLS-1$
        badArgWithWrongDbType(commentsToEnd, "--comments-to-end", DatabaseType.CH); //$NON-NLS-1$
        badArgWithWrongDbType(CliMode.INSERT == mode, "--mode INSERT", DatabaseType.CH); //$NON-NLS-1$
        badArgWithWrongDbType(CliMode.VERIFY == mode, "--mode VERIFY", DatabaseType.CH, DatabaseType.MS); //$NON-NLS-1$
    }

    private void badArgWithCorrectModes(boolean condition, String param, CliMode... modes) throws CmdLineException {
        if (condition && !containsInArray(mode, modes)) {
            badArgs(MessageFormat.format(Messages.CliArgs_error_wrong_mode, param, mode));
        }
    }

    private void badArgWithWrongDbType(boolean condition, String arg, DatabaseType... wrongDbTypes)
            throws CmdLineException {
        if (condition && containsInArray(dbType, wrongDbTypes)) {
            badArgs(MessageFormat.format(Messages.CliArgs_error_wrong_db_type, arg, dbType));
        }
    }

    private void badArgs(String message) throws CmdLineException {
        throw new CmdLineException(null, message, null);
    }

    private DatabaseType getDatabaseTypeFromSource(String src) {
        if (src != null && src.startsWith(URL_START_JDBC)) {
            return UrlJdbcConnector.getDatabaseTypeFromUrl(src);
        }
        return dbType;
    }

    private void printUsage(PrintWriter writer) {
        // fix defaults for options like help and other 0-arg booleans
        OptionHandlerRegistry.getRegistry().registerHandler(Boolean.class, BooleanNoDefOptionHandler.class);
        OptionHandlerRegistry.getRegistry().registerHandler(boolean.class, BooleanNoDefOptionHandler.class);

        ParserProperties prop = ParserProperties.defaults().withUsageWidth(80).withOptionSorter(null);

        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        // new args instance to get correct defaults
        new CmdLineParser(new CliArgs(), prop).printUsage(new OutputStreamWriter(buf, StandardCharsets.UTF_8),
                new CliArgsLocalizationsBunble());

        writer.println(MessageFormat.format(Messages.UsageHelp.replace("${tab}", "\t"), //$NON-NLS-1$ //$NON-NLS-2$
                new String(buf.toByteArray(), StandardCharsets.UTF_8),
                DangerStatementOptionHandler.getMetaVariable() + '\n' + DbObjTypeOptionHandler.getMetaVariable()));
    }

    private void printVersion(PrintWriter writer) {
        writer.println(MessageFormat.format(Messages.Version, Utils.getVersion()));
    }

    private void listCharsets(PrintWriter writer) {
        Charset.availableCharsets().keySet().forEach(writer::println);
    }

    private <T> boolean containsInArray(T element, T[] elements) {
        for (T t : elements) {
            if (t == element) {
                return true;
            }
        }

        return false;
    }
}