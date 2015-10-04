package id.ac.uad.tif;

import java.sql.*;

/**
 * Created by an on 03/10/15.
 */
public class KoneksiKategori {

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

            String sql = "INSERT INTO kategori " +
                    "VALUES ('B', 'Fashion')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO kategori " +
                    "VALUES ('C', 'Novel')";
            stmt.executeUpdate(sql);*/

            //Update
            /*System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "UPDATE kategori " +
                    "SET kategori = 'Pariwisata' WHERE id_kategori = 'C'";
            stmt.executeUpdate(sql);*/

            //Delete
            /*System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "DELETE FROM kategori " +
                    "WHERE id_kategori = 'C'";
            stmt.executeUpdate(sql);*/

            //Select
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String query ="SELECT id_kategori, kategori FROM kategori";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println();
            System.out.println("ID Kategori, Kategori:");
            while (rs.next()) {
                String idkat = rs.getString("id_kategori");
                String kat = rs.getString("kategori");
                System.out.println(idkat + "  " + kat);
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
