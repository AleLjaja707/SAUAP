package mx.desarrollo.delegate;

import mx.desarrollo.entity.Usuario;
import mx.desarrollo.persistence.integration.ServiceLocator;


import java.util.List;

public class DelegateUsuario {
    public Usuario login(String correo, String password){
        List<Usuario> usuarios = ServiceLocator.getInstanceUsuarioDAO().findAll();

        for(Usuario us:usuarios){
            if(us.getCorreo().equalsIgnoreCase(correo) && us.getPassword().equalsIgnoreCase(password)){
                return us;
            }
        }
        return null;
    }

    public void saveUsuario(Usuario usuario){

        ServiceLocator.getInstanceUsuarioDAO().save(usuario);
    }

}