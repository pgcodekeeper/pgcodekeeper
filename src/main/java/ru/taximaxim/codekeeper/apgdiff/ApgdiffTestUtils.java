package ru.taximaxim.codekeeper.apgdiff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;

import org.junit.Assert;

import ru.taximaxim.codekeeper.apgdiff.model.difftree.TreeElement;
import cz.startnet.utils.pgdiff.TEST;
import cz.startnet.utils.pgdiff.loader.JdbcConnector;
import cz.startnet.utils.pgdiff.loader.JdbcLoaderTest;
import cz.startnet.utils.pgdiff.loader.JdbcRunner;

public class ApgdiffTestUtils {
    
    private static final String REMOTE_DROPDB_SQL = "remote/dropdb.sql";
    private static final String REMOTE_CREATEDB_SQL = "remote/createdb.sql";
    
    public static void createDB(String dbName) throws IOException {
        JdbcConnector connector = new JdbcConnector(TEST.REMOTE_HOST, TEST.REMOTE_PORT,
                TEST.REMOTE_USERNAME, TEST.REMOTE_PASSWORD, TEST.REMOTE_DB,
                ApgdiffConsts.UTF_8, ApgdiffConsts.UTC);
        try (InputStreamReader isr = new InputStreamReader(
                JdbcLoaderTest.class.getResourceAsStream(REMOTE_CREATEDB_SQL),
                "UTF-8");
                BufferedReader reader = new BufferedReader(isr)) {
            StringBuilder script = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                script.append(line);
                script.append("\n");
            }
            String scr = MessageFormat.format(script.toString(), dbName, TEST.REMOTE_DB);
            String res = new JdbcRunner(connector).runScript(scr);
            Assert.assertEquals("Create DB over JDBC exited with an error: "
                    + res, "success", res);
        }
    }
    
    public static void fillDB(String dbName) throws IOException {
        fillDB(dbName, JdbcLoaderTest.class.getResourceAsStream(TEST.RESOURCE_DUMP));
    }
    
    public static void fillDB(String dbName, InputStream in) throws IOException {
        JdbcConnector connector = new JdbcConnector(TEST.REMOTE_HOST, TEST.REMOTE_PORT,
                TEST.REMOTE_USERNAME, TEST.REMOTE_PASSWORD, dbName,
                ApgdiffConsts.UTF_8, ApgdiffConsts.UTC);
     // dump schemas back
        try (InputStreamReader isr = new InputStreamReader(
                in,
                "UTF-8");
                BufferedReader reader = new BufferedReader(isr)) {

            StringBuilder script = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                script.append(line);
                script.append("\n");
            }

            String res = new JdbcRunner(connector).runScript(script.toString());
            Assert.assertEquals("DDL update over JDBC exited with an error: "
                    + res, "success", res);
        }
    }
    
    public static void dropDB(String dbName) throws IOException {
        JdbcConnector connector = new JdbcConnector(TEST.REMOTE_HOST, TEST.REMOTE_PORT,
                TEST.REMOTE_USERNAME, TEST.REMOTE_PASSWORD, TEST.REMOTE_DB,
                ApgdiffConsts.UTF_8, ApgdiffConsts.UTC);
        try (InputStreamReader isr = new InputStreamReader(
                JdbcLoaderTest.class.getResourceAsStream(REMOTE_DROPDB_SQL),
                "UTF-8");
                BufferedReader reader = new BufferedReader(isr)) {

            StringBuilder script = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                script.append(line);
            }
            String scr = MessageFormat.format(script.toString(), dbName);
            String res = new JdbcRunner(connector).runScript(scr);
            Assert.assertEquals("DB cleanup script returned an error: " + res,
                    "success", res);
        }
    }
    
    private ApgdiffTestUtils() {}

    /**
     * Отмечает все элементы в предоставленном дереве начиная с текущего элемента
     * @param dbTree
     */
    public static void setAllchecked(TreeElement dbTree) {
        dbTree.setSelected(true);
        for (TreeElement child : dbTree.getChildren()) {
            setAllchecked(child);
        }
    }
}
