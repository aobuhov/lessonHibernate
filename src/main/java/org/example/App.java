package org.example;

import org.example.model.Item;
import org.example.model.Passport;
import org.example.model.Person;
import org.hibernate.PersistentObjectException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

//            Person person = new Person("fff2");
//
//            Passport passport = new Passport(78);
//            person.setPassport(passport);//best practice
//
//            session.save(person);


//            Person person = session.get(Person.class, 15);
//            System.out.println(person.getPassport().getPassportNumber());


//            Passport passport = session.get(Passport.class, 16);
//            System.out.println(passport.getPerson().getName());


//            Person person = session.get(Person.class, 15);
//            person.getPassport().setPassportNumber(0);

            Person person = session.get(Person.class, 15);
            session.remove(person);


            session.getTransaction().commit();    //в результате у person id = 1 устанавливается name = #2, что логично

        }

    }
}
