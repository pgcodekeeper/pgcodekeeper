/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.SortedMap;

/**
 * Contains parsed command line arguments.
 *
 * @author fordfrog
 */
public class PgDiffArguments {
    
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
    private String newSrcFormat = "dump";
    /**
     * Old DB source format.
     */
    private String oldSrcFormat = "dump";
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
    private String parseSrcFormat = "dump";
    /**
     * Directory to parse into.
     */
    private String parserOutdir;
    /**
     * Input file charset name.
     */
    private String inCharsetName = "UTF-8";
    /**
     * Output file charset name.
     */
    private String outCharsetName = "UTF-8";
    /**
     * Whether DEFAULT ... should be added in case new column has NOT NULL
     * constraint. The default value is dropped later.
     */
    private boolean addDefaults;
    /**
     * Whether to enclose all statements in transaction.
     */
    private boolean addTransaction;
    /**
     * Whether to ignore whitespace while comparing content of functions.
     */
    private boolean ignoreFunctionWhitespace;
    /**
     * Whether to ignore START WITH on SEQUENCEs.
     */
    private boolean ignoreStartWith;
    /**
     * Whether to display apgdiff version.
     */
    private boolean version;
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
     * Setter for {@link #addDefaults}.
     *
     * @param addDefaults {@link #addDefaults}
     */
    public void setAddDefaults(final boolean addDefaults) {
        this.addDefaults = addDefaults;
    }

    /**
     * Getter for {@link #addDefaults}.
     *
     * @return {@link #addDefaults}
     */
    public boolean isAddDefaults() {
        return addDefaults;
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
     * Setter for {@link #ignoreFunctionWhitespace}.
     *
     * @param ignoreFunctionWhitespace {@link #ignoreFunctionWhitespace}
     */
    public void setIgnoreFunctionWhitespace(
            final boolean ignoreFunctionWhitespace) {
        this.ignoreFunctionWhitespace = ignoreFunctionWhitespace;
    }

    /**
     * Getter for {@link #ignoreFunctionWhitespace}.
     *
     * @return {@link #ignoreFunctionWhitespace}
     */
    public boolean isIgnoreFunctionWhitespace() {
        return ignoreFunctionWhitespace;
    }

    /**
     * Setter for {@link #ignoreStartWith}.
     *
     * @param ignoreStartWith {@link #ignoreStartWith}
     */
    public void setIgnoreStartWith(final boolean ignoreStartWith) {
        this.ignoreStartWith = ignoreStartWith;
    }

    /**
     * Getter for {@link #ignoreStartWith}.
     *
     * @return {@link #ignoreStartWith}
     */
    public boolean isIgnoreStartWith() {
        return ignoreStartWith;
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
            } else if("--db-format".equals(args[i])) {
                String format = args[++i];
                
                if("dump".equals(format) || "db".equals(format)) {
                    setParseSrcFormat(format);
                } else {
                    writer.println("Unsupported DB format for parsing!");
                    success = false;
                }
            } else if ("--add-defaults".equals(args[i])) {
                setAddDefaults(true);
            } else if ("--add-transaction".equals(args[i])) {
                setAddTransaction(true);
            } else if ("--ignore-function-whitespace".equals(args[i])) {
                setIgnoreFunctionWhitespace(true);
            } else if ("--ignore-slony-triggers".equals(args[i])) {
                setIgnoreSlonyTriggers(true);
            } else if ("--ignore-start-with".equals(args[i])) {
                setIgnoreStartWith(true);
            } else if ("--in-charset-name".equals(args[i])) {
                setInCharsetName(args[i + 1]);
                i++;
            } else if ("--list-charsets".equals(args[i])) {
                setListCharsets(true);
            } else if ("--out-charset-name".equals(args[i])) {
                setOutCharsetName(args[i + 1]);
                i++;
            } else if ("--output-ignored-statements".equals(args[i])) {
                setOutputIgnoredStatements(true);
            } else if ("--version".equals(args[i])) {
                setVersion(true);
            } else if ("--help".equals(args[i])) {
                success = false;
            } else {
                writer.print(Resources.getString("ErrorUnknownOption"));
                writer.print(": ");
                writer.println(args[i]);
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
                Resources.getString("UsageHelp").replace("${tab}", "\t"));
    }

    /**
     * Prints program version.
     *
     * @param writer writer to print the usage to
     */
    private void printVersion(final PrintWriter writer) {
        writer.print(Resources.getString("Version"));
        writer.print(": ");
        writer.println(Resources.getString("VersionNumber"));
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
}
