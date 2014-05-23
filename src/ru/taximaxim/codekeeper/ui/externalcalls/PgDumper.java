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

public class PgDumper {
    
    private final static Pattern PATTERN_VERSION = Pattern.compile(
            "^(?:pg_dump[\\s]+\\(PostgreSQL.*\\)[\\s]+)([\\d]+\\.[\\d]+\\.[\\d]+)$");

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
                Arrays.asList(customParams.split(Pattern.quote(" ")))
                );
        listCustom.removeAll(Arrays.asList(new String[] { "" }));
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
                "--file=" + dumpFile,
                "--schema-only",
                "--no-password");
        
        pgdump.command().addAll(customParams);
        
        ProcBuilderUtils env = new ProcBuilderUtils(pgdump);
        env.addEnv("PGHOST", host);
        env.addEnv("PGPORT", port);
        env.addEnv("PGDATABASE", dbname);
        env.addEnv("PGUSER", user);
        env.addEnv("PGPASSWORD", pass);
        env.addEnv("PGCLIENTENCODING", encoding);
        
        StdStreamRedirector.launchAndRedirect(pgdump);
    }
    
    public String getVersion() throws IOException {
        ProcessBuilder pgdump = new ProcessBuilder(exePgdump,
                "--version", "--no-password");
        String version = StdStreamRedirector.launchAndRedirect(pgdump).trim();
        Matcher m = PATTERN_VERSION.matcher(version);
        if(!m.matches()) {
            throw new IOException("Bad pg_dump --version output: " + version);
        }
        return m.group(1);
    }
}
