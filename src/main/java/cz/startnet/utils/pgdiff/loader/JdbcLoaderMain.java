package cz.startnet.utils.pgdiff.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JdbcLoaderMain {
    private static String host = "10.84.0.5";
    private static int port = 5432;
    
    public static void main(String[] args) throws IOException {
        String pass = getPgPassPassword();
        JdbcLoader db = new JdbcLoader(host, port, "ryabinin_av", pass, "maindb_dev", "UTF-8");
        db.getDbFromJdbc();
    }

    
    private static String getPgPassPassword() throws IOException{
        File pgpass = new File(System.getProperty("user.home") + "/.pgpass");
        BufferedReader br = new BufferedReader(new FileReader(pgpass));
        String line;
        while ((line = br.readLine()) != null) {
           if (line.startsWith(host + ":" + port)){
               br.close();
               return line.substring(line.length() - 9);
           }
        }
        br.close();
        return "";
    }
}
