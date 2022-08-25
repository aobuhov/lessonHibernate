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


//            Person person = session.get(Person.class, 1);
//            person.setName("#1");
//            session.save(person);
//            person.setName("#2");


//            Person person = session.get(Person.class, 1);
//            session.detach(person);
//            person.setName("#1");
//            session.merge(person);

//            Person person = session.get(Person.class, 1);
//            session.detach(person);
//            person.setName("#1");
//            session.merge(person);
//            person.setName("#2");
//            session.getTransaction().commit();  // в базе обновился person(id = 1) name = #1, а не на #2, что мне не понятно
            //потому что merge не возвращает переданный объект в Persistent Context, а воздаёт новый объект, помещённый в Persistent Context и возвращает его

//            Person person = session.get(Person.class, 1);
//            session.detach(person);
//            person.setName("#1");
//            session.merge(person);
//            person.setName("#2");
//            session.save(person);
//            session.getTransaction().commit();
            // в базе обновился person(id = 1) name = #1, а не на #2, и кроме этого создаётся новая строка person с name = #2
            //потому что merge не возвращает переданный объект в Persistent Context, а воздаёт новый объект, помещённый в Persistent Context и возвращает его
            //а надо так
            Person person = session.get(Person.class, 1);
            session.detach(person);
            person.setName("#1");
            Person otherPerson = (Person) session.merge(person);
            otherPerson.setName("#2");
            session.save(otherPerson);
            session.getTransaction().commit();
// в базе обновился person(id = 1) name = #1, а не на #2, и кроме этого создаётся новая строка person с name = #2

            session.getTransaction().commit();    //в результате у person id = 1 устанавливается name = #2, что логично

        }

    }
}
