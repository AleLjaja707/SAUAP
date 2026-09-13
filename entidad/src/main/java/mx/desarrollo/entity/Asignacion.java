package mx.desarrollo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "asignacion")
public class Asignacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAsignacion", nullable = false)
    private Integer idAsignacion;


    @NotNull
    @Column(name = "idProfesor", nullable = false)
    private Integer idProfesor;


    @NotNull
    @Column(name = "idUnidadAprendizaje", nullable = false)
    private Integer idUnidadAprendizaje;

    @NotNull
    @Column(name = "diaSemana", nullable = false)
    private String diaSemana;

    @NotNull
    @Column(name = "horaInicio", nullable = false)
    private Integer horaInicio;


    @NotNull
    @Column(name = "horaFin", nullable = false)
    private Integer horaFin;


    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }
    public Integer getIdUnidadA() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadA(Integer idUnidad) {
        this.idUnidadAprendizaje = idUnidad;
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }


    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Integer getHorasInicio() {
        return horaInicio;
    }

    public void setHorasInicio(Integer horasInicio) {
        this.horaInicio = horasInicio;
    }

    public Integer getHorasFin() {
        return horaFin;
    }

    public void setHorasFin(Integer horasFin) {
        this.horaFin = horasFin;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }



}