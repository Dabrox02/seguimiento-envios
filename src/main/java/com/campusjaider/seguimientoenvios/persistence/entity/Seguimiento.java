package com.campusjaider.seguimientoenvios.persistence.entity;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "seguimiento")
public class Seguimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSeguimiento;

    private EstadoEnvio estadoEnvio;

    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Temporal(TemporalType.TIME)
    private Time hora;
    
    @ManyToOne()
    @JoinColumn(name = "id_paquete")
    private Paquete paquete;


    public Seguimiento() {
    }

    public Seguimiento(Long idSeguimiento, EstadoEnvio estadoEnvio, Date fecha, Time hora, Paquete paquete) {
        this.idSeguimiento = idSeguimiento;
        this.estadoEnvio = estadoEnvio;
        this.fecha = fecha;
        this.hora = hora;
        this.paquete = paquete;
    }

    public Long getIdSeguimiento() {
        return this.idSeguimiento;
    }

    public void setIdSeguimiento(Long idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public EstadoEnvio getEstadoEnvio() {
        return this.estadoEnvio;
    }

    public void setEstadoEnvio(EstadoEnvio estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return this.hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Paquete getPaquete() {
        return this.paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    @Override
    public String toString() {
        return "{" +
            " idSeguimiento='" + getIdSeguimiento() + "'" +
            ", estadoEnvio='" + getEstadoEnvio() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", hora='" + getHora() + "'" +
            ", paquete='" + getPaquete() + "'" +
            "}";
    }
    

}
