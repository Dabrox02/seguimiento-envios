package com.campusjaider.seguimientoenvios.persistence.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "direccion")
public class Direccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDireccion;

    @Column(length = 50, nullable = false)
    private String calle;
    @Column(length = 50, nullable = false)
    private String ciudad;
    @Column(length = 50, nullable = false)
    private String estado;
    @Column(length = 20, nullable = false)
    private String codigoPostal;   


    public Direccion() {
    }

    public Direccion(Long idDireccion, String calle, String ciudad, String estado, String codigoPostal) {
        this.idDireccion = idDireccion;
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    public Long getIdDireccion() {
        return this.idDireccion;
    }

    public void setIdDireccion(Long idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getCalle() {
        return this.calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return "{" +
            " idDireccion='" + getIdDireccion() + "'" +
            ", calle='" + getCalle() + "'" +
            ", ciudad='" + getCiudad() + "'" +
            ", estado='" + getEstado() + "'" +
            ", codigoPostal='" + getCodigoPostal() + "'" +
            "}";
    }
    
}
