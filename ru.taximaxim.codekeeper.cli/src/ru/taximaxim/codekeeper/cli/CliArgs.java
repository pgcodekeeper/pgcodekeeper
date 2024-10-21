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
package ru.taximaxim.codekeeper.cli;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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

import ru.taximaxim.codekeeper.cli.localizations.Messages;
import ru.taximaxim.codekeeper.cli.opthandlers.BooleanNoDefOptionHandler;
import ru.taximaxim.codekeeper.cli.opthandlers.DangerStatementOptionHandler;
import ru.taximaxim.codekeeper.cli.opthandlers.DbObjTypeOptionHandler;
import ru.taximaxim.codekeeper.core.Consts;
import ru.taximaxim.codekeeper.core.DangerStatement;
import ru.taximaxim.codekeeper.core.DatabaseType;
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.loader.UrlJdbcConnector;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

/**
 * Extension of {@link PgDiffArguments} with annotated CLI fields.
 * Override getters so that clients will access either CLI or parent fields
 * depending on the instance.
 */
public class CliArgs extends PgDiffArguments {

    enum CliMode {
        DIFF,
        PARSE,
        GRAPH,
        INSERT,
        VERIFY;
    }

    private static final String URL_START_JDBC = "jdbc:";

    private static final String MESSAGE_WRONG_MODE = "option \"{0}\" cannot be used with mode: {1}";
    private static final String MESSAGE_CANNOT_DATABASE_WITH_PROJECT = "Cannot work with %s database as %s project.";
    private static final String MESSAGE_DIFFERENT_TYPES = "Source (%s) and target (%s) are of different types, possibly missing --db-type parameter.";
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

    @Option(name="--help", help=true, usage="show this help")
    private boolean zhelp;

    @Option(name="--version", help=true, usage="show version")
    private boolean zversion;

    @Option(name="--list-charsets", help=true, usage="show list of Java-supported charsets")
    private boolean zlistCharsets;

    @Option(name="--clear-lib-cache", help=true, usage="clear library cache")
    private boolean clearLibCache;

    /**
     * @deprecated replaced by --mode PARSE
     */
    @Deprecated(forRemoval=true)
    @Option(name="--parse", depends="-o", forbids="--mode",
            usage="deprecated option. Use --mode PARSE. Run in parser mode to save database schema as a directory hierarchy")
    private boolean modeParse;

    /**
     * @deprecated replaced by --mode GRAPH
     */
    @Deprecated(forRemoval=true)
    @Option(name="--graph", forbids="--mode",
            usage="deprecated option. Use --mode GRAPH. Run in graph mode to show objects dependencies")
    private boolean modeGraph;

    /**
     * @deprecated replaced by --mode INSERT
     */
    @Deprecated(forRemoval=true)
    @Option(name="--insert", forbids="--mode",
            usage="deprecated option. Use --mode INSERT. Run in insert mode to collect data")
    private boolean isInsertMode;

    @Option(name="--mode",
            usage="""
                specify mode:
                DIFF - to compares the two sources and generates a migration script;
                PARSE - to save database schema as a directory hierarchy;
                GRAPH - to search for dependencies of an object;
                INSERT - to gathering data from the source database taking into account the FK dependencies;
                VERIFY - to check code style;
                """)
    private CliMode mode;

    @Option(name="-s", depends="-t", aliases="--source", metaVar="<path or JDBC>",
            usage="source of schema changes")
    @Argument(index=0, metaVar="SOURCE", usage="source of schema changes")
    private String newSrc;

    @Option(name="-t", depends="-s", aliases="--target", metaVar="<path or JDBC>",
            forbids={"--graph", "--parse", "--insert"}, usage="destination for schema changes (diff mode only)")
    @Argument(index=1, metaVar="DEST", usage="destination for schema changes (diff mode only)")
    private String oldSrc;

    @Option(name="-o", aliases="--output", metaVar="<path>",
            usage="script output file or parser output directory")
    private String outputTarget;

