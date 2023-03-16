/*******************************************************************************
 * Copyright 2017-2023 TAXTELECOM, LLC
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
import ru.taximaxim.codekeeper.core.PgDiffArguments;
import ru.taximaxim.codekeeper.core.model.difftree.DbObjType;

/**
 * Extension of {@link PgDiffArguments} with annotated CLI fields.
 * Override getters so that clients will access either CLI or parent fields
 * depending on the instance.
 */
public class CliArgs extends PgDiffArguments {

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
        this.graphNames = new ArrayList<>();
        this.inCharsetName = Consts.UTF_8;
        this.outCharsetName = Consts.UTF_8;
        this.graphDepth = DEFAULT_DEPTH;
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

    @Option(name="--parse", depends="-o",
            usage="run in parser mode to save database schema as a directory hierarchy")
    private boolean modeParse;

    @Option(name="--graph",
            usage="run in graph mode to show objects dependencies")
    private boolean modeGraph;

    @Option(name="-s", depends="-t", aliases="--source", metaVar="<path or JDBC>",
            usage="source of schema changes")
    @Argument(index=0, metaVar="SOURCE", usage="source of schema changes")
    private String newSrc;

    @Option(name="-t", depends="-s", aliases="--target", metaVar="<path or JDBC>",
            forbids={"--graph", "--parse"}, usage="destination for schema changes (diff mode only)")
    @Argument(index=1, metaVar="DEST", usage="destination for schema changes (diff mode only)")
    private String oldSrc;

    @Option(name="-o", aliases="--output", metaVar="<path>",
            usage="script output file or parser output directory")
    private String outputTarget;

    @Option(name="-r", aliases="--run-on-target", forbids={"--parse, --graph", "-R"},
            usage="run generated script on the target database")
    private boolean runOnTarget;

