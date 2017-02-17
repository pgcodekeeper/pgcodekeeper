/**
 * Copyright 2006 StartNet s.r.o.
 *
 * Distributed under MIT license
 */
package cz.startnet.utils.pgdiff;

import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;

import org.osgi.framework.BundleContext;

import cz.startnet.utils.pgdiff.PgDiffStatement.DangerStatement;
import ru.taximaxim.codekeeper.apgdiff.Activator;
import ru.taximaxim.codekeeper.apgdiff.ApgdiffConsts;
import ru.taximaxim.codekeeper.apgdiff.licensing.License;
import ru.taximaxim.codekeeper.apgdiff.licensing.LicenseException;
import ru.taximaxim.codekeeper.apgdiff.localizations.Messages;
import ru.taximaxim.codekeeper.apgdiff.model.difftree.DbObjType;

public class PgDiffArguments {
    // SONAR-OFF
    private static final String DEFAULT_FORMAT = "dump"; //$NON-NLS-1$
    // SONAR-ON

    private boolean modeDiff;
    private boolean modeParse;
    private String newSrc;
    private String oldSrc;
    private String newSrcFormat = DEFAULT_FORMAT;
    private String oldSrcFormat = DEFAULT_FORMAT;
    private String diffOutfile;
    private String parseSrc;
    private String parseSrcFormat = DEFAULT_FORMAT;
    private String parserOutdir;
    private String inCharsetName = ApgdiffConsts.UTF_8;
    private String outCharsetName = ApgdiffConsts.UTF_8;
    private boolean addTransaction;
    private boolean ignoreDropTable;
    private boolean ignoreDropColumn;
    private boolean ignoreAlterColumn;
    private boolean ignoreRestartWith;
    private boolean version;
    private boolean help;
    private boolean outputIgnoredStatements;
    private boolean listCharsets;
    private boolean ignoreSlonyTriggers;
    private boolean usingOnOff = true;
    private final Set<DbObjType> allowedTypes = EnumSet.noneOf(DbObjType.class);
    /**
     * Whether ignore function bodies.
     * TODO придумать проверить из командной строки параметр
     */
    private boolean checkFunctionBodies = true;
    private String timeZone;
    private boolean ignorePrivileges;
    private boolean forceUnixNewlines = true;
    private String licensePath;
    private License license;
    private final List<String> ignoreLists = new ArrayList<>();

    public void setModeDiff(final boolean modeDiff) {
        this.modeDiff = modeDiff;
    }

    public boolean isModeDiff() {
        return modeDiff;
    }

    public void setModeParse(final boolean modeParse) {
        this.modeParse = modeParse;
    }

    public boolean isModeParse() {
        return modeParse;
    }

    public void setNewSrc(final String newSrc) {
        this.newSrc = newSrc;
    }

    public String getNewSrc() {
        return newSrc;
    }

    public void setOldSrc(final String oldSrc) {
        this.oldSrc = oldSrc;
    }

    public String getOldSrc() {
        return this.oldSrc;
    }

    public void setNewSrcFormat(final String newSrcFormat) {
        this.newSrcFormat = newSrcFormat;
    }

    public String getNewSrcFormat() {
        return this.newSrcFormat;
    }

    public void setOldSrcFormat(final String oldSrcFormat) {
        this.oldSrcFormat = oldSrcFormat;
    }

    public String getOldSrcFormat() {
        return this.oldSrcFormat;
    }

    public void setDiffOutfile(final String diffOutfile) {
        this.diffOutfile = diffOutfile;
    }

    public String getDiffOutfile() {
        return this.diffOutfile;
    }

    public void setParseSrc(final String parseSrc) {
        this.parseSrc = parseSrc;
    }

    public String getParseSrc() {
        return this.parseSrc;
    }

    public void setParseSrcFormat(final String parseSrcFormat) {
        this.parseSrcFormat = parseSrcFormat;
    }

    public String getParseSrcFormat() {
        return this.parseSrcFormat;
    }

    public void setParserOutdir(final String parserOutdir) {
        this.parserOutdir = parserOutdir;
    }

    public String getParserOutdir() {
        return this.parserOutdir;
    }

    public void setAddTransaction(final boolean addTransaction) {
        this.addTransaction = addTransaction;
    }

    public boolean isAddTransaction() {
        return addTransaction;
    }