    @Option(name="-r", aliases="--run-on-target", forbids="-R",
            usage="run generated script on the target database")
    private boolean runOnTarget;

    @Option(name="-R", aliases="--run-on", metaVar="<JDBC>", forbids="-r",
            usage="run generated script on the specified database")
    private String runOnDb;

    @Option(name="--in-charset", metaVar="<charset>", usage="input charset")
    private String inCharsetName;

    @Option(name="--out-charset", metaVar="<charset>", usage="output charset")
    private String outCharsetName;

    @Option(name="-E", aliases="--error",
            usage="print exception stacktrace")
    private boolean isDebug;

    @Option(name="--ignore-errors",
            usage="do not stop on parse errors")
    private boolean ignoreErrors;

    @Option(name="-P", aliases="--no-privileges",
            usage="ignore privileges and owners of database objects")
    private boolean ignorePrivileges;

    @Option(name="-L", aliases="--keep-newlines",
            usage="keep newline characters as is (don't convert to Unix newlines)")
    private boolean keepNewlines;

    @Option(name="--simplify-views",
            usage="simple formatting for VIEWs when reading via JDBC (not recomended by PostgreSQL)")
    private boolean simplifyView;

    @Option(name="-X", aliases="--add-transaction",
            usage="wrap generated script with transaction statements")
    private boolean addTransaction;

    @Option(name="-F", aliases="--no-check-function-bodies",
            usage="set check_function_bodies to false at the beginning of the script")
    private boolean disableCheckFunctionBodies;

    @Option(name="-f", aliases="--enable-function-bodies-dependencies",
            usage="enable dependencies from bodies of functions and procedures to other functions or procedures")
    private boolean enableFunctionBodiesDependencies;

    @Option(name="-Z", aliases="--time-zone", metaVar="<timezone>",
            usage="use this timezone when working with database, also add SET TIMEZONE statement to the script")
    private String timeZone;

    @Option(name="--pre-script", metaVar="<path>",
            usage="""
                PRE script file path or directory with PRE scripts
                nested directories are loaded recursively
                specify multiple times to use several paths""")
    private List<String> preFilePath;

    @Option(name="--post-script", metaVar="<path>",
            usage="""
                POST script file path or directory with POST scripts
                nested directories are loaded recursively
                specify multiple times to use several paths""")
    private List<String> postFilePath;

    @Option(name="--ignore-column-order",
            usage="ignore differences in table column order")
    private boolean ignoreColumnOrder;

    @Option(name="-v", aliases="--generate-constraint-not-valid",
            usage="print CONSTRAINT NOT VALID for no partitioned tables")
    private boolean generateConstraintNotValid;

    @Option(name="--using-off",
            usage="do not print USING expression for ALTER COLUMN TYPE")
    private boolean usingTypeCastOff;

    @Option(name="--migrate-data",
            usage="migrate data when re-creating tables")
    private boolean dataMovementMode;

    @Option(name="-C", aliases="--concurrently-mode",
            usage="print CREATE INDEX with CONCURRENTLY option for PostgreSQL and WITH ONLINE = ON for MS SQL")
    private boolean concurrentlyMode;

    @Option(name="--generate-exist",
            usage="print CREATE IF NOT EXISTS / DROP IF EXISTS")
    private boolean generateExists;

    @Option(name="-do", aliases="--generate-exist-do-block",
            usage="print creation of CONSTRAINT and IDENTITY in DO block (PG only)")
    private boolean generateExistDoBlock;

    @Option(name="--drop-before-create",
            usage="print DROP before CREATE statement")
    private boolean dropBeforeCreate;

    @Option(name="--comments-to-end",
            usage="print comments at the end of the script")
    private boolean commentsToEnd;

    @Option(name="-S", aliases="--safe-mode",
            usage="do not generate scripts containing dangerous statements\nsee: --allow-danger-ddl")
    private boolean safeMode;

