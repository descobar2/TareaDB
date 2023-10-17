import java.sql.*;

public class ConnectionDB {
    public static void main(String[] args) throws SQLException {
        final String HOST = "proyecto2.ctlvgikixphm.us-east-1.rds.amazonaws.com:3306/Tarea";
        final String DB_URL = String.format("jdbc:mysql://%s", HOST);
        final Connection con = DriverManager.getConnection(DB_URL,"progra","Guate2021+");
        final Statement stmt = con.createStatement();

        //instertDB(con,stmt);

        showTable(con,stmt);
        updateDB(con,stmt);
        System.out.println("\nTabla modificada");
        showTable(con,stmt);

    }
    public static void instertDB(Connection con, Statement stmt){
        try(con; stmt;){ 
            String sql = "INSERT INTO Proveedor (ProveedorID, Nombre, Direccion, Telefono) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,6);
            ps.setString(2, "Allan");
            ps.setString(3, "Villa Nueva");
            ps.setString(4, "24280000");
            ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }        
    }
    public static void updateDB(Connection con, Statement stmt){
        try {
            String sql = "UPDATE Proveedor SET Nombre = ? WHERE ProveedorID = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,"Marvin");
            ps.setInt(2, 5);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void deleteDB(Connection con, Statement stmt){

    }
    public static void showTable(Connection con, Statement stmt){
        try {
            String sql = "SELECT * FROM Tarea.Proveedor;";
            ResultSet rs =stmt.executeQuery(sql);

            while(rs.next()){
                System.out.print(rs.getString("Nombre")+"\t");
                System.out.println(rs.getString("Direccion"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}