    public void setIgnoreDropTable(boolean ignoreDropTable) {
        this.ignoreDropTable = ignoreDropTable;
    }

    public boolean isIgnoreDropTable() {
        return ignoreDropTable;
    }

    public void setIgnoreDropColumn(boolean ignoreDropColumn) {
        this.ignoreDropColumn = ignoreDropColumn;
    }

    public boolean isIgnoreDropColumn() {
        return ignoreDropColumn;
    }

    public void setIgnoreAlterColumn(boolean ignoreAlterColumn) {
        this.ignoreAlterColumn = ignoreAlterColumn;
    }

    public boolean isIgnoreAlterColumn() {
        return ignoreAlterColumn;
    }

    public void setIgnoreRestartWith(boolean ignoreRestartWith) {
        this.ignoreRestartWith = ignoreRestartWith;
    }

    public boolean isIgnoreRestartWith() {
        return ignoreRestartWith;
    }

    public boolean isOutputIgnoredStatements() {
        return outputIgnoredStatements;
    }

    public void setOutputIgnoredStatements(
            final boolean outputIgnoredStatements) {
        this.outputIgnoredStatements = outputIgnoredStatements;
    }

    public void setVersion(final boolean version) {
        this.version = version;
    }

    public boolean isVersion() {
        return version;
    }

    public boolean isHelp() {
        return help;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }

    public String getLicensePath() {
        return licensePath;
    }

    public void setLicensePath(String licensePath) {
        this.licensePath = licensePath;
    }