    @Option(name="-D", aliases="--allow-danger-ddl",
            handler=DangerStatementOptionHandler.class,
            usage="allows dangerous statements in safe-mode scripts")
    private List<DangerStatement> allowedDangers;

    @Option(name="-O", aliases="--allowed-object",
            handler=DbObjTypeOptionHandler.class,
            usage="build the script using these object types only, hide statements of other objects")
    private List<DbObjType> allowedTypes;

    @Option(name="--stop-not-allowed",
            usage="exit with an error when --allowed-object hides a dependency statement from the script")
    private boolean stopNotAllowed;

    @Option(name="--selected-only",
            usage="build the script using 'selected' objects only, hide statements of other objects"
                    + "\nin CLI, selected means included by --allowed-object and ignore lists")
    private boolean selectedOnly;

    @Option(name="-I", aliases="--ignore-list", metaVar="<path>",
            usage="use an ignore list to include/exclude objects from diff"
                    + "\nspecify multiple times to use several lists")
    private List<String> ignoreLists;

    @Option(name="--ignore-schema", metaVar="<path>",
            usage="use an ignore schema list to include/exclude schemas at loading stage")
    private String ignoreSchemaList;

    @Option(name="--src-lib-xml", metaVar="<path>",
            usage="add xml with library dependencies to source"
                    + "\nspecify multiple times to use several library xml's")
    private List<String> targetLibXmls;

    @Option(name="--src-lib", metaVar="<path or JDBC>",
            usage="add library dependency to source"
                    + "\nspecify multiple times to use several libraries")
    private List<String> targetLibs;

    @Option(name="--src-lib-no-priv", metaVar="<path or JDBC>",
            usage="add library dependency to source without privileges"
                    + "\nspecify multiple times to use several libraries")
    private List<String> targetLibsWithoutPriv;

    @Option(name="--tgt-lib-xml", metaVar="<path>",
            usage="add xml with library dependencies to target"
                    + "\nspecify multiple times to use several library xml's")
    private List<String> sourceLibXmls;

    @Option(name="--tgt-lib", metaVar="<path or JDBC>",
            usage="add library dependency to destination"
                    + "\nspecify multiple times to use several libraries")
    private List<String> sourceLibs;

    @Option(name="--tgt-lib-no-priv", metaVar="<path or JDBC>",
            usage="add library dependency to destination without privileges"
                    + "\nspecify multiple times to use several libraries")
    private List<String> sourceLibsWithoutPriv;

    @Option(name="--lib-safe-mode",
            usage="exit with an error if a library object conflicts with other schema or library objects"
                    + "\notherwise, in case of conflicts objects loaded first have priority")
    private boolean libSafeMode;

    @Option(name="-m", aliases="--ignore-concurrent-modification",
            usage="ignore concurrent modification errors of database objects")
    private boolean ignoreConcurrentModification;

    @Option(name="--db-type",
            usage="specify database type for work: PG, MS, CH")
    private DatabaseType dbType;

    @Option(name="--update-project",
            usage="update an existing project in parse mode")
    private boolean projUpdate;

    @Option(name="--graph-depth", metaVar="<n>",
            usage="depth of displayed dependencies in graph mode")
    private int graphDepth;

    @Option(name="--graph-reverse", depends="--graph-name",
            usage="reverse the direction of the graph to show objects on which the starting object depends")
    private boolean graphReverse;

    @Option(name="--graph-name", metaVar="<name>",
            usage="name of start object in graph mode"
                    + "\nspecify multiple times to use several names")
    private List<String> graphNames;

    @Option(name="--graph-filter-object",
            handler=DbObjTypeOptionHandler.class,
            usage="show these object types, hide  other objects types")
    private List<DbObjType> graphFilterTypes;

    @Option(name="--graph-invert-filter", depends="--graph-filter-object",
            usage="invert graph filter object types: hide objects specified by the filter")
    private boolean graphInvertFilter;

    @Option(name="--insert-name", metaVar="<name>", depends="--insert-filter",
            usage="name of start object in data insert mode")
    private String insertName;

