package com.campusjaider.seguimientoenvios.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ruta")
public class Ruta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRuta;

    @Column(length = 100)
    private String direccionOrigen;
    @Column(length = 100)
    private String direccionDestino;

    @ManyToOne()
    @JoinColumn(name = "nit_transportista")
    @JsonBackReference
    private Transportista transportista;    

    @ManyToMany(mappedBy = "rutas", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Paquete> paquetes;

    public Ruta() {
    }

    public Ruta(Long idRuta, String direccionOrigen, String direccionDestino, Transportista transportista) {
        this.idRuta = idRuta;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.transportista = transportista;
    }

    public Long getIdRuta() {
        return this.idRuta;
    }

    public void setIdRuta(Long idRuta) {
        this.idRuta = idRuta;
    }

    public String getDireccionOrigen() {
        return this.direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDireccionDestino() {
        return this.direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public Transportista getTransportista() {
        return this.transportista;
    }

    public void setTransportista(Transportista transportista) {
        this.transportista = transportista;
    }

    public List<Paquete> getPaquetes() {
        return this.paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    @Override
    public String toString() {
        return "{" +
            " idRuta='" + getIdRuta() + "'" +
            ", direccionOrigen='" + getDireccionOrigen() + "'" +
            ", direccionDestino='" + getDireccionDestino() + "'" +
            ", transportista='" + getTransportista() + "'" +
            "}";
    }


}
