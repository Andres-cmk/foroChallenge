package com.foro.Api.entities;

import jakarta.persistence.*;


@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long per_id;

    @Column(nullable = false, length = 50)
    private String categoria;

    public Perfil(){}


    public Long getPer_id() {
        return per_id;
    }

    public void setPer_id(Long per_id) {
        this.per_id = per_id;
    }

    public String getPer_categoria() {
        return categoria;
    }

    public void setPer_categoria(String per_categoria) {
        this.categoria = per_categoria;
    }
}
