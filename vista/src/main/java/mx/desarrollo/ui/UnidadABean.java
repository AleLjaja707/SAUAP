package mx.desarrollo.ui;


import mx.desarrollo.entity.Unidad_aprendizaje;
import mx.desarrollo.facade.FacadeUnidad;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class UnidadABean {

    private  String nombre;
    private  int horasClase;
    private  int horasTaller;
    private  int horasLab;


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
    System.out.println("BEAN: guardarUnidad");
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
}