    @Option(name="--insert-filter", metaVar="<filter>", depends="--insert-name",
            usage="value of where for script of select for start object")
    private String insertFilter;

    @Option(name="--verify-source", metaVar="<path>",
            usage="""
                path to file or directory for code verification
                specify multiple times to use several paths""")
    private List<String> verifySources;

    @Option(name="--verify-rule-set", metaVar="<path>",
            usage="path to a file with a set of rules for code verification")
    private String verifyRuleSetPath;

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

    @Override
    public String getNewSrc() {
        return newSrc;
    }

    @Override
    public void setNewSrc(String newSrc) {
        this.newSrc = newSrc;
    }

    @Override
    public String getOldSrc() {
        return oldSrc;
    }

    @Override
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
    public void setAddTransaction(boolean addTransaction) {
        this.addTransaction = addTransaction;
    }

    @Override
    public boolean isStopNotAllowed() {
        return stopNotAllowed;
    }

    @Override
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

    @Override
    public Collection<String> getIgnoreLists() {
        return Collections.unmodifiableCollection(ignoreLists);
    }

    @Override
    public String getIgnoreSchemaList() {
        return ignoreSchemaList;
    }

    @Override
    public Collection<String> getSourceLibXmls() {
        return Collections.unmodifiableCollection(sourceLibXmls);
    }

    @Override
    public Collection<String> getSourceLibs() {
        return Collections.unmodifiableCollection(sourceLibs);
    }

    @Override
    public Collection<String> getSourceLibsWithoutPriv() {
        return Collections.unmodifiableCollection(sourceLibsWithoutPriv);
    }

    @Override
    public Collection<String> getTargetLibXmls() {
        return Collections.unmodifiableCollection(targetLibXmls);
    }

    @Override
    public Collection<String> getTargetLibs() {
        return Collections.unmodifiableCollection(targetLibs);
    }

    @Override
    public Collection<String> getTargetLibsWithoutPriv() {
        return Collections.unmodifiableCollection(targetLibsWithoutPriv);
    }

    @Override
    public boolean isLibSafeMode() {
        return libSafeMode;
    }

    @Override
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

    @Override
    public void setIgnoreConcurrentModification(boolean ignoreConcurrentModification) {
        this.ignoreConcurrentModification = ignoreConcurrentModification;
    }

    public boolean isDebug() {
        return isDebug;
    }

    @Override
    public boolean isIgnoreErrors() {
        return ignoreErrors;
    }

    @Override
    public void setIgnoreErrors(boolean ignoreErrors) {
        this.ignoreErrors = ignoreErrors;
    }

    @Override
    public boolean isIgnoreColumnOrder() {
        return ignoreColumnOrder;
    }

    @Override
    public void setIgnoreColumnOrder(boolean ignoreColumnOrder) {
        this.ignoreColumnOrder = ignoreColumnOrder;
    }

    @Override
    public boolean isConstraintNotValid() {
        return generateConstraintNotValid;
    }

    @Override
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

    @Override
    public void setDisableCheckFunctionBodies(boolean disableCheckFunctionBodies) {
        this.disableCheckFunctionBodies = disableCheckFunctionBodies;
    }

    @Override
    public boolean isEnableFunctionBodiesDependencies() {
        return enableFunctionBodiesDependencies;
    }

    @Override
    public void setEnableFunctionBodiesDependencies(boolean enableFunctionBodiesDependencies) {
        this.enableFunctionBodiesDependencies = enableFunctionBodiesDependencies;
    }

    @Override
    public String getTimeZone() {
        return timeZone;
    }

    @Override
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

    @Override
    public void setKeepNewlines(boolean keepNewlines) {
        this.keepNewlines = keepNewlines;
    }

    @Override
    public Collection<DbObjType> getAllowedTypes() {
        return Collections.unmodifiableCollection(allowedTypes);
    }

    @Override
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

