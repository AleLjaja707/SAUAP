package mx.desarrollo.ui;


import mx.desarrollo.entity.Unidad_aprendizaje;
import mx.desarrollo.facade.FacadeUnidad;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.List;

@Named
@RequestScoped
public class UnidadABean {

    private  String nombre;
    private  int horasClase;
    private  int horasTaller;
    private  int horasLab;

    //unidad seleccionada de la tabla de consultas
    private Unidad_aprendizaje unidadSeleccionada;

    //eliminar unidad
    public void eliminarUnidad(){
        FacadeUnidad facade = new FacadeUnidad();
        facade.eliminarUnidad(unidadSeleccionada);
    }

    //obtener los cambios realizados a la unidad
    public void setNuevosAtributos(){
            unidadSeleccionada.setNombre(nombre);
            unidadSeleccionada.setHorasClase(horasClase);
            unidadSeleccionada.setHorasTaller(horasTaller);
            unidadSeleccionada.setHorasLab(horasLab);
        }


    public void cargarUnidadSeleccionada() {
        nombre = unidadSeleccionada.getNombre();
        horasClase = unidadSeleccionada.getHorasClase();
        horasTaller = unidadSeleccionada.getHorasTaller();
        horasLab = unidadSeleccionada.getHorasLab();
    }

    //Modificar Unidad
    public void modificarUnidad() {
        cargarUnidadSeleccionada();
        FacadeUnidad facade = new FacadeUnidad();
            facade.modificarUnidad(unidadSeleccionada);
        }


    //crear objeto
public void guardarUnidad(){
    Unidad_aprendizaje unidad = new Unidad_aprendizaje();

    unidad.setNombre(nombre);
    unidad.setHorasClase(horasClase);
    unidad.setHorasTaller(horasTaller);
    unidad.setHorasLab(horasLab);

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
    public int getHorasClase() {return horasClase;}
    public void setHorasClase(int horasClase) {this.horasClase = horasClase;}

    public int getHorasTaller() {return horasTaller;}
    public void setHorasTaller(int horasTaller) {this.horasTaller = horasTaller;}

    public int getHorasLab() {return horasLab;}
    public void setHorasLab(int horasLab) {this.horasLab = horasLab;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public Unidad_aprendizaje getUnidadSeleccionada() {return unidadSeleccionada;}
    public void setUnidadSeleccionada(Unidad_aprendizaje unidad) {this.unidadSeleccionada = unidad;}
}
