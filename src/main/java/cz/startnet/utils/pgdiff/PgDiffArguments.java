/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.SortedMap;
import java.util.regex.Pattern;

import org.osgi.framework.BundleContext;

import ru.taximaxim.codekeeper.apgdiff.Activator;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import cz.startnet.utils.pgdiff.PgDiffStatement.DangerStatement;

/**
 * Contains parsed command line arguments.
 *
 * @author fordfrog
 */
public class PgDiffArguments {
// SONAR-OFF
    private static final String DEFAULT_FORMAT = "dump";
// SONAR-ON
    
    /**
     * Is program in diff mode.
     */
    private boolean modeDiff;
    /**
     * Is program in parser mode.
     */
    private boolean modeParse;
    /**
     * Path to the new dump file.
     */
    private String newSrc;
    /**
     * Path to the original dump file.
     */
    private String oldSrc;
    /**
     * New DB source format.
     */
    private String newSrcFormat = DEFAULT_FORMAT;
    /**
     * Old DB source format.
     */
    private String oldSrcFormat = DEFAULT_FORMAT;
    /**
     * File to write the diff into.
     */
    private  String diffOutfile;
    /**
     * Path to the DB to parse.
     */
    private String parseSrc;
    /**
     * Format of the DB to parse.
     */
    private String parseSrcFormat = DEFAULT_FORMAT;
    /**
     * Directory to parse into.
     */
    private String parserOutdir;
    /**
     * Input file charset name.
     */
    private String inCharsetName = ApgdiffConsts.UTF_8;
    /**
     * Output file charset name.
     */
    private String outCharsetName = ApgdiffConsts.UTF_8;
    /**
     * Whether to enclose all statements in transaction.
     */
    private boolean addTransaction;
    /**
     * Whether to ignore DROP TABLE on script.
     */
    private boolean ignoreDropTable;
    /**
     * Whether to ignore DROP COLUMN on script.
     */
    private boolean ignoreDropColumn;
    /**
     * Whether to ignore ALTER COLUMN on script.
     */
    private boolean ignoreAlterColumn;
    /**
     * Whether to display apgdiff version.
     */
    private boolean version;
    /**
     * Whether to display apgdiff help.
     */
    private boolean help;

    /**
     * Whether to output information about ignored statements.
     */
    private boolean outputIgnoredStatements;
    /**
     * Whether to list supported charsets.
     */
    private boolean listCharsets;
    /**
     * Whether Slony triggers should be ignored.
     */
    private boolean ignoreSlonyTriggers;
    /**
     * Whether ignore function bodies.
     * TODO придумать проверить из командной строки параметр 
     */
    private boolean checkFunctionBodies = true;
    /**
     * timeZone for script operations
     */
    private String timeZone;

    /**
     * Setter for {@link #modeDiff}
     * 
     * @param modeDiff {@link #modeDiff}
     */
    public void setModeDiff(final boolean modeDiff) {
        this.modeDiff = modeDiff;
    }
    
    /**
     * Getter for {@link #modeDiff}
     * 
     * @return {@link #modeDiff}
     */
    public boolean isModeDiff() {
        return modeDiff;
    }
    
    /**
     * Setter for {@link #modeParse}
     * 
     * @param modeParse {@link #modeParse}
     */
    public void setModeParse(final boolean modeParse) {
        this.modeParse = modeParse;
    }
    
    /**
     * Getter for {@link #modeParse}
     * 
     * @return {@link #modeParse}
     */
    public boolean isModeParse() {
        return modeParse;
    }
    
    /**
     * Setter for {@link #newSrc}
     * 
     * @param newSrc {@link #newSrc}
     */
    public void setNewSrc(final String newSrc) {
        this.newSrc = newSrc;
    }
    
    /**
     * Getter for {@link #newSrc}
     * 
     * @return {@link #newSrc}
     */
    public String getNewSrc() {
        return newSrc;
    }
    
    /**
     * Setter for {@link #oldSrc}
     * 
     * @param oldSrc {@link #oldSrc}
     */
    public void setOldSrc(final String oldSrc) {
        this.oldSrc = oldSrc;
    }
    
    /**
     * Getter for {@link #oldSrc}
     * 
     * @return {@link #oldSrc}
     */
    public String getOldSrc() {
        return this.oldSrc;
    }
    
    /**
     * Setter for {@link #newSrcFormat}
     * 
     * @param newSrcFormat {@link #newSrcFormat}
     */
    public void setNewSrcFormat(final String newSrcFormat) {
        this.newSrcFormat = newSrcFormat;
    }
    
