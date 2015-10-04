package id.ac.uad.tif;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by an on 04/10/15.
 */
public class MainApp {

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

            //View Join
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String query ="SELECT buku.id_buku, buku.judul, buku_pengarang.edisi, buku_pengarang.tahun_terbit" + " FROM buku, buku_pengarang" + " WHERE buku.id_buku = buku_pengarang.id_buku";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println();
            System.out.println("ID Buku, Judul, Edisi, Tahun Terbit:");
            while (rs.next()) {
                String idbuku = rs.getString("id_buku");
                String jud = rs.getString("judul");
                String edsi = rs.getString("edisi");
                String thnte = rs.getString("tahun_terbit");
                System.out.println(idbuku + "  " + jud + "   " + edsi + "  " + thnte);

            }
            System.out.println();
        } catch (ClassNotFoundException e) {
            System.err.println("Join Failed : "+e.getMessage());
        } catch (SQLException e) {
            System.err.println("Connection Failed : " + e.getMessage() + " " +e.getSQLState());
        } catch (Exception e) {
            System.err.println("Unknown Exception : "+e.getMessage());
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
