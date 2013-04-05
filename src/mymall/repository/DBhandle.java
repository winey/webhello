package mymall.repository;

import java.sql.*;

public class DBhandle {
    public DBhandle() {
    }

    public Connection dbConnect() {
        String url = "jdbc:postgresql://localhost:5432/mymall";
        String usr = "test";
        String pwd = "1004";

        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, usr, pwd);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void dbDisconnect(ResultSet rs, PreparedStatement pstmt, Connection conn) {

        try {

            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dbDisconnect(PreparedStatement pstmt, Connection conn) {

        try {

            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dbDisconnect(Connection conn) {

        try {

            if (conn != null) {
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}