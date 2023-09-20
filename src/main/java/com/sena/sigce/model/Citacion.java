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
@Table(name="citacion")
public class Citacion {
    
    //Atributos

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idCitacion;
    
    

    @Column(name="motivo_Cit",nullable = false)
    private String motivo_Cit;

    @Column(name="gravedad_Cit",nullable = false)
    private String gravedad_Cit;

    @Column(name="materia_Cit",nullable = false)
    private String materia_Cit;

    @Column(name="docu_Cit",nullable = false)
    private String docu_Cit;

    //Relaciones

    @ManyToOne
    @JoinColumn(name="FK_id_Apr",nullable = false)
    private Aprendiz aprendiz;

    @ManyToOne
    @JoinColumn(name="FK_id_Ins",nullable = false)
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name="Fk_id_Est",nullable = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name="Fk_id_Art",nullable = false)
    private Articulo articulo;
  
    //Constructores
    public Citacion() {
    }
    
    public Citacion(Integer idCitacion, String motivo_Cit, String gravedad_Cit, String materia_Cit, String docu_Cit,
            Aprendiz aprendiz, Instructor instructor, Estado estado, Articulo articulo) {
        this.idCitacion = idCitacion;
        this.motivo_Cit = motivo_Cit;
        this.gravedad_Cit = gravedad_Cit;
        this.materia_Cit = materia_Cit;
        this.docu_Cit = docu_Cit;
        this.aprendiz = aprendiz;
        this.instructor = instructor;
        this.estado = estado;
        this.articulo = articulo;
    }

    //Getters and Setters

    public Integer getIdCitacion() {
        return idCitacion;
    }

    public void setIdCitacion(Integer idCitacion) {
        this.idCitacion = idCitacion;
    }

    public String getMotivo_Cit() {
        return motivo_Cit;
    }

    public void setMotivo_Cit(String motivo_Cit) {
        this.motivo_Cit = motivo_Cit;
    }

    public String getGravedad_Cit() {
        return gravedad_Cit;
    }

    public void setGravedad_Cit(String gravedad_Cit) {
        this.gravedad_Cit = gravedad_Cit;
    }

    public String getMateria_Cit() {
        return materia_Cit;
    }

    public void setMateria_Cit(String materia_Cit) {
        this.materia_Cit = materia_Cit;
    }

    public String getDocu_Cit() {
        return docu_Cit;
    }

    public void setDocu_Cit(String docu_Cit) {
        this.docu_Cit = docu_Cit;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

}
