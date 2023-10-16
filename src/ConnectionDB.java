import java.sql.*;

public class ConnectionDB {
    public static void main(String[] args) throws SQLException {
        final String HOST = "proyecto2.ctlvgikixphm.us-east-1.rds.amazonaws.com:3306/Tarea";
        final String DB_URL = String.format("jdbc:mysql://%s", HOST);
        final Connection con = DriverManager.getConnection(DB_URL,"progra","Guate2021+");

        try(con; Statement stmt = con.createStatement();){
            String sql = "SELECT Nombre FROM Tarea.Proveedor;";
            ResultSet rs =stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("Nombre"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}