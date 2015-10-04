package id.ac.uad.tif;

import java.sql.*;

/**
 * Created by an on 03/10/15.
 */
public class KoneksiBukuP {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/belajardb";

    static final String USER = "root";
    static final String PASS = "9";

    public static void main(String[] args) {

        Connection conn = null;
        java.sql.Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected database successfully...");

            //Insert
            /*System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO buku_pengarang " +
                    "VALUES ('125-989', '99991', '1', '2010')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO buku_pengarang " +
                    "VALUES ('137-000', '99992', '2', '2010')";
            stmt.executeUpdate(sql);*/

            //Update
            /*System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "UPDATE buku_pengarang " +
                    "SET tahun_terbit = '2011' WHERE id_buku = '99991'";
            stmt.executeUpdate(sql);*/

            //Delete
            /*System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "DELETE FROM buku_pengarang " +
                    "WHERE id_buku = '99991'";
            stmt.executeUpdate(sql);*/

            //Select
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String query ="SELECT id, id_buku, edisi, tahun_terbit FROM buku_pengarang";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println();
            System.out.println("ID, ID Buku, Edisi, Tahun Terbit:");
            while (rs.next()) {
                String id = rs.getString("id");
                String idbuku = rs.getString("id_buku");
                String edisi = rs.getString("edisi");
                String thnte = rs.getString("tahun_terbit");;
                System.out.println(id + "  " + idbuku + "   " + edisi + "  " + "  " + thnte);
            }
            System.out.println();

        } catch (ClassNotFoundException e) {
            System.err.println("Proses Failed : " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Connection Failed : " + e.getMessage() + " " + e.getSQLState());
        } catch (Exception e) {
            System.err.println("Unknown Exception : " + e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
