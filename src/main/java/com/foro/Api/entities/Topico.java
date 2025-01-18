package com.foro.Api.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long top_id;

    @Column(nullable = false, length = 80)
    private String titulo;

    @Temporal(TemporalType.DATE)
    private Date top_fechaDeCreacion;


    private String top_status;

    // relaciones.

    // respuestas
    @OneToMany(targetEntity = Respuesta.class, fetch = FetchType.LAZY, mappedBy = "res_topico")
    private List<Respuesta> top_respuesta;

    //usuario
    @ManyToOne(targetEntity = Usuario.class)
    private Usuario top_autor;

    // curso
    @ManyToOne(targetEntity = Curso.class)
    private Curso top_curso;

    public Topico() {}

    public Long getTop_id() {
        return top_id;
    }

    public void setTop_id(Long top_id) {
        this.top_id = top_id;
    }

    public Curso getTop_curso() {
        return top_curso;
    }

    public void setTop_curso(Curso top_curso) {
        this.top_curso = top_curso;
    }

    public Usuario getTop_autor() {
        return top_autor;
    }

    public void setTop_autor(Usuario top_autor) {
        this.top_autor = top_autor;
    }

    public List<Respuesta> getTop_respuesta() {
        return top_respuesta;
    }

    public void setTop_respuesta(List<Respuesta> top_respuesta) {
        this.top_respuesta = top_respuesta;
    }

    public String getTop_status() {
        return top_status;
    }

    public void setTop_status(String top_status) {
        this.top_status = top_status;
    }

    public Date getTop_fechaDeCreacion() {
        return top_fechaDeCreacion;
    }

    public void setTop_fechaDeCreacion(Date top_fechaDeCreacion) {
        this.top_fechaDeCreacion = top_fechaDeCreacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
