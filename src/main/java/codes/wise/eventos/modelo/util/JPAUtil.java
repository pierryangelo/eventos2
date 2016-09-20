package codes.wise.eventos.modelo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory = Persistence
            .createEntityManagerFactory("eventos");

    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
