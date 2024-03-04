package com.campusjaider.seguimientoenvios.persistence.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "transportista")
public class Transportista {

    @Id
    @Column(length = 20)
    private String nitTransportista;
    
    @Column(length = 100)
    private String razonSocial;
    @Column(length = 100)
    private String emailTransportista;
    @Column(length = 20)
    private String telefonoTransportista;

    @OneToMany(mappedBy = "transportista", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Ruta> rutas;


    public Transportista() {
    }

    public Transportista(String nitTransportista, String razonSocial, String emailTransportista, String telefonoTransportista, List<Ruta> rutas) {
        this.nitTransportista = nitTransportista;
        this.razonSocial = razonSocial;
        this.emailTransportista = emailTransportista;
        this.telefonoTransportista = telefonoTransportista;
        this.rutas = rutas;
    }

    public String getNitTransportista() {
        return this.nitTransportista;
    }

    public void setNitTransportista(String nitTransportista) {
        this.nitTransportista = nitTransportista;
    }

    public String getRazonSocial() {
        return this.razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEmailTransportista() {
        return this.emailTransportista;
    }

    public void setEmailTransportista(String emailTransportista) {
        this.emailTransportista = emailTransportista;
    }

    public String getTelefonoTransportista() {
        return this.telefonoTransportista;
    }

    public void setTelefonoTransportista(String telefonoTransportista) {
        this.telefonoTransportista = telefonoTransportista;
    }

    public List<Ruta> getRutas() {
        return this.rutas;
    }

    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
    }

    @Override
    public String toString() {
        return "{" +
            " nitTransportista='" + getNitTransportista() + "'" +
            ", razonSocial='" + getRazonSocial() + "'" +
            ", emailTransportista='" + getEmailTransportista() + "'" +
            ", telefonoTransportista='" + getTelefonoTransportista() + "'" +
            ", rutas='" + getRutas() + "'" +
            "}";
    }
    

}
