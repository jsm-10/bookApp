
package estancias.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
    
    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    
    private final String USER = "root";
    private final String PASSWORD = "4f44";
    private final String DATABASE = "estancias_exterior";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    
    protected void conectarBase()throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
            
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }
    protected void desconectarBase () throws SQLException{
        try {
            if (resultado != null){
                resultado.close();   
            }
            if (sentencia != null) {
                sentencia.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    protected void insertarModificarEliminar (String sql) throws Exception{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            conexion.setAutoCommit(false);
            conexion.rollback();
            throw ex;
        }finally{
            desconectarBase();
        }
    }
    protected void consultarBase (String sql) throws Exception{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }
}
