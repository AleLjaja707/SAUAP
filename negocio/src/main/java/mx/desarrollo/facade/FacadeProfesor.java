package mx.desarrollo.facade;

import mx.desarrollo.delegate.DelegateProfesor;
import mx.desarrollo.delegate.DelegateUsuario;
import mx.desarrollo.entity.Profesor;
import mx.desarrollo.entity.Usuario;

public class FacadeProfesor {
    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }

    public void guardarProfesor(Profesor profesor){
        if (profesor.getNombre() == null || profesor.getNombre().length()>50){
            throw new IllegalArgumentException("Nombre invalido");
        }
        if (profesor.getApellidoP() == null || profesor.getApellidoP().length()>50){
            throw new IllegalArgumentException("Apellido invalido");
        }
        if (profesor.getApellidoM() == null || profesor.getApellidoM().length()>50){
            throw new IllegalArgumentException("Apellido invalido");
        }
        if (profesor.getRfc() == null || !profesor.getRfc().matches("^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{3}$")){
            throw new IllegalArgumentException("RFC no valido");
        }
        delegateProfesor.saveProfesor(profesor);
    }

}
