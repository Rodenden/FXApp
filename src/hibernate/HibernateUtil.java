package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
    public class HibernateUtil {
        private static SessionFactory sessionFactory;

        public HibernateUtil() {
            getSessionFactory();
        }

        public SessionFactory getSessionFactory() {
            if (sessionFactory == null) {
                try {
                    Configuration configuration = new Configuration()
                            .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                            .setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/fxschema?serverTimezone=UTC") //user_autos - schema
                            .setProperty("hibernate.connection.username", "root")
                            .setProperty("hibernate.connection.password", "root")
                            .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect")
                            .setProperty("hibernate.show_sql", "true")
                            .setProperty("hibernate.format_sql", "true")
                            //.setProperty("hibernate.hbm2ddl.auto", "update")
                            .addAnnotatedClass(model.User.class)
                            .addAnnotatedClass(model.Film.class);
                    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                    sessionFactory = configuration.buildSessionFactory(builder.build());

                } catch (Exception e) {
                    System.out.println("Исключение!" + e);
                }
            }
            return sessionFactory;
        }

}
