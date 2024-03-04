package com.campusjaider.seguimientoenvios.persistence.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import jakarta.persistence.OneToMany;
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

    @ManyToOne()
    @JoinColumn(name = "remitente")
    @JsonManagedReference("remitente-paquete")
    private Cliente remitente;

    @ManyToOne()
    @JoinColumn(name = "destinatario")
    @JsonManagedReference("destinatario-paquete")
    private Cliente destinatario;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "paquete_ruta",
        joinColumns = {@JoinColumn(name = "id_ruta")},
        inverseJoinColumns = {@JoinColumn(name = "id_paquete")}
    )
    @JsonBackReference
    private List<Ruta> rutas;

    @OneToMany(mappedBy = "paquete", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Seguimiento> seguimientos;


    public Paquete() {
    }

    public Paquete(Long idPaquete, Double peso, TamanoPaquete tamano, Cliente remitente, Cliente destinatario, List<Ruta> rutas, List<Seguimiento> seguimientos) {
        this.idPaquete = idPaquete;
        this.peso = peso;
        this.tamano = tamano;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.rutas = rutas;
        this.seguimientos = seguimientos;
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

    public List<Ruta> getRutas() {
        return this.rutas;
    }

    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
    }

    public List<Seguimiento> getSeguimientos() {
        return this.seguimientos;
    }

    public void setSeguimientos(List<Seguimiento> seguimientos) {
        this.seguimientos = seguimientos;
    }

    @Override
    public String toString() {
        return "{" +
            " idPaquete='" + getIdPaquete() + "'" +
            ", peso='" + getPeso() + "'" +
            ", tamano='" + getTamano() + "'" +
            ", remitente='" + getRemitente() + "'" +
            ", destinatario='" + getDestinatario() + "'" +
            ", rutas='" + getRutas() + "'" +
            ", seguimientos='" + getSeguimientos() + "'" +
            "}";
    }

}
