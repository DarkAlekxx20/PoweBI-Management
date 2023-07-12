package org.powerbi.core;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.powerbi.db.ConexionMySQL;
import org.powerbi.model.User;
/**
 * @author Alex SP
 */
public class UserController {
    public User login(String username, String password) throws Exception{
        String sql = "SELECT * FROM usuario WHERE nombreUsuario = ? AND contrasenia = ?;";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareCall(sql);
        ResultSet rs = null;
        pstmt.setString(1,username);
        pstmt.setString(2,password);
        rs = pstmt.executeQuery();
        User u = null;
        if(rs.next()){
            u = (fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return u;
    }
    
    public List<User> getAll(String filtro) throws Exception{
        String sql = "SELECT * FROM usuario;";
        ConexionMySQL connMySQL = new ConexionMySQL();
        Connection conn = connMySQL.open();
        PreparedStatement pstmt = conn.prepareCall(sql);
        ResultSet rs = pstmt.executeQuery();
        List<User> users = new ArrayList<>();
        while(rs.next()){
            users.add(fill(rs));
        }
        rs.close();
        pstmt.close();
        connMySQL.close();
        return users;
    }
    
    private User fill(ResultSet rs) throws Exception{
        User u = new User();
        u.setIdUsuario(rs.getInt("idUsuario"));
        u.setNombreUsuario(rs.getString("nombreUsuario"));
        u.setContrasenia(rs.getString("contrasenia"));
        u.setCorreo(rs.getString("correo"));
        u.setRol(rs.getString("rol"));
        return u;
    }
}