
package org.powerbi.core;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.powerbi.db.ConexionMySQL;
import org.powerbi.model.Maestro;

/**
 *
 * @author mazu1
 */
public class MaestroController {

public int save (Maestro m)throws Exception{
    
    int resultado = 0;
    String sql =    "{call insertarMaestro (?, ? , ? , ? , ? , ? , ? , ? , ?)}";
    
    
        ConexionMySQL connMySQL = new ConexionMySQL();
        
        
        Connection conn = connMySQL.open();
        
        PreparedStatement cstmt = conn.prepareCall(sql);
        
        //Establecemos los valores de lso parametros  de los datos personales 
        //en el orden
        //en que los pide el procedimiento almacenado, comenzando en 1:
        cstmt.setString(1, m.getNombre());
        cstmt.setString(2, m.getApe1());
        cstmt.setString(3, m.getApe2());
        cstmt.setString(4, m.getMatricula());
        cstmt.setString(5, m.getArea());
        cstmt.setString(6, m.getUsuario().getNombreUsuario());
        cstmt.setString(7, m.getUsuario().getContrasenia());
        cstmt.setString(8, m.getUsuario().getRol());
        cstmt.setString(9, m.getUsuario().getCorreo());
        
        
        
        //Ejecutamos el Stored Procedure:
        cstmt.executeUpdate();
        
        
        
        cstmt.close();
        connMySQL.close();
        
    
    return resultado;
}

 public List<Maestro> getAll(String filtro) throws Exception
    {
        //La consulta SQL a ejecutar:
        String sql = "SELECT * FROM maestro";
        
        //Con este objeto nos vamos a conectar a la Base de Datos:
        ConexionMySQL connMySQL = new ConexionMySQL();
        
        //Abrimos la conexión con la Base de Datos:
        Connection conn = connMySQL.open();
        
        //Con este objeto ejecutaremos la consulta:
        PreparedStatement pstmt = conn.prepareStatement(sql);
        
        //Aquí guardaremos los resultados de la consulta:
        ResultSet rs = pstmt.executeQuery();
        
        List<Maestro> maestros = new ArrayList<>();
        
        while (rs.next())
            maestros.add(fill(rs));
        
        rs.close();
        pstmt.close();
        connMySQL.close();
        
        return maestros;
    }
    
    private Maestro fill(ResultSet rs) throws Exception
    {
        Maestro m = new Maestro();
        
        m.setIdMaestro(rs.getInt("idMaestro"));        
        m.setNombre(rs.getString("nombreMaestro"));               
        m.setApe1(rs.getString("primerApe"));
        m.setApe2(rs.getString("segundoApe"));
        m.setArea(rs.getString("area"));
        m.setMatricula(rs.getString("matricula"));
        
        return m;
    }

    
}
