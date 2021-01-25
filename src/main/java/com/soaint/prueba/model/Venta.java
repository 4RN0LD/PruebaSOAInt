package com.soaint.prueba.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Venta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenta;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false, foreignKey = @ForeignKey(name = "cliente_venta"))
    private Cliente cliente;

    @Column()
    private LocalDate fecha;

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Venta{");
        sb.append("idVenta=").append(idVenta);
        sb.append(", cliente=").append(cliente);
        sb.append(", fecha=").append(fecha);
        sb.append('}');
        return sb.toString();
    }
}
