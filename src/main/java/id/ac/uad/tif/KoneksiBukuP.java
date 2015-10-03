package id.ac.uad.tif;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Add Class Succes");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/belajardb", "root", "9");

            System.out.println("Connection is now " + (connection.isClosed() ? "Closed" : "Open"));

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO buku_pengarang (id,id_buku,edisi,tahun_terbit) VALUES (?,?,?,?)");
            preparedStatement.setString(1, "125-989");
            preparedStatement.setString(2, "99991");
            preparedStatement.setString(3, "2");
            preparedStatement.setString(4, "2011");
            int affectedRow = preparedStatement.executeUpdate();
            System.out.println("Success Execute Update, Row Affected : " + affectedRow);


        } catch (ClassNotFoundException e) {
            System.err.println("Add Failed : " + e.getMessage());

        } catch (SQLException e) {
            System.err.println("Connection Failed : " + e.getMessage() + " " + e.getSQLState());

        } catch (Exception e) {
            System.err.println("Unknown Exception : " + e.getMessage());
        }*/
    }
}
