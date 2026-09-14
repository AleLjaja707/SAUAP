package mx.desarrollo.facade;

import mx.desarrollo.delegate.DelegateUnidadAprendizaje;
import mx.desarrollo.entity.Unidad_aprendizaje;

import java.util.List;

public class FacadeUnidad {
    private final DelegateUnidadAprendizaje delegateUnidad;

    public FacadeUnidad() {
        this.delegateUnidad = new DelegateUnidadAprendizaje();
    }

    public void agregarUnidad(Unidad_aprendizaje unidad) {
        delegateUnidad.saveUnidadAprendizaje(unidad);
    }

    public void eliminarUnidad(Unidad_aprendizaje unidad) {
        delegateUnidad.eliminarUnidad(unidad);
    }

    public List<Unidad_aprendizaje> obtenerUnidades() {
        return delegateUnidad.getUnidadesAprendizaje();
    }

}
