package com.campusjaider.seguimientoenvios.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @Column(length = 20)
    private String dniCliente;
    @Column(length = 100, nullable = false)
    private String nombreCliente;
    @Column(length = 100, nullable = false)
    private String apellidoString;
    @Column(length = 20, nullable = false)
    private String telefonoCliente;
    @Column(length = 100, nullable = false)
    private String emailCliente;

    @OneToOne(mappedBy = "cliente", cascade =  CascadeType.ALL, orphanRemoval = true,fetch =  FetchType.LAZY)
    @JsonManagedReference
    private Direccion direccionCliente;

    @OneToMany(mappedBy = "remitente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Paquete> paquetesEnviados = new ArrayList<>();

    @OneToMany(mappedBy = "destinatario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Paquete> paquetesRecibidos = new ArrayList<>();


    public Cliente() {
    }

    public Cliente(String dniCliente, String nombreCliente, String apellidoString, String telefonoCliente, String emailCliente, Direccion direccionCliente, List<Paquete> paquetesEnviados, List<Paquete> paquetesRecibidos) {
        this.dniCliente = dniCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoString = apellidoString;
        this.telefonoCliente = telefonoCliente;
        this.emailCliente = emailCliente;
        this.direccionCliente = direccionCliente;
        this.paquetesEnviados = paquetesEnviados;
        this.paquetesRecibidos = paquetesRecibidos;
    }

    public String getDniCliente() {
        return this.dniCliente;
    }

    public void setDniCliente(String dniCliente) {
        this.dniCliente = dniCliente;
    }

    public String getNombreCliente() {
        return this.nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoString() {
        return this.apellidoString;
    }

    public void setApellidoString(String apellidoString) {
        this.apellidoString = apellidoString;
    }

    public String getTelefonoCliente() {
        return this.telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return this.emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Direccion getDireccionCliente() {
        return this.direccionCliente;
    }

    public void setDireccionCliente(Direccion direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public List<Paquete> getPaquetesEnviados() {
        return this.paquetesEnviados;
    }

    public void setPaquetesEnviados(List<Paquete> paquetesEnviados) {
        this.paquetesEnviados = paquetesEnviados;
    }

    public List<Paquete> getPaquetesRecibidos() {
        return this.paquetesRecibidos;
    }

    public void setPaquetesRecibidos(List<Paquete> paquetesRecibidos) {
        this.paquetesRecibidos = paquetesRecibidos;
    }

    @Override
    public String toString() {
        return "{" +
            " dniCliente='" + getDniCliente() + "'" +
            ", nombreCliente='" + getNombreCliente() + "'" +
            ", apellidoString='" + getApellidoString() + "'" +
            ", telefonoCliente='" + getTelefonoCliente() + "'" +
            ", emailCliente='" + getEmailCliente() + "'" +
            ", direccionCliente='" + getDireccionCliente() + "'" +
            ", paquetesEnviados='" + getPaquetesEnviados() + "'" +
            ", paquetesRecibidos='" + getPaquetesRecibidos() + "'" +
            "}";
    }
    
  
}
