package com.foro.Api.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


import java.util.List;


@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usu_id;

    private String nombre;

    @NotBlank
    @Email
    @Column(unique = true)
    private String correo;


    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Perfil.class)
    @JoinTable(
            name = "usuario_perfil",
            joinColumns = @JoinColumn(name = "usu_id"),
            inverseJoinColumns = @JoinColumn(name = "per_id")
    )
    private List<Perfil> listaPerfiles;

    // relaciones.

    // topico
    @OneToMany(targetEntity = Topico.class, fetch = FetchType.EAGER, mappedBy = "top_autor")
    private List<Topico> usu_topico;

    // respuesta
    @OneToMany(targetEntity = Respuesta.class, fetch = FetchType.EAGER, mappedBy = "res_autor")
    private List<Respuesta> listaRespuestas;

    public Usuario(){}

    public Long getUsu_id() {
        return usu_id;
    }

    public void setUsu_id(Long usu_id) {
        this.usu_id = usu_id;
    }

    public List<Respuesta> getListaRespuestas() {
        return listaRespuestas;
    }

    public void setListaRespuestas(List<Respuesta> listaRespuestas) {
        this.listaRespuestas = listaRespuestas;
    }

    public List<Topico> getUsu_topico() {
        return usu_topico;
    }

    public void setUsu_topico(List<Topico> usu_topico) {
        this.usu_topico = usu_topico;
    }

    public List<Perfil> getListaPerfiles() {
        return listaPerfiles;
    }

    public void setListaPerfiles(List<Perfil> listaPerfiles) {
        this.listaPerfiles = listaPerfiles;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }

    public @NotBlank @Email String getCorreo() {
        return correo;
    }

    public void setCorreo(@NotBlank @Email String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    /*
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USUARIO"));
    }

    @Override
    public String getUsername() {
        return correo;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Usuario(){

    }

 */
}
