package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.entity.Unidad_aprendizaje;
import mx.desarrollo.entity.Usuario;
import mx.desarrollo.entity.asignacion;
import mx.desarrollo.persistence.persistence.AbstractDAO;

public class asignacionDAO extends AbstractDAO<asignacion> {

    private final EntityManager entityManager;

    public asignacionDAO(EntityManager em) {
        super(asignacion.class);
        this.entityManager = em;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}