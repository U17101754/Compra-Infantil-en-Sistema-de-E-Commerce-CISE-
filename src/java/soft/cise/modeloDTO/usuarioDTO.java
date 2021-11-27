/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.modeloDTO;

/**
 *
 * @author SISTEMA
 */
public class usuarioDTO {

    private int id;
    private String nombre;
    private String correo;
    private String clave;
    private String perfil;
    private int estado;

    public usuarioDTO() {
    }

    public usuarioDTO(String correo, String clave) {
        this.correo = correo;
        this.clave = clave;
    }

    public usuarioDTO(String nombre, String correo, String clave, String perfil) {
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.perfil = perfil;
    }
    
    public usuarioDTO(int id, String nombre, String correo, String clave, String perfil, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.clave = clave;
        this.perfil = perfil;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    

}
