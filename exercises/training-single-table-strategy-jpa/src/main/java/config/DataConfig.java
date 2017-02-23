package config;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by scheldejonas on 22/02/2017.
 */
public class DataConfig {

    private static EntityManagerFactory entityManagerFactory = null;

    public DataConfig() {
    }

    public static EntityManagerFactory getInstanceOfEntityManagerFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = getManagerFactory();
        }
        return entityManagerFactory;
    }

    private static EntityManagerFactory getManagerFactory() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("trainingjpa");
        return entityManagerFactory;
    }


}