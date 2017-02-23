package config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by scheldejonas on 22/02/2017.
 */
public class DataConfig {

    private static DataConfig singleton = null;
    private EntityManagerFactory entityManagerFactory = null;
    private static String host = "";
    private final String databaseName;
    private final int port;
    private String username;
    private String password;

    public static DataConfig getSingleton() {
        if (singleton == null) {
            singleton = new DataConfig();
        }
        return singleton;
    }

    private DataConfig() {
        this.host = "localhost";
        this.port = 3306;
        this.databaseName = "trainingjpa";
        this.username = "trainingjpauser";
        this.password = "Trainingjpauser";
        this.entityManagerFactory = createEntityManagerFactory();
    }

    private EntityManagerFactory createEntityManagerFactory() {
        Map myProperties = new HashMap();
        myProperties.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        myProperties.put("hibernate.connection.url", String.format("jdbc:mysql://%s:%s/%s", host, port, databaseName));
        myProperties.put("hibernate.connection.username", String.format("%s", this.username));
        myProperties.put("hibernate.connection.password", String.format("%s", this.password));
        myProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL57InnoDBDialect");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("trainingjpa", myProperties);
        return entityManagerFactory;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return this.entityManagerFactory;
    }


}