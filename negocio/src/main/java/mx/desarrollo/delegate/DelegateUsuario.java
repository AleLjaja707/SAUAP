package mx.desarrollo.delegate;

import mx.desarrollo.entity.Usuario;
import mx.desarrollo.persistence.integration.ServiceLocator;


import java.util.List;

public class DelegateUsuario {
    public Usuario login(String password, String correo){
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = ServiceLocator.getInstanceUsuarioDAO().findAll();

        for(Usuario us:usuarios){
            if(us.getPassword().equalsIgnoreCase(password) && us.getCorreo().equalsIgnoreCase(correo)){
                usuario = us;
            }
        }
        return usuario;
    }

    public void saveUsuario(Usuario usuario){

        ServiceLocator.getInstanceUsuarioDAO().save(usuario);
    }

}