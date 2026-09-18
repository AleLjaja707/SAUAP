package mx.desarrollo.ui;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.entity.Profesor;
import mx.desarrollo.entity.Unidad_aprendizaje;
import mx.desarrollo.facade.FacadeAsignacion;
import mx.desarrollo.facade.FacadeProfesor;
import mx.desarrollo.facade.FacadeUnidad;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class AsignacionBean implements Serializable {

    private static final long serialVersionUID = 1L;

    //use integer porque tenia errores con int
    private Integer idProfesor;
    private Integer idUnidadAprendizaje;
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    //lista para el dropdown
    public List<Profesor> getProfesores(){
        FacadeProfesor facade = new FacadeProfesor();
        return facade.obtenerProfesores();
    }

    public List<Unidad_aprendizaje> getUnidades(){
        FacadeUnidad facade = new FacadeUnidad();
        return facade.obtenerUnidades();
    }

    //lista de dias
    public List<String> getDiasSemana() {
        List<String> dias = new ArrayList<>();
        dias.add("Lunes");
        dias.add("Martes");
        dias.add("Miercoles");
        dias.add("Jueves");
        dias.add("Viernes");
        return dias;
    }

    //asignaciones ya existentes
    public List<Asignacion> getAsignaciones(){
        FacadeAsignacion facade = new FacadeAsignacion();
        return facade.obtenerAsignaciones();
    }
    //busca por id
    public String getNombreProfesor(int idProfesor){
        List<Profesor> profesores = getProfesores();
        for(Profesor p : profesores){
            if(p.getId() == idProfesor){
                return p .getNombre()+ " "  + p.getApellidoP();
            }
        }
        return "Desconocido";
    }

    //busca unidad por id
    public String getNombreUnidad(int idUnidad) {
        List<Unidad_aprendizaje> unidades = getUnidades();
        for (Unidad_aprendizaje u : unidades) {
            if (u.getIdUnidad() == idUnidad) {
                return u.getNombre();
            }
        }
        return "Desconocida";
    }

    public void asignar(){
        try{

            if(!horaInicio.isBefore(horaFin)){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Horario inválido", "La hora de inicio debe ser anterior a la hora de fin."));
                return;
            }
            FacadeAsignacion facade = new FacadeAsignacion();

            boolean exito = facade.asignarMateria(idProfesor, idUnidadAprendizaje, diaSemana, horaInicio, horaFin);

            if(exito){
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Éxito", "Unidad de aprendizaje asignada correctamente."));
                idProfesor = null;
                idUnidadAprendizaje = null;
                diaSemana = null;
                horaInicio = null;
                horaFin = null;
            }else{
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Horario no disponible", "No se puede realizar la asignación porque existe un traslape de horario."));
            }
        }catch(Exception e){
            e.printStackTrace();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ocurrió un error al guardar la asignación. Intente de nuevo."));
        }
    }

  //getter, setters
    public Integer getIdProfesor() { return idProfesor; }
    public void setIdProfesor(Integer idProfesor) { this.idProfesor = idProfesor; }

    public Integer getIdUnidadAprendizaje() { return idUnidadAprendizaje; }
    public void setIdUnidadAprendizaje(Integer idUnidadAprendizaje) { this.idUnidadAprendizaje = idUnidadAprendizaje; }

    public  String getDiaSemana() { return diaSemana; }
    public void setDiaSemana(String diaSemana) { this.diaSemana = diaSemana; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }



}
