package org.example;

import org.example.model.Item;
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
                .addAnnotatedClass(Item.class);
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();) {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            Person person = new Person("Test cascade", 30);

            person.addItem(new Item("Test cascade item1"));
            person.addItem(new Item("Test cascade item2"));
            person.addItem(new Item("Test cascade item3"));

            session.save(person);

            session.getTransaction().commit();    //в результате у person id = 1 устанавливается name = #2, что логично

        }

    }
}
