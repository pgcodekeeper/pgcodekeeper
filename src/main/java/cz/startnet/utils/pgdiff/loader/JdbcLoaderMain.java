package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;

import cz.startnet.utils.pgdiff.schema.PgDatabase;

public class JdbcLoaderMain {
    private static String host = "10.84.0.5";
    private static int port = 5432;
    
    public static void main(String[] args) throws IOException {
        String pass = "";
        JdbcLoader db = new JdbcLoader(host, port, "ryabinin_av", pass, "maindb_dev4", "UTF-8");
        PgDatabase dbss = db.getDbFromJdbc();
    }

    
    
}
