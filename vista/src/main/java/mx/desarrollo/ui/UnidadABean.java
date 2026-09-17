package mx.desarrollo.ui;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import mx.desarrollo.entity.Unidad_aprendizaje;
import mx.desarrollo.facade.FacadeUnidad;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UnidadABean implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idUnidad;
    private String nombre;
    private int horasClase;
    private int horasTaller;
    private int horasLaboratorio;

    private Unidad_aprendizaje unidadSeleccionada;


    //eliminar unidad
    public void eliminarUnidad(){
        if(unidadSeleccionada != null){
            FacadeUnidad facade = new FacadeUnidad();
            facade.eliminarUnidad(unidadSeleccionada);
            unidadSeleccionada = null;
        }

    }

    //obtener los cambios realizados a la unidad
    public void setNuevosAtributos(){
            unidadSeleccionada.setNombre(nombre);
            unidadSeleccionada.setHorasClase(horasClase);
            unidadSeleccionada.setHorasTaller(horasTaller);
            unidadSeleccionada.setHorasLaboratorio(horasLaboratorio);
        }


    public void cargarUnidadSeleccionada() {
        if(unidadSeleccionada != null){
            nombre = unidadSeleccionada.getNombre();
            horasClase = unidadSeleccionada.getHorasClase();
            horasTaller = unidadSeleccionada.getHorasTaller();
            horasLaboratorio = unidadSeleccionada.getHorasLaboratorio();
            idUnidad = unidadSeleccionada.getIdUnidad();
        }
    }

    //Modificar Unidad
    public void modificarUnidad() {
        if (unidadSeleccionada != null) {
            setNuevosAtributos();
            FacadeUnidad facade = new FacadeUnidad();
            facade.modificarUnidad(unidadSeleccionada);
        }
        }


    //crear objeto
public void guardarUnidad(){
    Unidad_aprendizaje unidad = new Unidad_aprendizaje();

    unidad.setNombre(nombre);
    unidad.setHorasClase(horasClase);
    unidad.setHorasTaller(horasTaller);
    unidad.setHorasLaboratorio(horasLaboratorio);

    FacadeUnidad facade = new FacadeUnidad();
    //llamar a facade
    facade.agregarUnidad(unidad);
}

    //Consultar lista de unidades
    public List<Unidad_aprendizaje> getUnidades(){
        FacadeUnidad facade = new FacadeUnidad();
    //llamar a facade
    return facade.obtenerUnidades();
    }








    //GETTERS Y SETTERS
    public int getIdUnidad() {return idUnidad;}
    public void setIdUnidad(int idUnidad) {this.idUnidad = idUnidad;}

    public int getHorasClase() {return horasClase;}
    public void setHorasClase(int horasClase) {this.horasClase = horasClase;}

    public int getHorasTaller() {return horasTaller;}
    public void setHorasTaller(int horasTaller) {this.horasTaller = horasTaller;}

    public int getHorasLab() {return horasLaboratorio;}
    public void setHorasLab(int horasLaboratorio) {this.horasLaboratorio = horasLaboratorio;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Unidad_aprendizaje getUnidadSeleccionada() {return unidadSeleccionada;}
    public void setUnidadSeleccionada(Unidad_aprendizaje unidad) {this.unidadSeleccionada = unidad;}
}
