package com.foro.Api.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cur_id;

    @Column(nullable = false, length = 200)
    private String nombre;

    private String cur_categoria;

    // relaciones
    @OneToMany(targetEntity = Topico.class,fetch = FetchType.EAGER, mappedBy = "top_curso")
    private List<Topico> topicos;

    public Curso() {}

    public Long getCur_id() {
        return cur_id;
    }

    public void setCur_id(Long cur_id) {
        this.cur_id = cur_id;
    }

    public String getCur_nombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCur_categoria() {
        return cur_categoria;
    }

    public void setCur_categoria(String cur_categoria) {
        this.cur_categoria = cur_categoria;
    }

    public List<Topico> getTopicos() {
        return topicos;
    }

    public void setTopicos(List<Topico> topicos) {
        this.topicos = topicos;
    }
}
