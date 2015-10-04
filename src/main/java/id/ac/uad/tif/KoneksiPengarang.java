package id.ac.uad.tif;

import java.io.IOException;
import java.sql.*;

/**
 * Created by an on 03/10/15.
 */
public class KoneksiPengarang {

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

            String sql = "INSERT INTO pengarang " +
                    "VALUES ('137-000', 'Andi P', 'Bongkelan III Sleman')";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO pengarang " +
                    "VALUES ('125-989', 'Dina L', 'Syuhada XI Wonosari')";
            stmt.executeUpdate(sql);*/

            //Update
            /*System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "UPDATE pengarang " +
                    "SET alamat_p = 'Syuhada XI Magelang' WHERE id = '125-989'";
            stmt.executeUpdate(sql);*/

            //Delete
            /*System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "DELETE FROM pengarang " +
                    "WHERE id = '125-989'";
            stmt.executeUpdate(sql);*/

            //Select
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String query ="SELECT id, nama_p, alamat_p FROM pengarang";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println();
            System.out.println("ID, Nama, Alamat:");
            while (rs.next()) {
                String id = rs.getString("id");
                String nama = rs.getString("nama_p");
                String alamat = rs.getString("alamat_p");
                System.out.println(id + "  " + nama + "   " + alamat);

                /*System.out.print("ID: " + id);
                System.out.print(", Nama: " + nama);
                System.out.print(", Alamat: " + alamat);*/
            }
            System.out.println();



        } catch (ClassNotFoundException e) {
            System.err.println("Proses Failed : " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Connection Failed : " + e.getMessage() + " " + e.getSQLState());
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
