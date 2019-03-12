package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.NullProgressMonitor;

import cz.startnet.utils.pgdiff.IProgressReporter;
import ru.taximaxim.codekeeper.ui.consoles.UiProgressReporter;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.ProcBuilderUtils;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PgDumper {

    private static final Pattern PATTERN_VERSION = Pattern.compile(
            "^(?:pg_dump[\\s]+\\(PostgreSQL.*\\)[\\s]+)([\\d]+\\.[\\d]+\\.[\\d]+)$"); //$NON-NLS-1$

    private final String exePgdump;
    private final List<String> customParams;

    private final String host;
    private final String user;
    private final String pass;
    private final String dbname;
    private final String encoding;
    private final String timezone;

    private final int port;

    private final IProgressReporter reporter;

    public PgDumper(String exePgdump, String customParams, String host, int port,
            String user, String pass, String dbname, String encoding,
            String timezone, IProgressReporter reporter) {
        this.exePgdump = exePgdump;
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.dbname = dbname;
        this.encoding = encoding;
        this.timezone = timezone;

        this.customParams = Collections.unmodifiableList(
                Arrays.asList(customParams.split(" ", -1)));//$NON-NLS-1$
        this.reporter = reporter;
    }

    /**
     * Constructs an object for simple operations,
     * not requiring credentials and other information.
     *
     * Such operations WILL THROW NPEs when performed on this object.
     *
     * @param exePgdump
     */
    public PgDumper(String exePgdump) {
        this.exePgdump = exePgdump;

        customParams = Arrays.asList();
        host = user = pass = dbname = encoding = timezone = null;
        port = 0;
        reporter = new UiProgressReporter(new NullProgressMonitor());
    }

    public byte[] pgDump() throws IOException {
        ProcessBuilder pgdump = new ProcessBuilder(exePgdump);

        pgdump.command().addAll(customParams);

        ProcBuilderUtils env = new ProcBuilderUtils(pgdump);
        env.addEnv("PGHOST", host); //$NON-NLS-1$
        env.addEnv("PGPORT", port); //$NON-NLS-1$
        env.addEnv("PGDATABASE", dbname); //$NON-NLS-1$
        env.addEnv("PGUSER", user); //$NON-NLS-1$
        env.addEnv("PGPASSWORD", pass); //$NON-NLS-1$
        env.addEnv("PGCLIENTENCODING", encoding); //$NON-NLS-1$
        env.addEnv("PGTZ", timezone); //$NON-NLS-1$

        StdStreamRedirector redirector = new StdStreamRedirector(reporter);
        redirector.launchAndRedirect(pgdump);
        return redirector.getInputArray();
    }

    public String getVersion() throws IOException {
        ProcessBuilder pgdump = new ProcessBuilder(exePgdump,
                "--version", "--no-password"); //$NON-NLS-1$ //$NON-NLS-2$
        StdStreamRedirector redirector = new StdStreamRedirector(reporter);
        redirector.launchAndRedirect(pgdump);
        String version = new String(redirector.getInputArray()).trim();
        Matcher m = PATTERN_VERSION.matcher(version);
        if (!m.matches()) {
            throw new IOException(MessageFormat.format(
                    Messages.pgDumper_bad_pg_dump_version_output, version));
        }
        return m.group(1);
    }
}
