package lk.ijse.hibernateTest.util;

import lk.ijse.hibernateTest.entity.Customer;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfiguaration {

    private static SessionFactoryConfiguaration sessionFactory;

    public static SessionFactoryConfiguaration getInstance(){
        return null==sessionFactory ? sessionFactory=new SessionFactoryConfiguaration() : sessionFactory;
    }

    public Session getSession() throws HibernateException {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

        Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Customer.class).getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();


        SessionFactory sessionFactory=metadata.getSessionFactoryBuilder().build();

        return sessionFactory.openSession();

    }
}
