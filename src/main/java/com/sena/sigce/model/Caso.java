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
@Table(name="caso")
public class Caso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_Caso;

    @Column(name="desc_Cas")
    private String desc_Cas;

    @Column(name="comp_Cas")
    private String comp_Cas;

    //Relaciones
    @ManyToOne
    @JoinColumn(name="Fk_id_Cit",nullable = false)
    private Citacion citacion;

    @ManyToOne
    @JoinColumn(name="FK_id_Tpd",nullable = false)
    private TipoDecision tipoDecision;

    @ManyToOne
    @JoinColumn(name="FK_id_Com",nullable = false)
    private Comite comite;

    //Constructores
    public Caso() {
    }

    public Caso(Integer id_Caso, String desc_Cas, String comp_Cas, Citacion citacion, TipoDecision tipoDecision,
            Comite comite) {
        this.id_Caso = id_Caso;
        this.desc_Cas = desc_Cas;
        this.comp_Cas = comp_Cas;
        this.citacion = citacion;
        this.tipoDecision = tipoDecision;
        this.comite = comite;
    }

    //Getters and Setters
    public Integer getId_Caso() {
        return id_Caso;
    }

    public void setId_Caso(Integer id_Caso) {
        this.id_Caso = id_Caso;
    }

    public String getDesc_Cas() {
        return desc_Cas;
    }

    public void setDesc_Cas(String desc_Cas) {
        this.desc_Cas = desc_Cas;
    }

    public String getComp_Cas() {
        return comp_Cas;
    }

    public void setComp_Cas(String comp_Cas) {
        this.comp_Cas = comp_Cas;
    }

    public Citacion getCitacion() {
        return citacion;
    }

    public void setCitacion(Citacion citacion) {
        this.citacion = citacion;
    }

    public TipoDecision getTipoDecision() {
        return tipoDecision;
    }

    public void setTipoDecision(TipoDecision tipoDecision) {
        this.tipoDecision = tipoDecision;
    }

    public Comite getComite() {
        return comite;
    }

    public void setComite(Comite comite) {
        this.comite = comite;
    }

    
}
