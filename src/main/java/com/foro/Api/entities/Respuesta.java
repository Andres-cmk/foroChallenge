package com.foro.Api.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long res_id;

    @Column(nullable = false, length = 200)
    private String res_mensaje;


    @Temporal(TemporalType.DATE)
    private Date res_fechaDeCreacion;

    private String solucion;

    //relaciones

    //autor - usuario
    @ManyToOne(targetEntity = Usuario.class)
    @JoinColumn(name = "res_usu_id")
    private Usuario res_autor;

    // topico
    @ManyToOne(targetEntity = Topico.class)
    @JoinColumn(name = "res_top_id")
    private Topico res_topico;


    public Respuesta(){}


    public Long getRes_id() {
        return res_id;
    }

    public void setRes_id(Long res_id) {
        this.res_id = res_id;
    }

    public Topico getRes_topico() {
        return res_topico;
    }

    public void setRes_topico(Topico res_topico) {
        this.res_topico = res_topico;
    }

    public Usuario getRes_autor() {
        return res_autor;
    }

    public void setRes_autor(Usuario res_autor) {
        this.res_autor = res_autor;
    }

    public String getSolucion() {
        return solucion;
    }

    public void setSolucion(String solucion) {
        this.solucion = solucion;
    }

    public Date getRes_fechaDeCreacion() {
        return res_fechaDeCreacion;
    }

    public void setRes_fechaDeCreacion(Date res_fechaDeCreacion) {
        this.res_fechaDeCreacion = res_fechaDeCreacion;
    }

    public String getRes_mensaje() {
        return res_mensaje;
    }

    public void setRes_mensaje(String res_mensaje) {
        this.res_mensaje = res_mensaje;
    }
}