    /**
     * Getter for {@link #oldSrc}
     * 
     * @return {@link #oldSrc}
     */
    public String getNewSrcFormat() {
        return this.newSrcFormat;
    }
    
    /**
     * Setter for {@link #oldSrcFormat}
     * 
     * @param oldSrcFormat {@link #oldSrcFormat}
     */
    public void setOldSrcFormat(final String oldSrcFormat) {
        this.oldSrcFormat = oldSrcFormat;
    }
    
    /**
     * Getter for {@link #oldSrcFormat}
     * 
     * @return {@link #oldSrcFormat}
     */
    public String getOldSrcFormat() {
        return this.oldSrcFormat;
    }
    
    /**
     * Setter for {@link #diffOutfile}
     * 
     * @param diffOutfile {@link #diffOutfile}
     */
    public void setDiffOutfile(final String diffOutfile) {
        this.diffOutfile = diffOutfile;
    }
    
    /**
     * Getter for {@link #diffOutfile}
     * 
     * @return {@link #diffOutfile}
     */
    public String getDiffOutfile() {
        return this.diffOutfile;
    }
    
    /**
     * Setter for {@link #parseSrc}
     * 
     * @param parseSrc {@link #parseSrc}
     */
    public void setParseSrc(final String parseSrc) {
        this.parseSrc = parseSrc;
    }
    
    /**
     * Getter for {@link #parseSrc}
     * 
     * @return {@link #parseSrc}
     */
    public String getParseSrc() {
        return this.parseSrc;
    }
    
    /**
     * Setter for {@link #parseSrcFormat}
     * 
     * @param parseSrcFormat {@link #parseSrcFormat}
     */
    public void setParseSrcFormat(final String parseSrcFormat) {
        this.parseSrcFormat = parseSrcFormat;
    }
    
    /**
     * Getter for {@link #parseSrcFormat}
     * 
     * @return {@link #parseSrcFormat}
     */
    public String getParseSrcFormat() {
        return this.parseSrcFormat;
    }
    
    /**
     * Setter for {@link #parserOutdir}
     * 
     * @param parserOutdir {@link #parserOutdir}
     */
    public void setParserOutdir(final String parserOutdir) {
        this.parserOutdir = parserOutdir;
    }
    
    /**
     * Getter for {@link #parserOutdir}
     * 
     * @return {@link #parserOutdir}
     */
    public String getParserOutdir() {
        return this.parserOutdir;
    }

    /**
     * Setter for {@link #addTransaction}.
     *
     * @param addTransaction {@link #addTransaction}
     */
    public void setAddTransaction(final boolean addTransaction) {
        this.addTransaction = addTransaction;
    }

    /**
     * Getter for {@link #addTransaction}.
     *
     * @return {@link #addTransaction}
     */
    public boolean isAddTransaction() {
        return addTransaction;
    }

    /**
     * Setter for {@link #ignoreDropTable}.
     * @param ignoreDropTable {@link #ignoreDropTable}.
     */
    public void setIgnoreDropTable(boolean ignoreDropTable) {
        this.ignoreDropTable = ignoreDropTable;
    }
    /**
     * Getter for {@link #ignoreDropTable}.
     * @return {@link #ignoreDropTable}.
     */
    public boolean isIgnoreDropTable() {
        return ignoreDropTable;
    }

    /**
     * Setter for {@link #ignoreDropColumn}.
     * @param ignoreDropTable {@link #ignoreDropColumn}.
     */
    public void setIgnoreDropColumn(boolean ignoreDropColumn) {
        this.ignoreDropColumn = ignoreDropColumn;
    }
    /**
     * Getter for {@link #ignoreDropColumn}.
     * @return {@link #ignoreDropColumn}.
     */
    public boolean isIgnoreDropColumn() {
        return ignoreDropColumn;
    }

    /**
     * Setter for {@link #ignoreAlterColumn}.
     * @param ignoreDropTable {@link #ignoreAlterColumn}.
     */
    public void setIgnoreAlterColumn(boolean ignoreAlterColumn) {
        this.ignoreAlterColumn = ignoreAlterColumn;
    }
    /**
      * Getter for {@link #ignoreAlterColumn}.
     * @return {@link #ignoreAlterColumn}.
     */
    public boolean isIgnoreAlterColumn() {
        return ignoreAlterColumn;
    }

