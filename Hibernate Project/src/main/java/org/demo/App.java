package org.demo;

import org.demo.entities.Brand;
import org.demo.entities.User;
import org.demo.entities.UserProfile;
import org.demo.entities.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

        SessionFactory factory=meta.getSessionFactoryBuilder().build();
        Session session=factory.openSession();

        Transaction t=session.beginTransaction();
        // Save a user with a profile (one-to-one)
        User user = new User();
        user.setUsername("john_doe");

        UserProfile userProfile = new UserProfile();
        userProfile.setFullName("John Doe");

        user.setProfile(userProfile);

        session.save(user);

        // Save a user with multiple vehicles (one-to-many)
        User anotherUser = new User();
        anotherUser.setUsername("jane_doe");

        Vehicle vehicle1 = new Vehicle();
        vehicle1.setModel("Toyota Camry");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setModel("Honda Accord");

        anotherUser.addVehicle(vehicle1);
        anotherUser.addVehicle(vehicle2);

        session.save(anotherUser);

        // Save a vehicle with a brand (many-to-one)
        Brand toyotaBrand = new Brand();
        toyotaBrand.setName("Toyota");

        Vehicle toyotaVehicle = new Vehicle();
        toyotaVehicle.setModel("Corolla");
        toyotaVehicle.setBrand(toyotaBrand);

        session.save(toyotaBrand);
        session.save(toyotaVehicle);

        // Save a user with preferred brands (many-to-many)
        User yetAnotherUser = new User();
        yetAnotherUser.setUsername("bob_smith");

        Brand hondaBrand = new Brand();
        hondaBrand.setName("Honda");

        yetAnotherUser.getPreferredBrands().add(toyotaBrand);
        yetAnotherUser.getPreferredBrands().add(hondaBrand);


        session.persist(user);

        t.commit();
        session.close();
    }
}
