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

    // SONAR-OFF
    {
        // this was moved to initializer to avoid the IDE making the field "final" on-save
        // otherwise args4j breaks
        this.allowedDangers = new ArrayList<>();
        this.allowedTypes = new ArrayList<>();
        this.ignoreLists = new ArrayList<>();
        this.inCharsetName = ApgdiffConsts.UTF_8;
        this.outCharsetName = ApgdiffConsts.UTF_8;
    }
    // SONAR-ON

    // "special" options start with "z"

    @Option(name="--help", help=true, usage="show this help")
    private boolean zhelp;

    @Option(name="--version", help=true, usage="show version")
    private boolean zversion;

    @Option(name="--list-charsets", help=true, usage="show list of Java-supported charsets")
    private boolean zlistCharsets;

    @Option(name="--parse", depends="-o",
            usage="run in parser mode to save database schema as a directory hierarchy")
    private boolean modeParse;

    @Option(name="-l", aliases="--license", hidden=true)
    @Deprecated
    private String licensePath;

    @Option(name="-s", depends="-t", aliases="--source", metaVar="<path or JDBC>",
            usage="source of schema changes")
    @Argument(index=0, metaVar="SOURCE", usage="source of schema changes")
    private String newSrc;

    @Option(name="-t", depends="-s", aliases="--target", metaVar="<path or JDBC>",
            forbids="--parse", usage="destination for schema changes (diff mode only)")
    @Argument(index=1, metaVar="DEST", usage="destination for schema changes (diff mode only)")
    private String oldSrc;

    @Option(name="-o", aliases="--output", metaVar="<path>",
            usage="script output file or parser output directory")
    private String outputTarget;

    @Option(name="--in-charset", metaVar="<charset>", usage="input charset")
    private String inCharsetName;

    @Option(name="--out-charset", metaVar="<charset>", usage="output charset")
    private String outCharsetName;

    @Option(name="-P", aliases="--no-privileges",
            usage="ignore privileges and owners of database objects")
    private boolean ignorePrivileges;

    @Option(name="-L", aliases="--keep-newlines",
            usage="keep newline characters as is (don't convert to Unix newlines)")
    private boolean keepNewlines;

    @Option(name="-X", aliases="--add-transaction", forbids="--parse",
            usage="wrap generated script with transaction statements")
    private boolean addTransaction;

    @Option(name="-F", aliases="--no-check-function-bodies", forbids="--parse",
            usage="set check_function_bodies to false at the beginning of the script")
    private boolean disableCheckFunctionBodies;

    @Option(name="-Z", aliases="--time-zone", metaVar="<timezone>", forbids="--parse",
            usage="add SET TIMEZONE statement to the script")
    private String timeZone;

    @Option(name="--using-off", forbids="--parse",
            usage="do not print USING expression for ALTER COLUMN TYPE")
    private boolean usingTypeCastOff;

    @Option(name="-C", aliases="--concurrently-mode", forbids="--parse",
            usage="print CREATE INDEX with CONCURRENTLY option")
    private boolean concurrentlyMode;

    @Option(name="-S", aliases="--safe-mode", forbids="--parse",
            usage="do not generate scripts containing dangerous statements\nsee: --allow-danger-ddl")
    private boolean safeMode;

    @Option(name="-D", aliases="--allow-danger-ddl", forbids="--parse",
            handler=DangerStatementOptionHandler.class,
            usage="allows dangerous statements in safe-mode scripts")
    private List<DangerStatement> allowedDangers;

    @Option(name="-O", aliases="--allowed-object", forbids="--parse",
            handler=DbObjTypeOptionHandler.class,
            usage="build the script using these object types only"
                    + "\nhide statements of other objects")
    private List<DbObjType> allowedTypes;

    @Option(name="--stop-not-allowed", forbids="--parse",
            usage="exit with an error when --allowed-object hides a statement from the script")
    private boolean stopNotAllowed;

    @Option(name="-I", aliases="--ignore-list", metaVar="<path>", forbids="--parse",
            usage="use an ignore list to include/exclude objects from diff"
                    + "\nspecify multiple times to use several lists")
    private List<String> ignoreLists;

    @Override
    public boolean isModeParse() {
        return modeParse;
    }

    @Override
    public String getNewSrc() {
        return newSrc;
    }

    @Override
    public String getOldSrc() {
        return this.oldSrc;
    }

    @Override
    public String getOutputTarget() {
        return this.outputTarget;
    }

    @Override
    public boolean isAddTransaction() {
        return addTransaction;
    }

    @Override
    public boolean isStopNotAllowed() {
        return stopNotAllowed;
    }

    @Override
    public boolean isSafeMode() {
        return safeMode;
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
    public String getInCharsetName() {
        return inCharsetName;
    }

    @Override
    public String getOutCharsetName() {
        return outCharsetName;
    }

    @Override
    public boolean isDisableCheckFunctionBodies() {
        return disableCheckFunctionBodies;
    }

    @Override
    public String getTimeZone() {
        return timeZone;
    }

    @Override
    public boolean isIgnorePrivileges() {
        return ignorePrivileges;
    }

    @Override
    public boolean isKeepNewlines() {
        return keepNewlines;
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
    public boolean isConcurrentlyMode() {
        return concurrentlyMode;
    }

    @SuppressWarnings("deprecation")
    private static void badArgs(String message) throws CmdLineException{
        throw new CmdLineException(message);
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

        if (licensePath != null) {
            // TODO move to Log when it will properly use syserr
            System.err.println("-- [WARNING] -l or --license parameters are deprecated!");
            System.err.println("-- pgCodeKeeper no longer requires license files");
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

        if (isModeParse()) {
            if (getNewSrc() == null) {
                badArgs("Please specify SCHEMA to parse.");
            }
            if (getOldSrc() != null) {
                badArgs("Parser mode doesn't require DEST argument.");
            }
        } else {
            if (getOldSrc() == null || getNewSrc() == null) {
                badArgs("Please specify both SOURCE and DEST.");
            }
            if (isAddTransaction() && isConcurrentlyMode()) {
                badArgs("-C (--concurrently-mode) cannot be used with the option(s) -X (--add-transaction)");
            }
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
