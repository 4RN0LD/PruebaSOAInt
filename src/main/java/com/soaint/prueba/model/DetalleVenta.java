package com.soaint.prueba.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DetalleVenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleVenta;

    @ManyToOne
    @JoinColumn(name = "idVenta", nullable = false, foreignKey = @ForeignKey(name = "detalle_venta"))
    private Venta venta;

    @ManyToOne
    @JoinColumn(name = "idProducto", nullable = false, foreignKey = @ForeignKey(name = "detalle_producto"))
    private Producto producto;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DetalleVenta{");
        sb.append("idDetalleVenta=").append(idDetalleVenta);
        sb.append(", venta=").append(venta);
        sb.append(", producto=").append(producto);
        sb.append('}');
        return sb.toString();
    }

    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