    public License getLicense() throws LicenseException {
        if (license == null) {
            throw new LicenseException(Messages.PgDiffArguments_no_license_set);
        }
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public List<String> getIgnoreLists() {
        return Collections.unmodifiableList(ignoreLists);
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
            if("--diff".equals(args[i])) { //$NON-NLS-1$
                setModeDiff(true);
                argsLength -= 3; // dont read last three parameters in the loop, they're not options
            } else if("--parse".equals(args[i])) { //$NON-NLS-1$
                setModeParse(true);
                argsLength -= 2; // same for last two params in this mode
            } else if("--dbOld-format".equals(args[i])) { //$NON-NLS-1$
                String format = args[++i];

                if("dump".equals(format) || "parsed".equals(format) || "db".equals(format)) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    setOldSrcFormat(format);
                } else {
                    writer.println(Messages.PgDiffArguments_unsupported_db_format);
                    success = false;
                }
            } else if("--dbNew-format".equals(args[i])) { //$NON-NLS-1$
                String format = args[++i];

                if("dump".equals(format) || "parsed".equals(format) || "db".equals(format)) { //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
                    setNewSrcFormat(format);
                } else {
                    writer.println(Messages.PgDiffArguments_unsupported_db_format);
                    success = false;
                }
            } else if ("--allow-danger-ddl".equals(args[i])) { //$NON-NLS-1$
                String[] ignores = args[++i].split(","); //$NON-NLS-1$
                for (String ignoredDanger : ignores) {
                    DangerStatement dst;
                    try {
                        dst = DangerStatement.valueOf(ignoredDanger);
                    } catch (IllegalArgumentException ex) {
                        // illegal ignore type
                        writer.println(Messages.PgDiffArguments_bad_danger_ddl);
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
                    case RESTART_WITH:
                        setIgnoreRestartWith(true);
                        break;
                    }
                }
            } else if("--db-format".equals(args[i])) { //$NON-NLS-1$
                String format = args[++i];

                if("dump".equals(format) || "db".equals(format)) { //$NON-NLS-1$ //$NON-NLS-2$
                    setParseSrcFormat(format);
                } else {
                    writer.println(Messages.PgDiffArguments_unsupported_db_format);
                    success = false;
                }
            } else if ("--allowed-objects".equals(args[i])) { //$NON-NLS-1$
                String[] types = args[++i].split(","); //$NON-NLS-1$
                for (String type : types) {
                    try {
                        allowedTypes.add(DbObjType.valueOf(type));
                    } catch (IllegalArgumentException ex) {
                        // illegal ignore type
                        writer.println(Messages.PgDiffArguments_bad_allowed_objects);
                        success = false;
                        break;
                    }
                }
            } else if ("--add-transaction".equals(args[i])) { //$NON-NLS-1$
                setAddTransaction(true);
            } else if ("--no-check-function-bodies".equals(args[i])) { //$NON-NLS-1$
                setCheckFunctionBodies(false);
            } else if ("--no-privileges".equals(args[i])) { //$NON-NLS-1$
                setIgnorePrivileges(true);
            } else if ("--ignore-slony-triggers".equals(args[i])) { //$NON-NLS-1$
                setIgnoreSlonyTriggers(true);
            } else if ("--in-charset-name".equals(args[i])) { //$NON-NLS-1$
                setInCharsetName(args[i + 1]);
                i++;
            } else if ("--list-charsets".equals(args[i])) { //$NON-NLS-1$
                setListCharsets(true);
            } else if ("--out-charset-name".equals(args[i])) { //$NON-NLS-1$
                setOutCharsetName(args[i + 1]);
                i++;
            } else if ("--time-zone".equals(args[i])) { //$NON-NLS-1$
                setTimeZone(args[i + 1]);
                i++;
            } else if ("--keep-newlines".equals(args[i])) { //$NON-NLS-1$
                setForceUnixNewlines(false);
            } else if ("--output-ignored-statements".equals(args[i])) { //$NON-NLS-1$
                setOutputIgnoredStatements(true);
            } else if ("--using-off".equals(args[i])) { //$NON-NLS-1$
                setUsingOnOff(false);
            } else if("--license".equals(args[i])) { //$NON-NLS-1$
                setLicensePath(args[++i]);
            } else if ("--ignore-list".equals(args[i])) { //$NON-NLS-1$
                ignoreLists.add(args[++i]);
            } else if ("--version".equals(args[i])) { //$NON-NLS-1$
                setVersion(true);
            } else if ("--help".equals(args[i])) { //$NON-NLS-1$
                setHelp(true);
            } else {
                writer.println(MessageFormat.format(Messages.Argument_ErrorUnknownOption, args[i]));
                success = false;

                break;
            }
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
                writer.println(Messages.PgDiffArguments_only_diff_parse);
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

    private void printUsage(final PrintWriter writer) {
        writer.println(Messages.UsageHelp.replace("${tab}", "\t")); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private void printVersion(final PrintWriter writer) {
        BundleContext ctx = Activator.getContext();
        writer.println(MessageFormat.format(Messages.Version,
                ctx == null ? "error: no OSGI running" : ctx.getBundle().getVersion())); //$NON-NLS-1$
    }

    public String getInCharsetName() {
        return inCharsetName;
    }

    public void setInCharsetName(final String inCharsetName) {
        this.inCharsetName = inCharsetName;
    }

    public String getOutCharsetName() {
        return outCharsetName;
    }

    public void setOutCharsetName(final String outCharsetName) {
        this.outCharsetName = outCharsetName;
    }

    public boolean isListCharsets() {
        return listCharsets;
    }

    public void setListCharsets(final boolean listCharsets) {
        this.listCharsets = listCharsets;
    }

    private void listCharsets(final PrintWriter writer) {
        final SortedMap<String, Charset> charsets = Charset.availableCharsets();

        for (final String name : charsets.keySet()) {
            writer.println(name);
        }
    }

    public boolean isIgnoreSlonyTriggers() {
        return ignoreSlonyTriggers;
    }

    public void setIgnoreSlonyTriggers(final boolean ignoreSlonyTriggers) {
        this.ignoreSlonyTriggers = ignoreSlonyTriggers;
    }

    public void setCheckFunctionBodies(boolean checkFunctionBodies) {
        this.checkFunctionBodies = checkFunctionBodies;
    }

    public boolean isCheckFunctionBodies() {
        return checkFunctionBodies;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setIgnorePrivileges(boolean ignorePrivilleges) {
        this.ignorePrivileges = ignorePrivilleges;
    }

    public boolean isIgnorePrivileges() {
        return ignorePrivileges;
    }

    public void setForceUnixNewlines(boolean forceUnixNewlines) {
        this.forceUnixNewlines = forceUnixNewlines;
    }

    public boolean isForceUnixNewlines() {
        return forceUnixNewlines;
    }

    public Set<DbObjType> getAllowedTypes() {
        return Collections.unmodifiableSet(allowedTypes);
    }

    public boolean isUsingOnOff() {
        return usingOnOff;
    }

    public void setUsingOnOff(boolean usingOnOff) {
        this.usingOnOff = usingOnOff;
    }
}
