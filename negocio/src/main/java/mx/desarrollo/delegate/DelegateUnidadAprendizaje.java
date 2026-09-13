package mx.desarrollo.delegate;

import mx.desarrollo.entity.Unidad_aprendizaje;
import mx.desarrollo.persistence.integration.ServiceLocator;

public class DelegateUnidadAprendizaje {
    public void saveUnidadAprendizaje(Unidad_aprendizaje unidad){
        ServiceLocator.getInstanceUnidadAprendizajeDAO().save(unidad);
    }
}
