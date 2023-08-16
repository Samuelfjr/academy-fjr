
package util;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class JPAUtil {
    public static final javax.persistence.EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("academy_fjr");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}