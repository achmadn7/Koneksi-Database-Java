package id.ac.uad.tif;

import java.sql.*;

/**
 * Created by an on 03/10/15.
 */
public class KoneksiBuku {

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
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            System.out.println("Connected database successfully...");

            //Insert
            /*System.out.println("Inserting records into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO buku " +
                    "VALUES ('99991', 'A', 'Kimia dalam Kehidupan ', 58000)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO buku " +
                    "VALUES ('99995', 'C', 'Petualangan si Bolang', 43000)";
            stmt.executeUpdate(sql);*/

            //Update
            /*System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "UPDATE buku " +
                    "SET id_kategori = 'B' WHERE id_buku = '99991'";
            stmt.executeUpdate(sql);*/

            //Delete
            /*System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "DELETE FROM buku " +
                    "WHERE id_buku = '99991'";
            stmt.executeUpdate(sql);*/

            //Select
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String query ="SELECT id_buku, id_kategori, judul, harga FROM buku";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println();
            System.out.println("ID Buku, ID Kategori, Judul, Harga:");
            while (rs.next()) {
                String idbuku = rs.getString("id_buku");
                String idkat = rs.getString("id_kategori");
                String judul = rs.getString("judul");
                int harga = rs.getInt("harga");
                System.out.println(idbuku + "  " + idkat + "   " + judul + "  " + "  " + harga);
            }
            System.out.println();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            System.err.println("ProsesFailed : " + e.getMessage());
        } catch(Exception e){
            System.err.println("Unknown Exception : " + e.getMessage());
        } finally{
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
        }
    }
}
