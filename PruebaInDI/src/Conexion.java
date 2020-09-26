
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conexion {
	    private static final String URL = "jdbc:mysql://localhost:3306/pruebaindi";
	    private static final String USUARIO = "root";
	    private static final String CLAVE = "123456";
	    
	    Connection conexion ;
	   
	    //Constructor
	    public Conexion() {
	    	conectar();
	    }
	    
	    /**
	     * Conectar al bbdd
	     * @return
	     */
	    public Connection conectar() {
	        
	        try {
	        
	            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
	            System.out.println("Conexión OK");

	        } catch (SQLException e) {
	            System.out.println("Error en la conexión");
	            e.printStackTrace();
	        }
	        
	        return conexion;
	    }

	    
	    /**
	     * Método que busca datos en el bbdd pasandole dos parámetros
	     * @param user
	     * @param passw
	     * @return
	     */
	    public Acceso buscarDatos (String user,String passw) {
	    
	    	
	    	Acceso acceso = null;
	    	
			try {
				String sql = "Select * from pruebaindi where username=? and password=?";
				PreparedStatement ps = conexion.prepareStatement(sql);
				ps.setString(1,user);
				ps.setString(2,passw);
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					acceso = new Acceso(rs.getString(1),rs.getString(2));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error en obtener usuario");
			}
	    	
	    	return acceso ;
	    }

		
	   
	}
    