    @Override
    public void setGenerateExistDoBlock(boolean generateExistDoBlock) {
        this.generateExistDoBlock = generateExistDoBlock;
    }

    @Override
    public boolean isDropBeforeCreate() {
        return dropBeforeCreate;
    }

    @Override
    public void setDropBeforeCreate(boolean dropBeforeCreate) {
        this.dropBeforeCreate = dropBeforeCreate;
    }

    @Override
    public boolean isCommentsToEnd() {
        return commentsToEnd;
    }

    @Override
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

    @Override
    public void setSelectedOnly(boolean selectedOnly) {
        this.selectedOnly = selectedOnly;
    }

    @Override
    public boolean isDataMovementMode() {
        return dataMovementMode;
    }

    @Override
    public void setDataMovementMode(boolean dataMovementMode) {
        this.dataMovementMode = dataMovementMode;
    }

    @Override
    public boolean isUsingTypeCastOff() {
        return usingTypeCastOff;
    }

    @Override
    public void setUsingTypeCastOff(boolean usingTypeCastOff) {
        this.usingTypeCastOff = usingTypeCastOff;
    }

    @Override
    public boolean isConcurrentlyMode() {
        return concurrentlyMode;
    }

    @Override
    public void setConcurrentlyMode(boolean concurrentlyMode) {
        this.concurrentlyMode = concurrentlyMode;
    }

    @Override
    public boolean isSimplifyView() {
        return simplifyView;
    }

    @Override
    public void setSimplifyView(boolean simplifyView) {
        this.simplifyView = simplifyView;
    }

    public int getGraphDepth() {
        return graphDepth;
    }

    public boolean isGraphReverse() {
        return graphReverse;
    }

    @Override
    public boolean isProjUpdate() {
        return projUpdate;
    }

    @Override
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

    @Override
    public void setPreFilePath(List<String> preFilePath) {
        this.preFilePath = preFilePath;
    }

    @Override
    public Collection<String> getPostFilePath() {
        return Collections.unmodifiableCollection(postFilePath);
    }

    @Override
    public void setPostFilePath(List<String> postFilePath) {
        this.postFilePath = postFilePath;
    }

    public Collection<String> getVerifySources() {
        return Collections.unmodifiableCollection(verifySources);
    }