    /**
     * Getter for {@link #outputIgnoredStatements}.
     *
     * @return {@link #outputIgnoredStatements}
     */
    public boolean isOutputIgnoredStatements() {
        return outputIgnoredStatements;
    }

    /**
     * Setter for {@link #outputIgnoredStatements}.
     *
     * @param outputIgnoredStatements {@link #outputIgnoredStatements}
     */
    public void setOutputIgnoredStatements(
            final boolean outputIgnoredStatements) {
        this.outputIgnoredStatements = outputIgnoredStatements;
    }

    /**
     * Setter for {@link #version}.
     *
     * @param version {@link #version}
     */
    public void setVersion(final boolean version) {
        this.version = version;
    }

    /**
     * Getter for {@link #version}.
     *
     * @return {@link #version}
     */
    public boolean isVersion() {
        return version;
    }

    /**
     * Getter for {@link #help}.
     * @return the help {@link ##help}
     */
    public boolean isHelp() {
        return help;
    }

    /**
     * Setter for {@link #help}.
     * @param help {@link #help}
     */
    public void setHelp(boolean help) {
        this.help = help;
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
    public boolean parse(final PrintWriter writer, final String[] args) {
        boolean success = true;
        int argsLength = args.length;

        for (int i = 0; i < argsLength; i++) {
            if("--diff".equals(args[i])) {
                setModeDiff(true);
                argsLength -= 3; // dont read last three parameters in the loop, they're not options
            } else if("--parse".equals(args[i])) {
                setModeParse(true);
                argsLength -= 2; // same for last two params in this mode
            } else if("--dbOld-format".equals(args[i])) {
                String format = args[++i];
                
                if("dump".equals(format) || "parsed".equals(format) || "db".equals(format)) {
                    setOldSrcFormat(format);
                } else {
                    writer.println("Unsupported DB format!");
                    success = false;
                }
            } else if("--dbNew-format".equals(args[i])) {
                String format = args[++i];
                
                if("dump".equals(format) || "parsed".equals(format) || "db".equals(format)) {
                    setNewSrcFormat(format);
                } else {
                    writer.println("Unsupported DB format!");
                    success = false;
                }
            } else if ("--allow-danger-ddl".equals(args[i])) {
                String[] ignores = args[++i].split(Pattern.quote(","));
                for (String ignoredDanger : ignores) {
                    DangerStatement dst;
                    try {
                        dst = DangerStatement.valueOf(ignoredDanger);
                    } catch (IllegalArgumentException ex) {
                        // illegal ignore type
                        writer.println("Incorrect --allow-danger-ddl option!");
                        success = false;
                        break;
                    }
                    switch (dst) {
                    case ALTER_COLUMN:
                        setIgnoreAlterColumn(true);
                        break;
                    case DROP_COLUMN:
                        setIgnoreDropColumn(true);
                        break;
                    case DROP_TABLE:
                        setIgnoreDropTable(true);
                        break;
                    }
                }
            } else if("--db-format".equals(args[i])) {
                String format = args[++i];
                
                if("dump".equals(format) || "db".equals(format)) {
                    setParseSrcFormat(format);
                } else {
                    writer.println("Unsupported DB format for parsing!");
                    success = false;
                }
            } else if ("--add-transaction".equals(args[i])) {
                setAddTransaction(true);
            } else if ("--no-check-function-bodies".equals(args[i])) {
                setCheckFunctionBodies(false);
            } else if ("--ignore-slony-triggers".equals(args[i])) {
                setIgnoreSlonyTriggers(true);
            } else if ("--in-charset-name".equals(args[i])) {
                setInCharsetName(args[i + 1]);
                i++;
            } else if ("--list-charsets".equals(args[i])) {
                setListCharsets(true);
            } else if ("--out-charset-name".equals(args[i])) {
                setOutCharsetName(args[i + 1]);
                i++;
            } else if ("--time-zone".equals(args[i])) {
                setTimeZone(args[i + 1]);
                i++;
            } else if ("--output-ignored-statements".equals(args[i])) {
                setOutputIgnoredStatements(true);
            } else if ("--version".equals(args[i])) {
                setVersion(true);
            } else if ("--help".equals(args[i])) {
                setHelp(true);
            } else {
                writer.println(MessageFormat.format(Messages.Argument_ErrorUnknownOption, args[i]));
                success = false;

                break;
            }
        }
        
        if("db".equals(getOldSrcFormat()) || "db".equals(getNewSrcFormat())
                || "db".equals(getParseSrcFormat())) {
            throw new UnsupportedOperationException("DB connection is not yet implemented!");
        }

        if (args.length == 1 && isVersion()) {
            printVersion(writer);
            return false;
        } else if ((args.length == 1 && isHelp())) {
            printUsage(writer);
            return false;
        } else if (args.length == 1 && isListCharsets()) {
            listCharsets(writer);
            return false;
        } else if(isModeDiff() == isModeParse()) {
            success = false;
            if(isModeDiff()) {
                writer.println("Only one of --diff or --parse mode can be set!");
            }
        } else if (args.length < 3) {
            success = false;
        }
        
        if (!success) {
            printUsage(writer);
            return false;
        }
        
        try {
            if(isModeDiff()) {
                setOldSrc(args[args.length - 3]);
                setNewSrc(args[args.length - 2]);
                setDiffOutfile(args[args.length - 1]);
            } else if (isModeParse()) {
                setParseSrc(args[args.length - 2]);
                setParserOutdir(args[args.length - 1]);
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            printUsage(writer);
            return false;
        }
        
        return true;
    }

    /**
     * Prints program usage.
     *
     * @param writer writer to print the usage to
     */
    private void printUsage(final PrintWriter writer) {
        writer.println(
                Messages.UsageHelp.replace("${tab}", "\t"));
    }

    /**
     * Prints program version.
     *
     * @param writer writer to print the usage to
     */
    private void printVersion(final PrintWriter writer) {
        BundleContext ctx = Activator.getContext();
        writer.println(MessageFormat.format(Messages.Version,
                ctx == null ? "error: no OSGI running" : ctx.getBundle().getVersion()));
    }

    /**
     * Getter for {@link #inCharsetName}.
     *
     * @return {@link #inCharsetName}
     */
    public String getInCharsetName() {
        return inCharsetName;
    }

    /**
     * Setter for {@link #inCharsetName}.
     *
     * @param inCharsetName {@link #inCharsetName}
     */
    public void setInCharsetName(final String inCharsetName) {
        this.inCharsetName = inCharsetName;
    }

    /**
     * Getter for {@link #outCharsetName}.
     *
     * @return {@link #outCharsetName}
     */
    public String getOutCharsetName() {
        return outCharsetName;
    }

    /**
     * Setter for {@link #outCharsetName}.
     *
     * @param outCharsetName {@link #outCharsetName}
     */
    public void setOutCharsetName(final String outCharsetName) {
        this.outCharsetName = outCharsetName;
    }

    /**
     * Getter for {@link #listCharsets}.
     *
     * @return {@link #listCharsets}
     */
    public boolean isListCharsets() {
        return listCharsets;
    }

    /**
     * Setter for {@link #listCharsets}.
     *
     * @param listCharsets {@link #listCharsets}
     */
    public void setListCharsets(final boolean listCharsets) {
        this.listCharsets = listCharsets;
    }

    /**
     * Lists supported charsets.
     *
     * @param writer writer
     */
    private void listCharsets(final PrintWriter writer) {
        final SortedMap<String, Charset> charsets = Charset.availableCharsets();

        for (final String name : charsets.keySet()) {
            writer.println(name);
        }
    }

    /**
     * Getter for {@link #ignoreSlonyTriggers}.
     *
     * @return {@link #ignoreSlonyTriggers}
     */
    public boolean isIgnoreSlonyTriggers() {
        return ignoreSlonyTriggers;
    }

    /**
     * Setter for {@link #ignoreSlonyTriggers}.
     *
     * @param ignoreSlonyTriggers {@link #ignoreSlonyTriggers}
     */
    public void setIgnoreSlonyTriggers(final boolean ignoreSlonyTriggers) {
        this.ignoreSlonyTriggers = ignoreSlonyTriggers;
    }
    /**
     * Setter for {@link #checkFunctionBodies}.
     *
     * @param checkFunctionBodies {@link #checkFunctionBodies}
     */
    public void setCheckFunctionBodies(boolean checkFunctionBodies) {
        this.checkFunctionBodies = checkFunctionBodies;
    }
   
    /**
     * Getter for {@link #checkFunctionBodies}.
     *
     * @return {@link #checkFunctionBodies}
     */
    public boolean isCheckFunctionBodies() {
        return checkFunctionBodies;
    }
    /**
     * Setter for {@link #timeZone}.
     *
     * @param timeZone {@link #timeZone}
     */
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }
    /**
     * Getter for {@link #timeZone}.
     *
     * @return {@link #timeZone}
     */
    public String getTimeZone() {
        return timeZone;
    }
}
