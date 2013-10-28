package ru.taximaxim.codekeeper.ui.externalcalls;

import java.io.IOException;

import ru.taximaxim.codekeeper.ui.externalcalls.utils.ProcBuilderUtils;
import ru.taximaxim.codekeeper.ui.externalcalls.utils.StdStreamRedirector;

public class PgDumper {

    final private String exePgdump;

    final private String host, user, pass, dbname, encoding;
    final private int port;
    
    final private String dumpFile;
    
    public PgDumper(String exePgdump, String host, int port,
            String user, String pass, String dbname, String encoding,
            String dumpFile) {
        this.exePgdump = exePgdump;
        this.host = host;
        this.port = port;
        this.user = user;
        this.pass = pass;
        this.dbname = dbname;
        this.encoding = encoding;
        this.dumpFile = dumpFile;
    }
    
	public void pgDump() throws IOException {
		ProcessBuilder pgdump = new ProcessBuilder(exePgdump,
				"--file=" + dumpFile,
				"--schema-only",
				"--no-password");
		
		ProcBuilderUtils env = new ProcBuilderUtils(pgdump);
		env.addEnv("PGHOST", host);
        env.addEnv("PGPORT", port);
        env.addEnv("PGDATABASE", dbname);
        env.addEnv("PGUSER", user);
        env.addEnv("PGPASSWORD", pass);
        env.addEnv("PGCLIENTENCODING", encoding);
		
		StdStreamRedirector.launchAndRedirect(pgdump);
	}
}
