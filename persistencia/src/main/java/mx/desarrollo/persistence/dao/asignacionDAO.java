package mx.desarrollo.persistence.dao;

import jakarta.persistence.EntityManager;
import mx.desarrollo.entity.Asignacion;
import mx.desarrollo.persistence.persistence.AbstractDAO;

public class asignacionDAO extends AbstractDAO<Asignacion> {

    private final EntityManager entityManager;

    public asignacionDAO(EntityManager em) {
        super(Asignacion.class);
        this.entityManager = em;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
}