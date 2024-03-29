package com.campusjaider.seguimientoenvios.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "paquete")
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaquete;

    private Double peso;

    @Enumerated(EnumType.STRING)
    private TamanoPaquete tamano;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "remitente")
    private Cliente remitente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destinatario")
    private Cliente destinatario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "paquete_ruta", joinColumns = { @JoinColumn(name = "id_ruta") }, inverseJoinColumns = {
            @JoinColumn(name = "id_paquete") })
    @JsonIgnore
    private List<Ruta> rutas;

    public Paquete() {
    }

    public Paquete(Long idPaquete, Double peso, TamanoPaquete tamano, Cliente remitente, Cliente destinatario) {
        this.idPaquete = idPaquete;
        this.peso = peso;
        this.tamano = tamano;
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public Long getIdPaquete() {
        return this.idPaquete;
    }

    public void setIdPaquete(Long idPaquete) {
        this.idPaquete = idPaquete;
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public TamanoPaquete getTamano() {
        return this.tamano;
    }

    public void setTamano(TamanoPaquete tamano) {
        this.tamano = tamano;
    }

    public Cliente getRemitente() {
        return this.remitente;
    }

    public void setRemitente(Cliente remitente) {
        this.remitente = remitente;
    }

    public Cliente getDestinatario() {
        return this.destinatario;
    }

    public void setDestinatario(Cliente destinatario) {
        this.destinatario = destinatario;
    }

    public List<Ruta> geRutas(){
        return this.rutas;
    }

    public void addRuta(Ruta ruta){
        this.rutas.add(ruta);
    }

    @Override
    public String toString() {
        return "{" +
                " idPaquete='" + getIdPaquete() + "'" +
                ", peso='" + getPeso() + "'" +
                ", tamano='" + getTamano() + "'" +
                ", remitente='" + getRemitente() + "'" +
                ", destinatario='" + getDestinatario() + "'" +
                "}";
    }

}
