/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.modeloDao;

import soft.cise.conexionDB.ConexionBD;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import soft.cise.modeloDTO.usuarioDTO;
import soft.cise.interfaces.OperacionesUsu;

/**
 *
 * @author Alumno
 */
public class usuarioDAO implements OperacionesUsu<usuarioDTO> {

    private static final String sql_usuarioSistema = "{call usuarioSistema(?,?)}";
    private static final String sql_addUsuario = "{call registrarUsuario(?,?,?,?)}";

    private static CallableStatement cts;
    private static ResultSet rs;
    private ConexionBD cn = ConexionBD.conectar();
    
    private void cerrarConexiones(){
        try {
            if(rs!=null)rs.close();
            if(cts!=null)cts.close();
            if(cn!=null)cn.cerrarConexion();
        } catch (Exception e) {
        }
    }

    @Override
    public boolean addUsu(usuarioDTO usuario) {
        boolean result = false;
        try {
            cts=cn.getCon().prepareCall(sql_addUsuario);
            cts.setString(1, usuario.getNombre());
            cts.setString(2, usuario.getCorreo());
            cts.setString(3, usuario.getClave());
            cts.setString(4, usuario.getPerfil());
            if(cts.executeUpdate()>1){
                result = true;
            }
        } catch (Exception e) {
            System.out.println("Error al registrar" + e.getMessage());
            e.printStackTrace();
        }finally{
            cerrarConexiones();
        }
        return result;
    }

    @Override
    public String recuperarUsu(usuarioDTO t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public usuarioDTO login(usuarioDTO usuario) {
        usuarioDTO usu = null;
        try {
            cts = cn.getCon().prepareCall(sql_usuarioSistema);
            cts.setString(1, usuario.getCorreo());
            cts.setString(2, usuario.getClave());
            rs = cts.executeQuery();
            while(rs.next()){
                usu = new usuarioDTO(rs.getInt(1), 
                                    rs.getString(2),
                                    rs.getString(3),
                                    rs.getString(4),
                                    rs.getString(5),
                                    rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println("Error al realizar validacion" + e.getMessage());
            e.printStackTrace();
        }finally{
            cerrarConexiones();
        }
        
        return usu;
    }



}
