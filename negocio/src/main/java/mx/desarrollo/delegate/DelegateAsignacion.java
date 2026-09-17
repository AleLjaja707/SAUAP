package mx.desarrollo.delegate;

import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.persistence.integration.ServiceLocator;

import java.util.List;

public class DelegateAsignacion {

    //CRUD DE ASIGNACIONES

    public boolean asignarMateria(Integer idProfesor, Integer idUnidadAprendizaje, String diaSemana, Integer horaInicio, Integer horaFin){
          List<Asignacion> asignaciones = ServiceLocator.getInstanceAsignacionDAO().findAll();

          for(Asignacion asignacion : asignaciones){
              if(asignacion.getIdProfesor().equals(idProfesor) && asignacion.getIdUnidadA().equals(idUnidadAprendizaje) && asignacion.getDiaSemana().equals(diaSemana) && asignacion.getHorasInicio().equals(horaInicio) && asignacion.getHorasFin().equals(horaFin) ){
                return false;
              }
          }

          Asignacion nuevaAsignacion = new Asignacion();
          nuevaAsignacion.setIdProfesor(idProfesor);
          nuevaAsignacion.setIdUnidadA(idUnidadAprendizaje);
          nuevaAsignacion.setDiaSemana(diaSemana);
          nuevaAsignacion.setHorasInicio(horaInicio);
          nuevaAsignacion.setHorasFin(horaFin);

          ServiceLocator.getInstanceAsignacionDAO().save(nuevaAsignacion);
          return true;
    }


    //consultar asignaciones existentes
    public List<Asignacion> getAsignaciones() {
        return ServiceLocator.getInstanceAsignacionDAO().findAll();
    }

    //actualizar
    public void actualizarAsignacion(Asignacion asignacion){
        ServiceLocator.getInstanceAsignacionDAO().update(asignacion);
    }

    //eliminar
    public void eliminarAsignacion(Asignacion asignacion){
        ServiceLocator.getInstanceAsignacionDAO().delete(asignacion);
    }

    //traslape

    public boolean traslape(int idProfesor, String diaSemana, int horaInicio, int horaFin){
        List<Asignacion> asignaciones = ServiceLocator.getInstanceAsignacionDAO().findAll();

        for (Asignacion asignacion: asignaciones) {
            if(asignacion.getIdProfesor().equals(idProfesor) && asignacion.getDiaSemana().equals(diaSemana)) {

                if(horaInicio< asignacion.getHorasFin() && horaFin> asignacion.getHorasInicio()) {

                    return true;
                }
            }
        }
        return false;
    }

}
