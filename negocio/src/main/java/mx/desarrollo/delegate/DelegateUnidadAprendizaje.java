package mx.desarrollo.delegate;

import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.entity.Unidad_aprendizaje;
import mx.desarrollo.persistence.integration.ServiceLocator;
import org.eclipse.persistence.jpa.jpql.tools.spi.IEntity;

import java.util.List;

public class DelegateUnidadAprendizaje {

    public void saveUnidadAprendizaje(Unidad_aprendizaje unidad){

        //usar metodo
        if(validarUnidad(unidad) == true) {
            ServiceLocator.getInstanceUnidadAprendizajeDAO().save(unidad);
        }

    }

    //consultar unidades existentes
    public List<Unidad_aprendizaje> getUnidadesAprendizaje() {
        return ServiceLocator.getInstanceUnidadAprendizajeDAO().findAll();
    }

    //eliminar unidades
    public void eliminarUnidad(Unidad_aprendizaje unidad){
        ServiceLocator.getInstanceUnidadAprendizajeDAO().delete(unidad);
    }

    //modificar unidad
    public void modificarUnidad(Unidad_aprendizaje unidad) {
        ServiceLocator.getInstanceUnidadAprendizajeDao().update(unidad);
    }



    //validar la unidad
    public boolean  validarUnidad(Unidad_aprendizaje unidad){

        //validar todos sus atributos
        if(unidad.getNombre() == null || unidad.getNombre().equals("")){
            return false;
        }
        if(unidad.getHorasLab()<0 || unidad.getHorasLab()>4){
            return false;
        }
        if(unidad.getHorasClase()<0 || unidad.getHorasClase()>4){
            return false;
        }
        if(unidad.getHorasTaller()<0 || unidad.getHorasTaller()>4){
            return false;
        }

        return true;
    }

}
