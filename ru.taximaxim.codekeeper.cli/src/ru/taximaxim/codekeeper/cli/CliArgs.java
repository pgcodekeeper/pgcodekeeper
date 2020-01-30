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
import org.osgi.framework.BundleContext;

import cz.startnet.utils.pgdiff.DangerStatement;
import cz.startnet.utils.pgdiff.PgDiffArguments;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;
import ru.taximaxim.codekeeper.cli.localizations.Messages;
import ru.taximaxim.codekeeper.cli.opthandlers.BooleanNoDefOptionHandler;
import ru.taximaxim.codekeeper.cli.opthandlers.DangerStatementOptionHandler;
import ru.taximaxim.codekeeper.cli.opthandlers.DbObjTypeOptionHandler;

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
        this.ignoreLists = new ArrayList<>();
        this.sourceLibXmls = new ArrayList<>();
        this.sourceLibs = new ArrayList<>();
        this.sourceLibsWithoutPriv = new ArrayList<>();
        this.targetLibXmls = new ArrayList<>();
        this.targetLibs = new ArrayList<>();
        this.targetLibsWithoutPriv = new ArrayList<>();
        this.graphNames = new ArrayList<>();
        this.inCharsetName = ApgdiffConsts.UTF_8;
        this.outCharsetName = ApgdiffConsts.UTF_8;
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

    @Option(name="-X", aliases="--add-transaction", forbids={"--graph", "--parse"},
            usage="wrap generated script with transaction statements")
    private boolean addTransaction;

    @Option(name="-F", aliases="--no-check-function-bodies", forbids={"--graph", "--parse"},
            usage="set check_function_bodies to false at the beginning of the script")
    private boolean disableCheckFunctionBodies;

    @Option(name="--enable-function-bodies-dependencies", forbids={"--parse"},
            usage="enable dependencies from bodies of functions and procedures to other functions or procedures")
    private boolean enableFunctionBodiesDependencies;

    @Option(name="-Z", aliases="--time-zone", metaVar="<timezone>",forbids={"--graph", "--parse", "--ms-sql"},
            usage="use this timezone when working with database, also add SET TIMEZONE statement to the script")
    private String timeZone;

    @Option(name="--using-off", forbids={"--graph", "--parse"},
            usage="do not print USING expression for ALTER COLUMN TYPE")
    private boolean usingTypeCastOff;

    @Option(name="-C", aliases="--concurrently-mode", forbids={"--graph", "--parse"},
            usage="print CREATE INDEX with CONCURRENTLY option for PostgreSQL and WITH ONLINE = ON for MS SQL")
    private boolean concurrentlyMode;

    @Option(name="-S", aliases="--safe-mode", forbids={"--graph", "--parse"},
            usage="do not generate scripts containing dangerous statements\nsee: --allow-danger-ddl")
    private boolean safeMode;

    @Option(name="-D", aliases="--allow-danger-ddl", forbids={"--graph", "--parse"},
            handler=DangerStatementOptionHandler.class,
            usage="allows dangerous statements in safe-mode scripts")
    private List<DangerStatement> allowedDangers;

    @Option(name="-O", aliases="--allowed-object", forbids={"--graph", "--parse"},
            handler=DbObjTypeOptionHandler.class,
            usage="build the script using these object types only"
                    + "\nhide statements of other objects")
    private List<DbObjType> allowedTypes;

    @Option(name="--stop-not-allowed", forbids={"--graph", "--parse"},
            usage="exit with an error when --allowed-object hides a dependency statement from the script")
    private boolean stopNotAllowed;

    @Option(name="-I", aliases="--ignore-list", metaVar="<path>", forbids={"--graph", "--parse"},
            usage="use an ignore list to include/exclude objects from diff"
                    + "\nspecify multiple times to use several lists")
    private List<String> ignoreLists;

    @Option(name="--src-lib-xml", metaVar="<path>", forbids={"--parse"},
            usage="add xml with library dependencies to source"
                    + "\nspecify multiple times to use several library xml's")
    private List<String> targetLibXmls;

    @Option(name="--src-lib", metaVar="<path or JDBC>", forbids={"--parse"},
            usage="add library dependency to source"
                    + "\nspecify multiple times to use several libraries")
    private List<String> targetLibs;

    @Option(name="--src-lib-no-priv", metaVar="<path or JDBC>", forbids={"--parse"},
            usage="add library dependency to source without privileges"
                    + "\nspecify multiple times to use several libraries")
    private List<String> targetLibsWithoutPriv;

    @Option(name="--tgt-lib-xml", metaVar="<path>", forbids={"--parse"},
            usage="add xml with library dependencies to target"
                    + "\nspecify multiple times to use several library xml's")
    private List<String> sourceLibXmls;

    @Option(name="--tgt-lib", metaVar="<path or JDBC>", forbids={"--parse"},
            usage="add library dependency to destination"
                    + "\nspecify multiple times to use several libraries")
    private List<String> sourceLibs;

    @Option(name="--tgt-lib-no-priv", metaVar="<path or JDBC>", forbids={"--parse"},
            usage="add library dependency to destination without privileges"
                    + "\nspecify multiple times to use several libraries")
    private List<String> sourceLibsWithoutPriv;

    @Option(name="--lib-safe-mode", forbids={"--parse"},
            usage="exit with an error if a library object conflicts with other schema or library objects"
                    + " otherwise, in case of conflicts objects loaded first have priority")
    private boolean libSafeMode;

    @Option(name="--ignore-concurrent-modification",
            usage="ignore concurrent modification errors of database objects")
    private boolean ignoreConcurrentModification;

    @Option(name="--ms-sql",
            usage="work with MS SQL")
    private boolean msSql;

    @Option(name="--graph-depth", metaVar="<n>", forbids={"--parse"},
            usage="depth of displayed dependencies in graph mode")
    private int graphDepth;

    @Option(name="--graph-reverse",  depends="--graph-name", forbids={"--parse"},
            usage="reverse the direction of the graph to show objects on which the starting object depends")
    private boolean graphReverse;

    @Option(name="--graph-name", metaVar="<name>", forbids={"--parse"},
            usage="name of start object in graph mode"
                    + "\nspecify multiple times to use several names")
    private List<String> graphNames;

    @Option(name="--simplify-views", forbids="--ms-sql",
            usage="simple formatting for VIEWs when reading via JDBC (not recomended by PostgreSQL)")
    private boolean simplifyView;

    @Override
    public boolean isModeParse() {
        return modeParse;
    }

    @Override
    public void setModeParse(boolean modeParse) {
        this.modeParse = modeParse;
    }

    @Override
    public boolean isModeGraph() {
        return modeGraph;
    }

    @Override
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

    @Override
    public String getOutputTarget() {
        return this.outputTarget;
    }

    @Override
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

    @Override
    public boolean isSafeMode() {
        return safeMode;
    }

    @Override
    public void setSafeMode(boolean safeMode) {
        this.safeMode = safeMode;
    }

    @Override
    public boolean isRunOnTarget() {
        return runOnTarget;
    }

    @Override
    public void setRunOnTarget(boolean runOnTarget) {
        this.runOnTarget = runOnTarget;
    }

    @Override
    public String getRunOnDb() {
        return runOnDb;
    }

    @Override
    public void setRunOnDb(String runOnDb) {
        this.runOnDb = runOnDb;
    }

    @Override
    public Collection<DangerStatement> getAllowedDangers() {
        return Collections.unmodifiableCollection(allowedDangers);
    }

    @Override
    public Collection<String> getIgnoreLists() {
        return Collections.unmodifiableCollection(ignoreLists);
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
    public String getInCharsetName() {
        return inCharsetName;
    }

    @Override
    public void setInCharsetName(String inCharsetName) {
        this.inCharsetName = inCharsetName;
    }

    @Override
    public String getOutCharsetName() {
        return outCharsetName;
    }

    @Override
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

    @Override
    public int getGraphDepth() {
        return graphDepth;
    }

    @Override
    public boolean isGraphReverse() {
        return graphReverse;
    }

    @Override
    public void setGraphReverse(boolean graphReverse) {
        this.graphReverse = graphReverse;
    }

    @Override
    public void setGraphDepth(int graphDepth) {
        this.graphDepth = graphDepth;
    }

    @Override
    public Collection<String> getGraphNames() {
        return Collections.unmodifiableCollection(graphNames);
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

        if (isModeParse() || isModeGraph()) {
            if (getNewSrc() == null) {
                badArgs("Please specify SCHEMA.");
            }
            if (getOldSrc() != null) {
                badArgs("DEST argument doesn't require.");
            }
            if (isMsSql() && getNewSrc().startsWith(pgJdbcStart)) {
                badArgs("Cannot work with PostgerSQL database as MS SQL project.");
            }
            if (!isMsSql() && getNewSrc().startsWith(msJdbcStart)) {
                badArgs("Cannot work with MS SQL database as PostgerSQL project.");
            }
        } else {
            if (isRunOnTarget() && !getOldSrc().startsWith("jdbc:")) {
                badArgs("Cannot run script on non-database target");
            }
            if (getRunOnDb() != null && !getRunOnDb().startsWith("jdbc:")) {
                badArgs("option -R (--run-on) must specify JDBC connection string");
            }
            if (getGraphDepth() != DEFAULT_DEPTH) {
                badArgs("option --graph-depth cannot be used without the option(s) [--graph]");
            }
            if (!getGraphNames().isEmpty()) {
                badArgs("option --graph-name cannot be used without the option(s) [--graph]");
            }
            if (isGraphReverse()) {
                badArgs("option --graph-reverse cannot be used without the option(s) [--graph]");
            }
            if (getOldSrc() == null || getNewSrc() == null) {
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
        BundleContext ctx = Activator.getContext();
        writer.println(MessageFormat.format(Messages.Version,
                ctx == null ? "error: no OSGI running" : ctx.getBundle().getVersion())); //$NON-NLS-1$
    }

    private void listCharsets(PrintWriter writer) {
        Charset.availableCharsets().keySet().forEach(writer::println);
    }
}
