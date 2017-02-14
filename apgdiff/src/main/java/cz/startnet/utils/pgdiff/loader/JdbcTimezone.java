package cz.startnet.utils.pgdiff.loader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTimezone {

    public String getTimeZone (String host, int port, String user, String pass, String name, String charset, String timezone){
        JdbcConnector connector;
        try {
            connector = new JdbcConnector(host,port,user,pass,name,charset,timezone);

            try(Connection conn = connector.getConnection(); Statement s = conn.createStatement()){
                String sql ="select name, setting from pg_file_settings where lower(name) = 'timezone' and applied and error is null";
                ResultSet rs = s.executeQuery(sql);
                rs.next();
                return rs.getString("setting");
            } catch (SQLException e) {
                return null;
            }
        }catch (IOException e) {
            return null;
        }
    }
}
