package com.sena.sigce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="comite")
public class Comite {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Com;

    @Column(name="fecha_Com")
    private String fecha_Com;

    @Column(name="hora_Com")
    private String hora_Com;

    //Relaciones
    @ManyToOne
    @JoinColumn(name="FK_id_Fun",nullable = false)
    private Funcionario fun;

    //Constructores
    public Comite() {
    }

    public Comite(Integer id_Com, String fecha_Com, String hora_Com, Funcionario fun) {
        this.id_Com = id_Com;
        this.fecha_Com = fecha_Com;
        this.hora_Com = hora_Com;
        this.fun = fun;
    }

    //Getters and Setters
    public Integer getId_Com() {
        return id_Com;
    }

    public void setId_Com(Integer id_Com) {
        this.id_Com = id_Com;
    }

    public String getFecha_Com() {
        return fecha_Com;
    }

    public void setFecha_Com(String fecha_Com) {
        this.fecha_Com = fecha_Com;
    }

    public String getHora_Com() {
        return hora_Com;
    }

    public void setHora_Com(String hora_Com) {
        this.hora_Com = hora_Com;
    }

    public Funcionario getFun() {
        return fun;
    }

    public void setFun(Funcionario fun) {
        this.fun = fun;
    }

}

