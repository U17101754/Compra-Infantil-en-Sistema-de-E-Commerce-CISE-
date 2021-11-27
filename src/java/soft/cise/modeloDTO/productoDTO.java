/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft.cise.modeloDTO;

import java.io.InputStream;

/**
 *
 * @author SISTEMA
 */
public class productoDTO {

    private int idProducto;
    private String categoria;

    private String nombProducto;
    private int cantidad;
    private String moneda;
    private double precioCompra;
    private double tipoCambio;
    private double precioVenta;
    private double IGV;
    private String proveedor;
    private String talla1;
    private String talla2;
    private String talla3;
    private String talla4;
    private int idCategoria;
    private String marca;
    private String descripcion;
    private InputStream img;
    private int idVenta;
    private double totalProducto;

    public productoDTO() {
    }

    public productoDTO(String categoria) {
        this.categoria = categoria;
    }

    public productoDTO(int idProducto, String categoria, String nombProducto, int cantidad, String moneda, double precioCompra, double tipoCambio, double precioVenta, double IGV, String proveedor, String talla1, String talla2, String talla3, String talla4, String marca, String descripcion) {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.nombProducto = nombProducto;
        this.cantidad = cantidad;
        this.moneda = moneda;
        this.precioCompra = precioCompra;
        this.tipoCambio = tipoCambio;
        this.precioVenta = precioVenta;
        this.IGV = IGV;
        this.proveedor = proveedor;
        this.talla1 = talla1;
        this.talla2 = talla2;
        this.talla3 = talla3;
        this.talla4 = talla4;
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public productoDTO(int idProducto, String categoria, String nombProducto, int cantidad, double precioCompra, double precioVenta, String marca, String descripcion) {
        this.idProducto = idProducto;
        this.categoria = categoria;
        this.nombProducto = nombProducto;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.marca = marca;
        this.descripcion = descripcion;
    }

    public productoDTO(int idProducto, String nombProducto, int cantidad, double IGV, String descripcion, int idVenta, double totalProducto) {
        this.idProducto = idProducto;
        this.nombProducto = nombProducto;
        this.cantidad = cantidad;
        this.IGV = IGV;
        this.descripcion = descripcion;
        this.idVenta = idVenta;
        this.totalProducto = totalProducto;
    }
    
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombProducto() {
        return nombProducto;
    }

    public void setNombProducto(String nombProducto) {
        this.nombProducto = nombProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(double tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getIGV() {
        return IGV;
    }

    public void setIGV(double IGV) {
        this.IGV = IGV;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getTalla1() {
        return talla1;
    }

    public void setTalla1(String talla1) {
        this.talla1 = talla1;
    }

    public String getTalla2() {
        return talla2;
    }

    public void setTalla2(String talla2) {
        this.talla2 = talla2;
    }

    public String getTalla3() {
        return talla3;
    }

    public void setTalla3(String talla3) {
        this.talla3 = talla3;
    }

    public String getTalla4() {
        return talla4;
    }

    public void setTalla4(String talla4) {
        this.talla4 = talla4;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public InputStream getImg() {
        return img;
    }

    public void setImg(InputStream img) {
        this.img = img;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public double getTotalProducto() {
        return totalProducto;
    }

    public void setTotalProducto(double totalProducto) {
        this.totalProducto = totalProducto;
    }
    
    

}