    @Option(name="-R", aliases="--run-on", metaVar="<JDBC>", forbids={"--parse", "--graph", "-r"},
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

    @Option(name="--simplify-views", forbids="--ms-sql",
            usage="simple formatting for VIEWs when reading via JDBC (not recomended by PostgreSQL)")
    private boolean simplifyView;

    @Option(name="-X", aliases="--add-transaction", forbids={"--graph", "--parse"},
            usage="wrap generated script with transaction statements")
    private boolean addTransaction;

    @Option(name="-F", aliases="--no-check-function-bodies", forbids={"--graph", "--parse"},
            usage="set check_function_bodies to false at the beginning of the script")
    private boolean disableCheckFunctionBodies;

    @Option(name="--enable-function-bodies-dependencies", forbids={"--parse"},
            usage="enable dependencies from bodies of functions and procedures to other functions or procedures")
    private boolean enableFunctionBodiesDependencies;

    @Option(name="-Z", aliases="--time-zone", metaVar="<timezone>",forbids={"--graph", "--ms-sql"},
            usage="use this timezone when working with database, also add SET TIMEZONE statement to the script")
    private String timeZone;

    @Option(name="--pre-script", metaVar="<path>", forbids={"--parse", "--graph"},
            usage="PRE script file path or directory with PRE scripts"
                    + "\nnested directories are loaded recursively"
                    + "\nspecify multiple times to use several paths")
    private List<String> preFilePath = new ArrayList<>();

    @Option(name="--post-script", metaVar="<path>", forbids={"--parse", "--graph"},
            usage="POST script file path or directory with POST scripts"
                    + "\nnested directories are loaded recursively"
                    + "\nspecify multiple times to use several paths")
    private List<String> postFilePath = new ArrayList<>();

    @Option(name="--ignore-column-order",
            usage="ignore differences in table column order")
    private boolean ignoreColumnOrder;

    @Option(name="--generate-constraint-not-valid",
            usage="print CONSTRAINT NOT VALID for no partitioned tables")
    private boolean generateConstraintNotValid;

    @Option(name="--using-off", forbids={"--graph", "--parse"},
            usage="do not print USING expression for ALTER COLUMN TYPE")
    private boolean usingTypeCastOff;

    @Option(name="--migrate-data", forbids={"--graph", "--parse"},
            usage="migrate data when re-creating tables")
    private boolean dataMovementMode;

    @Option(name="-C", aliases="--concurrently-mode", forbids={"--graph", "--parse"},
            usage="print CREATE INDEX with CONCURRENTLY option for PostgreSQL and WITH ONLINE = ON for MS SQL")
    private boolean concurrentlyMode;

    @Option(name="--generate-exist", forbids={"--graph", "--parse"},
            usage="print CREATE IF NOT EXISTS / DROP IF EXISTS")
    private boolean generateExists;

    @Option(name="--drop-before-create", forbids={"--graph", "--parse"},
            usage="print DROP before CREATE statement")
    private boolean dropBeforeCreate;

    @Option(name="-S", aliases="--safe-mode", forbids={"--graph", "--parse"},
            usage="do not generate scripts containing dangerous statements\nsee: --allow-danger-ddl")
    private boolean safeMode;

    @Option(name="-D", aliases="--allow-danger-ddl", forbids={"--graph", "--parse"},
            handler=DangerStatementOptionHandler.class,
            usage="allows dangerous statements in safe-mode scripts")
    private List<DangerStatement> allowedDangers;

    @Option(name="-O", aliases="--allowed-object", forbids={"--graph"},
            handler=DbObjTypeOptionHandler.class,
            usage="build the script using these object types only, hide statements of other objects")
    private List<DbObjType> allowedTypes;

    @Option(name="--stop-not-allowed", forbids={"--graph", "--parse"},
            usage="exit with an error when --allowed-object hides a dependency statement from the script")
    private boolean stopNotAllowed;

    @Option(name="--selected-only", forbids={"--graph"},
            usage="build the script using 'selected' objects only, hide statements of other objects"
                    + "\nin CLI, selected means included by --allowed-object and ignore lists")
    private boolean selectedOnly;

    @Option(name="-I", aliases="--ignore-list", metaVar="<path>", forbids={"--graph"},
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

    @Option(name="--ignore-concurrent-modification",
            usage="ignore concurrent modification errors of database objects")
    private boolean ignoreConcurrentModification;

    @Option(name="--ms-sql",
            usage="work with MS SQL")
    private boolean msSql;

    @Option(name="--update-project", depends={"--parse"}, forbids={"--graph"},
            usage="update an existing project in parse mode")
    private boolean projUpdate;

    @Option(name="--graph-depth", metaVar="<n>", forbids={"--parse"}, depends={"--graph"},
            usage="depth of displayed dependencies in graph mode")
    private int graphDepth;

    @Option(name="--graph-reverse",  depends={"--graph-name", "--graph"}, forbids={"--parse"},
            usage="reverse the direction of the graph to show objects on which the starting object depends")
    private boolean graphReverse;

    @Option(name="--graph-name", metaVar="<name>", forbids={"--parse"}, depends={"--graph"},
            usage="name of start object in graph mode"
                    + "\nspecify multiple times to use several names")
    private List<String> graphNames;

    @Option(name="--graph-filter-object", forbids={"--parse"}, depends={"--graph"},
            handler=DbObjTypeOptionHandler.class,
            usage="show these object types, hide  other objects types")
    private List<DbObjType> graphFilterTypes;

    @Option(name="--graph-invert-filter", forbids={"--parse"}, depends={"--graph", "--graph-filter-object"},
            usage="invert graph filter object types: hide objects specified by the filter")
    private boolean graphInvertFilter;

    public boolean isClearLibCache() {
        return clearLibCache;
    }

    public void setClearLibCache(boolean clearLibCache) {
        this.clearLibCache = clearLibCache;
    }

    public boolean isModeParse() {
        return modeParse;
    }

    public void setModeParse(boolean modeParse) {
        this.modeParse = modeParse;
    }

    public boolean isModeGraph() {
        return modeGraph;
    }

    public void setModeGraph(boolean modeGraph) {
        this.modeGraph = modeGraph;
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
        return this.oldSrc;
    }

    @Override
    public void setOldSrc(String oldSrc) {
        this.oldSrc = oldSrc;
    }

    public String getOutputTarget() {
        return this.outputTarget;
    }

    public void setOutputTarget(String outputTarget) {
        this.outputTarget = outputTarget;
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

    public void setSafeMode(boolean safeMode) {
        this.safeMode = safeMode;
    }

    public boolean isRunOnTarget() {
        return runOnTarget;
    }

    public void setRunOnTarget(boolean runOnTarget) {
        this.runOnTarget = runOnTarget;
    }

    public String getRunOnDb() {
        return runOnDb;
    }

    public void setRunOnDb(String runOnDb) {
        this.runOnDb = runOnDb;
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
    public boolean isMsSql() {
        return msSql;
    }

    @Override
    public void setMsSql(boolean msSql) {
        this.msSql = msSql;
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

    public void setDebug(boolean isDebug) {
        this.isDebug = isDebug;
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

    public void setOutCharsetName(String outCharsetName) {
        this.outCharsetName = outCharsetName;
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
    public boolean isDropBeforeCreate() {
        return dropBeforeCreate;
    }

    @Override
    public void setDropBeforeCreate(boolean dropBeforeCreate) {
        this.dropBeforeCreate = dropBeforeCreate;
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

    public void setGraphReverse(boolean graphReverse) {
        this.graphReverse = graphReverse;
    }

    public void setGraphDepth(int graphDepth) {
        this.graphDepth = graphDepth;
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

    private static void badArgs(String message) throws CmdLineException{
        throw new CmdLineException(null, message, null);
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
            CmdLineParser p = new CmdLineParser(this);
            p.parseArgument(args);
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

        String msJdbcStart = "jdbc:sqlserver:";
        String pgJdbcStart = "jdbc:postgresql:";

        if (isModeParse() && isProjUpdate()) {
            setOldSrc(getOutputTarget());
            setOldSrcFormat(parsePath(getOldSrc()));
        }

        if (isModeParse() || isModeGraph()) {
            if (getNewSrc() == null) {
                badArgs("Please specify SCHEMA.");
            }
            if (getOldSrc() != null && !isProjUpdate()) {
                badArgs("DEST argument isn't required.");
            }
            if (isMsSql() && getNewSrc().startsWith(pgJdbcStart)) {
                badArgs("Cannot work with PostgerSQL database as MS SQL project.");
            }
            if (!isMsSql() && getNewSrc().startsWith(msJdbcStart)) {
                badArgs("Cannot work with MS SQL database as PostgerSQL project.");
            }
        } else {
            if ((getOldSrc() == null || getNewSrc() == null)) {
                if (clearLibCache) {
                    return true;
                }
                badArgs("Please specify both SOURCE and DEST.");
            }
            if (isAddTransaction() && isConcurrentlyMode() && !isMsSql()) {
                badArgs("-C (--concurrently-mode) cannot be used with the option(s) -X (--add-transaction) for PostgreSQL.");
            }
            if (getOldSrc().startsWith(msJdbcStart) && getNewSrc().startsWith(pgJdbcStart)
                    || getOldSrc().startsWith(pgJdbcStart) && getNewSrc().startsWith(msJdbcStart)) {
                badArgs("Cannot compare MS SQL and PostgerSQL databases.");
            }
            if ((getOldSrc().startsWith(msJdbcStart) || getNewSrc().startsWith(msJdbcStart)) && !isMsSql()) {
                badArgs("Cannot work with MS SQL database without --ms-sql parameter.");
            }
            if ((getOldSrc().startsWith(pgJdbcStart) || getNewSrc().startsWith(pgJdbcStart)) && isMsSql()) {
                badArgs("Cannot work with PostgreSQL database with --ms-sql parameter.");
            }
            if (isRunOnTarget() && !getOldSrc().startsWith("jdbc:")) {
                badArgs("Cannot run script on non-database target.");
            }
            if (getRunOnDb() != null && !getRunOnDb().startsWith("jdbc:")) {
                badArgs("Option -R (--run-on) must specify JDBC connection string.");
            }
            // TODO Do we need to check DB types for dump and directories?

            setOldSrcFormat(parsePath(getOldSrc()));
        }
        setNewSrcFormat(parsePath(getNewSrc()));

        return true;
    }

    private String parsePath(String source) {
        if (source.startsWith("jdbc:")) {
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

        ParserProperties prop = ParserProperties.defaults()
                .withUsageWidth(80)
                .withOptionSorter(null);

        ByteArrayOutputStream buf = new ByteArrayOutputStream();

        // new args instance to get correct defaults
        new CmdLineParser(new CliArgs(), prop)
        .printUsage(new OutputStreamWriter(buf, StandardCharsets.UTF_8), null);

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
}
