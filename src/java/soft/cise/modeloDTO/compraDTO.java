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
public class compraDTO {

    private int id1;
    private int id2;
    private int id3;
    private int id4;
    private int id5;

    private int cantidad1;
    private int cantidad2;
    private int cantidad3;
    private int cantidad4;
    private int cantidad5;

    private String nombreCompleto;
    private String dni;
    private String telefono1;
    private String telefono2;
    private String departamento;
    private String provincia;
    private String distrito;
    private String direccion;
    private double totalProducto;
    private double costoEnvio;
    private double IGV;
    private double totalPagar;
    private String modoPago;
    private String cuenta;
    private int idUsuario;
    private String fechaVenta;
    private String estado;
    private String destino;
    private int idVenta;
    private String fechaEntrega;

    public compraDTO() {
    }

    public compraDTO(String nombreCompleto, String direccion, double totalPagar, String fechaVenta, String estado, String destino, int idVenta) {
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.totalPagar = totalPagar;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
        this.destino = destino;
        this.idVenta = idVenta;

    }

    public compraDTO(String nombreCompleto, String direccion, double totalPagar, String fechaVenta, String estado, String destino, int idVenta, String fechaEntrega) {
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.totalPagar = totalPagar;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
        this.destino = destino;
        this.idVenta = idVenta;
        this.fechaEntrega = fechaEntrega;
    }

    public compraDTO(String nombreCompleto, String direccion, double costoEnvio, double IGV, double totalPagar, String cuenta, String fechaVenta, String estado, String destino, int idVenta, String fechaEntrega) {
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.costoEnvio = costoEnvio;
        this.IGV = IGV;
        this.totalPagar = totalPagar;
        this.cuenta = cuenta;
        this.fechaVenta = fechaVenta;
        this.estado = estado;
        this.destino = destino;
        this.idVenta = idVenta;
        this.fechaEntrega = fechaEntrega;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public int getId3() {
        return id3;
    }

    public void setId3(int id3) {
        this.id3 = id3;
    }

    public int getId4() {
        return id4;
    }

    public void setId4(int id4) {
        this.id4 = id4;
    }

    public int getId5() {
        return id5;
    }

    public void setId5(int id5) {
        this.id5 = id5;
    }

    public int getCantidad1() {
        return cantidad1;
    }

    public void setCantidad1(int cantidad1) {
        this.cantidad1 = cantidad1;
    }

    public int getCantidad2() {
        return cantidad2;
    }

    public void setCantidad2(int cantidad2) {
        this.cantidad2 = cantidad2;
    }

    public int getCantidad3() {
        return cantidad3;
    }

    public void setCantidad3(int cantidad3) {
        this.cantidad3 = cantidad3;
    }

    public int getCantidad4() {
        return cantidad4;
    }

    public void setCantidad4(int cantidad4) {
        this.cantidad4 = cantidad4;
    }

    public int getCantidad5() {
        return cantidad5;
    }

    public void setCantidad5(int cantidad5) {
        this.cantidad5 = cantidad5;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public double getTotalProducto() {
        return totalProducto;
    }

    public void setTotalProducto(double totalProducto) {
        this.totalProducto = totalProducto;
    }

    public double getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(double costoEnvio) {
        this.costoEnvio = costoEnvio;
    }

    public double getIGV() {
        return IGV;
    }

    public void setIGV(double IGV) {
        this.IGV = IGV;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

    public String getModoPago() {
        return modoPago;
    }

    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

}