    public String getVerifyRuleSetPath() {
        return verifyRuleSetPath;
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
                badArgs("Please specify both SOURCE and DEST.");
            }
            setOldSrcFormat(parsePath(oldSrc));
        } else if (CliMode.PARSE == mode && projUpdate) {
            setOldSrc(outputTarget);
            setOldSrcFormat(parsePath(oldSrc));
        }

        if (CliMode.VERIFY != mode) {
            setNewSrcFormat(parsePath(newSrc));
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
                badArgs("Please specify argument \"--verify-rule-name\"");
            }
            if (verifySources.isEmpty()) {
                badArgs("Please specify argument \"--verify-source\"");
            }
            return;
        }

        if (newSrc == null) {
            badArgs("Please specify SCHEMA.");
        }

        if (CliMode.DIFF == mode) {
            if (dbType == DatabaseType.PG && addTransaction && concurrentlyMode) {
                badArgs("-C (--concurrently-mode) cannot be used with the option(s) -X (--add-transaction) for PostgreSQL.");
            }

            DatabaseType typeNewSrc = getDatabaseTypeFromSource(newSrc);
            DatabaseType typeOldSrc = getDatabaseTypeFromSource(oldSrc);
            if (typeOldSrc != typeNewSrc) {
                badArgs(String.format(MESSAGE_DIFFERENT_TYPES, typeNewSrc.toString(), typeOldSrc.toString()));
            }
            if (runOnTarget && !oldSrc.startsWith(URL_START_JDBC)) {
                badArgs("Cannot run script on non-database target.");
            }
            if (runOnDb != null && !runOnDb.startsWith(URL_START_JDBC)) {
                badArgs("Option -R (--run-on) must specify JDBC connection string.");
            }
        } else {
            DatabaseType typeNewSrc = getDatabaseTypeFromSource(newSrc);
            if (dbType != typeNewSrc) {
                badArgs(String.format(MESSAGE_CANNOT_DATABASE_WITH_PROJECT, typeNewSrc.toString(), dbType.toString()));
            }
            if (CliMode.PARSE == mode && outputTarget == null) {
                badArgs("Please specify argument \"-o (--output)\"");
            }
            if (CliMode.INSERT == mode) {
                if (!newSrc.startsWith(URL_START_JDBC)) {
                    badArgs("Cannot run work with non-database source.");
                }
                if (runOnDb != null && !runOnDb.startsWith(URL_START_JDBC)) {
                    badArgs("Option -R (--run-on) must specify JDBC connection string.");
                }
                if (insertName == null) {
                    badArgs("Please specify argument \"--insert-name\"");
                }
            }
        }
    }

    private void checkModeParams() throws CmdLineException {
        // argument can be used only with mode
        badArgWithCorrectModes(newSrc != null, "-s (--source)", CliMode.DIFF, CliMode.PARSE, CliMode.GRAPH,
                CliMode.INSERT);
        badArgWithCorrectModes(oldSrc != null, "-t (--target)", CliMode.DIFF);
        badArgWithCorrectModes(addTransaction, "-X (--add-transaction)", CliMode.DIFF, CliMode.INSERT);
        badArgWithCorrectModes(runOnDb != null, "-R (--run-on)", CliMode.DIFF, CliMode.INSERT);
        badArgWithCorrectModes(enableFunctionBodiesDependencies, "-f (--enable-function-bodies-dependencies)",
                CliMode.DIFF, CliMode.PARSE, CliMode.GRAPH);
        badArgWithCorrectModes(simplifyView, "--simplify-views", CliMode.DIFF, CliMode.PARSE);
        badArgWithCorrectModes(timeZone != null, "-Z (--time-zone)", CliMode.DIFF, CliMode.PARSE);
        badArgWithCorrectModes(!allowedTypes.isEmpty(), "-O (--allowed-object)", CliMode.DIFF);
        badArgWithCorrectModes(!ignoreLists.isEmpty(), "-I (--ignore-list)", CliMode.DIFF, CliMode.PARSE);
        badArgWithCorrectModes(selectedOnly, "--selected-only", CliMode.DIFF);
        badArgWithCorrectModes(runOnTarget, "-r (--run-on-target)", CliMode.DIFF);
        badArgWithCorrectModes(disableCheckFunctionBodies, "-F (--no-check-function-bodies)", CliMode.DIFF);
        badArgWithCorrectModes(!preFilePath.isEmpty(), "--pre-script", CliMode.DIFF);
        badArgWithCorrectModes(!postFilePath.isEmpty(), "--post-script", CliMode.DIFF);
        badArgWithCorrectModes(ignoreColumnOrder, "--ignore-column-order", CliMode.DIFF);
        badArgWithCorrectModes(generateConstraintNotValid, "-v (--generate-constraint-not-valid)", CliMode.DIFF);
        badArgWithCorrectModes(usingTypeCastOff, "--using-off", CliMode.DIFF);
        badArgWithCorrectModes(dataMovementMode, "--migrate-data", CliMode.DIFF);
        badArgWithCorrectModes(concurrentlyMode, "-C (--concurrently-mode)", CliMode.DIFF);
        badArgWithCorrectModes(generateExists, "--generate-exist", CliMode.DIFF);
        badArgWithCorrectModes(generateExistDoBlock, "-do (--generate-exist-do-block)", CliMode.DIFF);
        badArgWithCorrectModes(dropBeforeCreate, "--drop-before-create", CliMode.DIFF);
        badArgWithCorrectModes(commentsToEnd, "--comments-to-end", CliMode.DIFF);
        badArgWithCorrectModes(safeMode, "-S (--safe-mode)", CliMode.DIFF);
        badArgWithCorrectModes(!allowedDangers.isEmpty(), "-D (--allow-danger-ddl)", CliMode.DIFF);
        badArgWithCorrectModes(stopNotAllowed, "--stop-not-allowed", CliMode.DIFF);
        badArgWithCorrectModes(!sourceLibXmls.isEmpty(), "--tgt-lib-xml", CliMode.DIFF);
        badArgWithCorrectModes(!sourceLibs.isEmpty(), "--tgt-lib", CliMode.DIFF);
        badArgWithCorrectModes(!sourceLibsWithoutPriv.isEmpty(), "--tgt-lib-no-priv", CliMode.DIFF);
        badArgWithCorrectModes(projUpdate, "--update-project", CliMode.PARSE);
        badArgWithCorrectModes(!graphNames.isEmpty(), "--graph-name", CliMode.GRAPH);
        badArgWithCorrectModes(DEFAULT_DEPTH != graphDepth, "--graph-depth", CliMode.GRAPH);
        badArgWithCorrectModes(!graphFilterTypes.isEmpty(), "--graph-filter-object", CliMode.GRAPH);
        badArgWithCorrectModes(insertName != null, "--insert-name", CliMode.INSERT);
        badArgWithCorrectModes(!verifySources.isEmpty(), "--verify-source", CliMode.VERIFY);
        badArgWithCorrectModes(verifyRuleSetPath != null, "--verify-rule-set", CliMode.VERIFY);
    }

    private void checkDbTypesParam() throws CmdLineException {
        badArgWithWrongDbType(simplifyView, "--simplify-views", DatabaseType.MS, DatabaseType.CH);
        badArgWithWrongDbType(timeZone != null, "-Z (--time-zone)", DatabaseType.MS, DatabaseType.CH);
        badArgWithWrongDbType(generateExistDoBlock, "-do (--generate-exist-do-block)", DatabaseType.MS,
                DatabaseType.CH);
        badArgWithWrongDbType(concurrentlyMode, "-C (--concurrently-mode)", DatabaseType.CH);
        badArgWithWrongDbType(commentsToEnd, "--comments-to-end", DatabaseType.CH);
        badArgWithWrongDbType(CliMode.INSERT == mode, "--mode INSERT", DatabaseType.CH);
        badArgWithWrongDbType(CliMode.VERIFY == mode, "--mode VERIFY", DatabaseType.CH, DatabaseType.MS);
    }

    private void badArgWithCorrectModes(boolean condition, String param, CliMode... modes) throws CmdLineException {
        if (condition && !containsInArray(mode, modes)) {
            badArgs(MessageFormat.format(MESSAGE_WRONG_MODE, param, mode));
        }
    }

    private void badArgWithWrongDbType(boolean condition, String arg, DatabaseType... wrongDbTypes)
            throws CmdLineException {
        if (condition && containsInArray(dbType, wrongDbTypes)) {
            badArgs(MessageFormat.format("option \"{0}\" cannot be used with dbType: {1}", arg, dbType));
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

    private String parsePath(String source) {
        if (source.startsWith(URL_START_JDBC)) {
            return "db";
        }
        if (Files.isDirectory(Paths.get(source))) {
            return "parsed";
        }
        return "dump";
    }

    private void printUsage(PrintWriter writer) {
        // fix defaults for options like help and other 0-arg booleans
        OptionHandlerRegistry.getRegistry().registerHandler(Boolean.class, BooleanNoDefOptionHandler.class);
        OptionHandlerRegistry.getRegistry().registerHandler(boolean.class, BooleanNoDefOptionHandler.class);

        ParserProperties prop = ParserProperties.defaults().withUsageWidth(80).withOptionSorter(null);

        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        // new args instance to get correct defaults
        new CmdLineParser(new CliArgs(), prop).printUsage(new OutputStreamWriter(buf, StandardCharsets.UTF_8), null);

        writer.println(MessageFormat.format(Messages.UsageHelp.replace("${tab}", "\t"),
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