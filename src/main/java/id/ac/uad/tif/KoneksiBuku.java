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

                /*System.out.print("ID Buku: " + idbuku);
                System.out.print(", ID Kategori: " + idkat);
                System.out.print(", Judul: " + judul);
                System.out.print(", Harga: " + harga);*/
            }
            System.out.println();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally{
            //finally block used to close resources
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");


        /*try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Add Class Succes");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/belajardb", "root", "9");

            System.out.println("Connection is now " + (connection.isClosed() ? "Closed" : "Open"));

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO buku (id_buku,id_kategori,judul,harga) VALUES (?,?,?,?)");
            preparedStatement.setString(1, "99995");
            preparedStatement.setString(2, "C");
            preparedStatement.setString(3, "Petualangan si Bolang");
            preparedStatement.setInt(4, 43000);
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
