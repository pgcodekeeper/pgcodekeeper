package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.taximaxim.codekeeper.ui.externalcalls.utils.ProcBuilderUtils;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;
import ru.taximaxim.codekeeper.ui.localizations.Messages;

public class PgDumper {
    
    private final static Pattern PATTERN_VERSION = Pattern.compile(
            "^(?:pg_dump[\\s]+\\(PostgreSQL.*\\)[\\s]+)([\\d]+\\.[\\d]+\\.[\\d]+)$"); //$NON-NLS-1$

    private final String exePgdump;
    private final List<String> customParams;

    private final String host, user, pass, dbname, encoding;
    private final int port;
    
    private final String dumpFile;
    
    public PgDumper(String exePgdump, String customParams,
            String host, int port, String user, String pass,
            String dbname, String encoding, String dumpFile) {
        this.exePgdump = exePgdump;
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.dbname = dbname;
        this.encoding = encoding;
        this.dumpFile = dumpFile;
        
        List<String> listCustom = new ArrayList<>(
                Arrays.asList(customParams.split(Pattern.quote(" "))) //$NON-NLS-1$
                );
        listCustom.removeAll(Arrays.asList(new String[] { "" })); //$NON-NLS-1$
        this.customParams = Collections.unmodifiableList(listCustom);
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
        host = user = pass = dbname = encoding = dumpFile = null;
        port = 0;
    }
    
    public void pgDump() throws IOException {
        ProcessBuilder pgdump = new ProcessBuilder(exePgdump,
                "--file=" + dumpFile, //$NON-NLS-1$
                "--schema-only", //$NON-NLS-1$
                "--no-password"); //$NON-NLS-1$
        
        pgdump.command().addAll(customParams);
        
        ProcBuilderUtils env = new ProcBuilderUtils(pgdump);
        env.addEnv("PGHOST", host); //$NON-NLS-1$
        env.addEnv("PGPORT", port); //$NON-NLS-1$
        env.addEnv("PGDATABASE", dbname); //$NON-NLS-1$
        env.addEnv("PGUSER", user); //$NON-NLS-1$
        env.addEnv("PGPASSWORD", pass); //$NON-NLS-1$
        env.addEnv("PGCLIENTENCODING", encoding); //$NON-NLS-1$
        
        StdStreamRedirector.launchAndRedirect(pgdump);
    }
    
    public String getVersion() throws IOException {
        ProcessBuilder pgdump = new ProcessBuilder(exePgdump,
                "--version", "--no-password"); //$NON-NLS-1$ //$NON-NLS-2$
        String version = StdStreamRedirector.launchAndRedirect(pgdump).trim();
        Matcher m = PATTERN_VERSION.matcher(version);
        if(!m.matches()) {
            throw new IOException(Messages.PgDumper_bad_pg_dump_version_output + version);
        }
        return m.group(1);
    }
}
